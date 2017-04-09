package tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import metier.Client;
import metier.CompteCourant;
import metier.Conseiller;
import metier.CarteVisaElectron;
import service.ConseillerService;
import service.IConseillerService;
import service.exceptions.ClientGererParAutreConseillerException;

public class SupprimerClientTests {

	@Test
	public void testSupprimerClient() throws ClientGererParAutreConseillerException {
		IConseillerService cs = new ConseillerService();
		Client cl = new Client();
		Conseiller cons = new Conseiller();

		// collection simulant les clients sauvegardées
		Collection<Client> colCl = cons.getClients();
		colCl.add(cl);

		// ajouter un client au conseiller
		cons.setClients(colCl);

		// supprimer le client
		cs.supprimerClient(cons, cl);

		// la collection ne doit plus contenir le client
		Assert.assertFalse(cons.getClients().contains(cl));
	}
	
	@Ignore
	@Test
	public void testSupprimerClientDoitEffacerCompte() throws ClientGererParAutreConseillerException {
		IConseillerService cs = new ConseillerService();
		Client cl = new Client();
		Conseiller cons = new Conseiller();
		CompteCourant cc = new CompteCourant();

		// collections simulant les données sauvegardées
		Collection<CompteCourant> colCpt = new ArrayList<CompteCourant>();
		colCpt.add(cc);
		Collection<Client> colCl = cons.getClients();
		colCl.add(cl);

		// ajouter un client au conseiller
		cons.setClients(colCl);

		// ajouter compte courant au client
		Iterator<CompteCourant> it = colCpt.iterator();
		cl.setCompteCourant(it.next());

		// supprimer le client
		cs.supprimerClient(cons, cl);

		// la collection ne doit plus contenir le compte courant du client
		Assert.assertFalse(colCpt.contains(cc));

	}

	@Ignore
	@Test
	public void testSupprimerClientDoitEffacerCarte() throws ClientGererParAutreConseillerException {
		IConseillerService cs = new ConseillerService();
		Client cl = new Client();
		Conseiller cons = new Conseiller();
		CompteCourant cc = new CompteCourant();
		CarteVisaElectron cve = new CarteVisaElectron();

		// collections simulant les données sauvegardées
		Collection<CompteCourant> colCpt = new ArrayList<CompteCourant>();
		colCpt.add(cc);
		Collection<CarteVisaElectron> colCarte = new ArrayList<CarteVisaElectron>();
		colCarte.add(cve);
		Collection<Client> colCl = cons.getClients();
		colCl.add(cl);

		// ajouter un client au conseiller
		cons.setClients(colCl);

		// ajouter carte visa electron au compte courant
		Iterator<CarteVisaElectron> it = colCarte.iterator();
		cc.setCarte(it.next());
		// ajouter compte courant au client
		Iterator<CompteCourant> it2 = colCpt.iterator();
		cl.setCompteCourant(it2.next());

		// supprimer le client
		cs.supprimerClient(cons, cl);

		// la collection ne doit plus contenir la carte du compte courant du
		// client
		Assert.assertFalse(colCarte.contains(cve));
		
	}
	
	@Test(expected = ClientGererParAutreConseillerException.class)
	public void testSupprimerClientAutreConseiller() throws ClientGererParAutreConseillerException{
		IConseillerService cs = new ConseillerService();
		Client cl = new Client();
		Conseiller cons = new Conseiller();
		CompteCourant cc = new CompteCourant();

		// collections simulant les données sauvegardées
		Collection<CompteCourant> colCpt = new ArrayList<CompteCourant>();
		colCpt.add(cc);
		Collection<Client> colCl = cons.getClients();
		colCl.add(cl);

		// ajouter un client au conseiller
		cons.setClients(colCl);
		
		Conseiller cons2 = new Conseiller();
		
		// supprimer le client
		cs.supprimerClient(cons2, cl);
		
	}
}
