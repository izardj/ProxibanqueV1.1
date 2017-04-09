package tests;

import org.junit.Assert;
import org.junit.Test;

import metier.Client;
import metier.CompteCourant;
import metier.CompteEpargne;
import service.ConseillerService;
import service.IConseillerService;
import service.exceptions.ClientSansCompteException;
import service.exceptions.SommeSoldesInsuffisanteException;

public class GererPatrimoineTests {

	@Test
	public void testGererPatrimoine() throws SommeSoldesInsuffisanteException, ClientSansCompteException {
		IConseillerService cs = new ConseillerService();
		Client cl = new Client();
		CompteEpargne c1 = new CompteEpargne();
		c1.setSolde(300000);
		CompteCourant c2 = new CompteCourant();
		c2.setSolde(400000);

		cl.setCompteEpargne(c1);
		cl.setCompteCourant(c2);
		
		double sommeSoldes = cs.gererPatrimoine(cl);
	
		Assert.assertEquals(700000, sommeSoldes, 0);
	}
	
	@Test(expected = ClientSansCompteException.class)
	public void testGererPatrimoineClientSansCompte() throws SommeSoldesInsuffisanteException, ClientSansCompteException {
		IConseillerService cs = new ConseillerService();
		Client cl = new Client();
		
		cs.gererPatrimoine(cl);
	}
	
	@Test(expected = SommeSoldesInsuffisanteException.class)
	public void testGererPatrimoineClientSommeSoldesInsuffisante() throws SommeSoldesInsuffisanteException, ClientSansCompteException {
		IConseillerService cs = new ConseillerService();
		Client cl = new Client();
		CompteEpargne c1 = new CompteEpargne();
		c1.setSolde(100000);
		CompteCourant c2 = new CompteCourant();
		c2.setSolde(20000);

		cl.setCompteEpargne(c1);
		cl.setCompteCourant(c2);
		
		cs.gererPatrimoine(cl);

	}
}
