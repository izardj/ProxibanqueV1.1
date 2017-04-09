package service;

import java.util.ArrayList;
import java.util.Collection;

import dao.DaoClient;
import dao.IDaoCRUD;
import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;
import service.exceptions.ClientGererParAutreConseillerException;
import service.exceptions.ClientPossedeDejaConseillerException;
import service.exceptions.ClientSansCompteException;
import service.exceptions.MontantNegatifException;
import service.exceptions.NombreClientsMaxAtteintException;
import service.exceptions.SoldeInsuffisantException;
import service.exceptions.SommeSoldesInsuffisanteException;

public class ConseillerService implements IConseillerService {
	
	private IDaoCRUD<Client> idao = new DaoClient();
	
	@Override
	public Collection<Client> listerClients() {
		Collection<Client> listeClients = idao.lister(); 
		return listeClients;
	}

	@Override
	public void creerClient(Client client) {
		// TODO Auto-generated method stub
		idao.creer(client);
	}

	@Override
	public void ajouterClient(Conseiller conseiller, Client client)
			throws ClientPossedeDejaConseillerException, NombreClientsMaxAtteintException {
		if (client.getConseiller() == null) {
			if (conseiller.getClients().size() < 10) {
				client.setConseiller(conseiller);
				Collection<Client> colCl = conseiller.getClients();
				colCl.add(client);
				conseiller.setClients(colCl);
			} else {
				throw new NombreClientsMaxAtteintException("Le conseiller a déjà 10 clients");
			}
		} else {
			throw new ClientPossedeDejaConseillerException("Le client possède déjà un conseiller");
		}

	}

	@Override
	public void effectuerVirement(Compte compteEmetteur, Compte compteRecepteur, double montant)
			throws SoldeInsuffisantException, MontantNegatifException {
		if (montant >= 0) {
			if (compteEmetteur instanceof CompteEpargne) {
				if (montant > compteEmetteur.getSolde()) {
					throw new SoldeInsuffisantException("Solde insuffisant");
				}
			}
			if (compteEmetteur instanceof CompteCourant) {
				double decouvert = ((CompteCourant) compteEmetteur).getDecouvert();
				if (montant > compteEmetteur.getSolde() + decouvert) {
					throw new SoldeInsuffisantException("Solde insuffisant");
				}
			}
		} else {
			throw new MontantNegatifException("Montant négatif");
		}
		compteEmetteur.setSolde(compteEmetteur.getSolde() - montant);
		compteRecepteur.setSolde(compteRecepteur.getSolde() + montant);
	}

	@Override
	public void simulerCredit(String typeCredit) {
		System.out.println("Vous avez simuler un crédit " + typeCredit);

	}

	@Override
	public double gererPatrimoine(Client client) throws SommeSoldesInsuffisanteException, ClientSansCompteException {
		double sommeSoldes = 0;
		Collection<Compte> colCo = new ArrayList<Compte>();

		if (client.getCompteCourant() != null) {
			colCo.add(client.getCompteCourant());
			sommeSoldes += client.getCompteCourant().getSolde();
		}

		if (client.getCompteEpargne() != null) {
			colCo.add(client.getCompteEpargne());
			sommeSoldes += client.getCompteEpargne().getSolde();
		}

		if (colCo.isEmpty()) {
			throw new ClientSansCompteException("Le client n'a pas de compte");
		}
		if (sommeSoldes <= 500000) {
			throw new SommeSoldesInsuffisanteException("La somme des soldes des comptes est insuffisante");
		}

		return sommeSoldes;
	}

	@Override
	public void supprimerClient(Conseiller conseiller, Client client) throws ClientGererParAutreConseillerException {
		if (!conseiller.getClients().contains(client)) {
			throw new ClientGererParAutreConseillerException("Ce conseiller ne gère pas ce client");
		}

		if (client.getCompteCourant() != null) {
			if (client.getCompteCourant().getCarte() != null) {
				client.getCompteCourant().setCarte(null);
			}
			client.setCompteCourant(null);
		}

		// Suppression du client
		Collection<Client> colCl = conseiller.getClients();
		colCl.remove(client);
		conseiller.setClients(colCl);
	}

	@Override
	public void afficherClient(Conseiller conseiller, Client client) throws ClientGererParAutreConseillerException {
		if (!conseiller.getClients().contains(client)) {
			throw new ClientGererParAutreConseillerException("Ce conseiller ne gère pas ce client");
		}
	}

	@Override
	public void modifierClient(Conseiller conseiller, Client client) {
		// TODO Auto-generated method stub

	}

}
