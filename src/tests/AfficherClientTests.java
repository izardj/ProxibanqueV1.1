package tests;

import java.util.Collection;

import org.junit.Test;

import metier.Client;
import metier.Conseiller;
import service.ConseillerService;
import service.IConseillerService;
import service.exceptions.ClientGererParAutreConseillerException;

public class AfficherClientTests {

	@Test(expected = ClientGererParAutreConseillerException.class)
	public void testAfficherClientAutreConseiller() throws ClientGererParAutreConseillerException{
		IConseillerService cs = new ConseillerService();
		Client cl = new Client();
		Conseiller cons = new Conseiller();
		Conseiller cons2 = new Conseiller();

		// ajouter un client au conseiller
		Collection<Client> colCl = cons.getClients();
		colCl.add(cl);
		cons.setClients(colCl);
		
		
		// afficher client d'un autre conseiller
		cs.afficherClient(cons2, cl);
	}

}
