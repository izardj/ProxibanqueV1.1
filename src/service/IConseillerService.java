package service;

import java.util.Collection;

import metier.Client;
import metier.Compte;
import metier.Conseiller;
import service.exceptions.ClientGererParAutreConseillerException;
import service.exceptions.ClientPossedeDejaConseillerException;
import service.exceptions.ClientSansCompteException;
import service.exceptions.MontantNegatifException;
import service.exceptions.NombreClientsMaxAtteintException;
import service.exceptions.SoldeInsuffisantException;
import service.exceptions.SommeSoldesInsuffisanteException;

public interface IConseillerService {
	/**
	 * Méthode permettant d'ajouter un client à un conseiller
	 * 
	 * @param conseiller
	 *            Conseiller du client
	 * @param client
	 *            Client à ajouter au conseiller
	 * @throws ClientPossedeDejaConseillerException
	 *             Si le client possède déjà un conseiller
	 * @throws NombreClientsMaxAtteintException
	 *             Si le conseiller a déjà 10 clients
	 */
	public void ajouterClient(Conseiller conseiller, Client client)
			throws ClientPossedeDejaConseillerException, NombreClientsMaxAtteintException;

	/**
	 * Méthode permettant de supprimer un client ainsi que les comptes et cartes
	 * associés
	 * 
	 * @param conseiller
	 *            Conseiller gérant le client à supprimer
	 * @param client
	 *            Client à supprimer
	 * @throws ClientGererParAutreConseillerException
	 *             Si le client est géré par un autre conseiller
	 */
	public void supprimerClient(Conseiller conseiller, Client client) throws ClientGererParAutreConseillerException;

	/**
	 * Méthode permettant d'afficher les informations du client
	 * @param conseiller Conseiller gérant le client à afficher
	 * @param client Client dont on veut les informations
	 * @throws ClientGererParAutreConseillerException Si le client est géré par un autre conseiller
	 */
	public void afficherClient(Conseiller conseiller, Client client) throws ClientGererParAutreConseillerException;

	public void modifierClient(Conseiller conseiller, Client client);

	/**
	 * Méthode permettant d'effectuer des virements compte à compte
	 * 
	 * @param compteEmetteur
	 *            Compte depuis lequel l'argent est prélevé
	 * @param compteRecepteur
	 *            Compte vers lequel l'argent est ajouté
	 * @param montant
	 *            Montant du virement
	 * @throws SoldeInsuffisantException
	 *             Si le solde du compte émeteur est insuffisant
	 * @throws MontantNegatifException
	 *             Si le montant à virer est négatif
	 */
	public void effectuerVirement(Compte compteEmetteur, Compte compteRecepteur, double montant)
			throws SoldeInsuffisantException, MontantNegatifException;
	/**
	 * Méthode permettant de simuler des crédits
	 * @param typeCredit Type de crédit à simuler
	 */
	public void simulerCredit(String typeCredit);

	/**
	 * Méthode permettant de gérer le patrimoine à condition que la somme des
	 * soldes du client soit supérieure strictement à 500000€
	 * 
	 * @param client
	 *            Client dont le patrimoine est à gérer
	 * @return La somme des soldes du compte client
	 * @throws SommeSoldesInsuffisanteException
	 *             Si la somme des solde du client est inférieur strictement à
	 *             500000€
	 * @throws ClientSansCompteException
	 *             Si le client n'a pas de compte
	 */
	public double gererPatrimoine(Client client) throws SommeSoldesInsuffisanteException, ClientSansCompteException;
	
	// ajouter un client "orphelin"( sans conseiller)
	public void creerClient(Client client);
	
	// lister tous les clients
	public Collection<Client> listerClients();

}
