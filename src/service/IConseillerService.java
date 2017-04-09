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
	 * M�thode permettant d'ajouter un client � un conseiller
	 * 
	 * @param conseiller
	 *            Conseiller du client
	 * @param client
	 *            Client � ajouter au conseiller
	 * @throws ClientPossedeDejaConseillerException
	 *             Si le client poss�de d�j� un conseiller
	 * @throws NombreClientsMaxAtteintException
	 *             Si le conseiller a d�j� 10 clients
	 */
	public void ajouterClient(Conseiller conseiller, Client client)
			throws ClientPossedeDejaConseillerException, NombreClientsMaxAtteintException;

	/**
	 * M�thode permettant de supprimer un client ainsi que les comptes et cartes
	 * associ�s
	 * 
	 * @param conseiller
	 *            Conseiller g�rant le client � supprimer
	 * @param client
	 *            Client � supprimer
	 * @throws ClientGererParAutreConseillerException
	 *             Si le client est g�r� par un autre conseiller
	 */
	public void supprimerClient(Conseiller conseiller, Client client) throws ClientGererParAutreConseillerException;

	/**
	 * M�thode permettant d'afficher les informations du client
	 * @param conseiller Conseiller g�rant le client � afficher
	 * @param client Client dont on veut les informations
	 * @throws ClientGererParAutreConseillerException Si le client est g�r� par un autre conseiller
	 */
	public void afficherClient(Conseiller conseiller, Client client) throws ClientGererParAutreConseillerException;

	public void modifierClient(Conseiller conseiller, Client client);

	/**
	 * M�thode permettant d'effectuer des virements compte � compte
	 * 
	 * @param compteEmetteur
	 *            Compte depuis lequel l'argent est pr�lev�
	 * @param compteRecepteur
	 *            Compte vers lequel l'argent est ajout�
	 * @param montant
	 *            Montant du virement
	 * @throws SoldeInsuffisantException
	 *             Si le solde du compte �meteur est insuffisant
	 * @throws MontantNegatifException
	 *             Si le montant � virer est n�gatif
	 */
	public void effectuerVirement(Compte compteEmetteur, Compte compteRecepteur, double montant)
			throws SoldeInsuffisantException, MontantNegatifException;
	/**
	 * M�thode permettant de simuler des cr�dits
	 * @param typeCredit Type de cr�dit � simuler
	 */
	public void simulerCredit(String typeCredit);

	/**
	 * M�thode permettant de g�rer le patrimoine � condition que la somme des
	 * soldes du client soit sup�rieure strictement � 500000�
	 * 
	 * @param client
	 *            Client dont le patrimoine est � g�rer
	 * @return La somme des soldes du compte client
	 * @throws SommeSoldesInsuffisanteException
	 *             Si la somme des solde du client est inf�rieur strictement �
	 *             500000�
	 * @throws ClientSansCompteException
	 *             Si le client n'a pas de compte
	 */
	public double gererPatrimoine(Client client) throws SommeSoldesInsuffisanteException, ClientSansCompteException;
	
	// ajouter un client "orphelin"( sans conseiller)
	public void creerClient(Client client);
	
	// lister tous les clients
	public Collection<Client> listerClients();

}
