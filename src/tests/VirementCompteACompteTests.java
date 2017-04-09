package tests;

import org.junit.Assert;
import org.junit.Test;

import metier.CompteCourant;
import metier.CompteEpargne;
import service.IConseillerService;
import service.ConseillerService;
import service.exceptions.MontantNegatifException;
import service.exceptions.SoldeInsuffisantException;

public class VirementCompteACompteTests {

	@Test
	public void testEffectuerVirementSoldeEmetteurEstDebite() throws SoldeInsuffisantException, MontantNegatifException {
		IConseillerService cs = new ConseillerService();
		CompteEpargne c1 = new CompteEpargne();
		CompteCourant c2 = new CompteCourant();
	
		c1.setSolde(1000);
		c2.setSolde(300);
		cs.effectuerVirement(c1, c2, 500);
	
		Assert.assertEquals(500, c1.getSolde(), 0);
	}

	@Test
	public void testEffectuerVirementSoldeRecepteurEstCredite() throws SoldeInsuffisantException, MontantNegatifException {
		IConseillerService cs = new ConseillerService();
		CompteEpargne c1 = new CompteEpargne();
		CompteCourant c2 = new CompteCourant();
	
		c1.setSolde(1000);
		c2.setSolde(300);
		cs.effectuerVirement(c1, c2, 500);
	
		Assert.assertEquals(800, c2.getSolde(), 0);
	}

	@Test(expected = MontantNegatifException.class)
	public void testEffectuerVirementMontantNegatif() throws SoldeInsuffisantException, MontantNegatifException {
		IConseillerService cs = new ConseillerService();
		CompteEpargne c1 = new CompteEpargne();
		CompteCourant c2 = new CompteCourant();
	
		cs.effectuerVirement(c1, c2, -20);
	}

	@Test(expected = SoldeInsuffisantException.class)
	public void testEffectuerVirementCompteCourantSoldeInsuffisant() throws SoldeInsuffisantException, MontantNegatifException {
		IConseillerService cs = new ConseillerService();
		CompteCourant cc = new CompteCourant();
		cc.setSolde(1000);
		CompteEpargne ce = new CompteEpargne();
		
		cs.effectuerVirement(cc, ce, 3000);
	}

	@Test(expected = SoldeInsuffisantException.class)
	public void testEffectuerVirementCompteEpargneSoldeInsuffisant() throws SoldeInsuffisantException, MontantNegatifException {
		IConseillerService cs = new ConseillerService();
		CompteCourant cc = new CompteCourant();
		CompteEpargne ce = new CompteEpargne();
		ce.setSolde(1000);
		
		cs.effectuerVirement(ce, cc, 2000);
	}

}
