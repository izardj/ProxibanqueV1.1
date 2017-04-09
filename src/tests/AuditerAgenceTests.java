package tests;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import metier.Agence;
import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.Conseiller;
import metier.Gerant;
import service.GerantService;
import service.IGerantService;

public class AuditerAgenceTests {
	
	@Test
	public void testAuditerAgence() {
		IGerantService gs = new GerantService();
		
		// création d'une agence
		Agence ag = new Agence();
		
		// création d'un gérant
		Gerant gr = new Gerant();
				
		// Création de conseillers
		Conseiller cons1 = new Conseiller();
		Conseiller cons2 = new Conseiller();
		
		// création de clients entreprise
		Client clientEntr1 = new Client();
		clientEntr1.setEntreprise(true);
		
		Client clientEntr2 = new Client();
		clientEntr1.setEntreprise(true);
		
		// création de clients particulier
		Client clientPart1 = new Client();
		clientPart1.setEntreprise(false);
		
		Client clientPart2 = new Client();
		clientPart2.setEntreprise(false);
		
		// création de comptes courants
		CompteCourant cc1 = new CompteCourant();
		cc1.setId(1);
		CompteCourant cc2 = new CompteCourant();
		cc2.setId(2);
		CompteCourant cc3 = new CompteCourant();
		cc3.setId(3);
		CompteCourant cc4 = new CompteCourant();
		cc4.setId(4);
		
		// création des collections
		Collection<Conseiller> colCons = new ArrayList<Conseiller>();
		colCons.add(cons1);
		colCons.add(cons2);
		Collection<Client> colCl1 = new ArrayList<Client>();
		colCl1.add(clientPart1);
		colCl1.add(clientEntr1);
		Collection<Client> colCl2 = new ArrayList<Client>();
		colCl2.add(clientPart2);
		colCl2.add(clientEntr2);
		
		// association entre les objets
		gr.setAgence(ag);
		ag.setConseillers(colCons);
		cons1.setClients(colCl1);
		cons2.setClients(colCl2);

		clientPart1.setCompteCourant(cc1);
		clientPart2.setCompteCourant(cc2);
		clientEntr1.setCompteCourant(cc3);
		clientEntr2.setCompteCourant(cc4);
		
		// assignation des soldes
		cc1.setSolde(1500); 	// compte d'un client particulier 
		cc2.setSolde(-6000); 	// compte d'un client particulier 
		cc3.setSolde(-700000);  // compte d'un client entreprise 
		cc4.setSolde(-1500);	// compte d'un client entreprise 
		
		Collection<Compte> resultatAttendu = new ArrayList<Compte>();
		resultatAttendu.add(cc3);
		resultatAttendu.add(cc2);
		
		/* doit retourner une collection de comptes debiteur
		 * solde < -5000 pour les clients particuliers
		 * solde < -50000 pour les clients entreprises */
		Collection<Compte> resultatAudit = gs.auditerAgence(gr);

		Assert.assertEquals(resultatAttendu, resultatAudit);
	}
}
