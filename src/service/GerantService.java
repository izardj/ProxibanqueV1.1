package service;

import java.util.ArrayList;
import java.util.Collection;

import metier.Agence;
import metier.Client;
import metier.Compte;
import metier.Conseiller;
import metier.Gerant;

public class GerantService implements IGerantService {

	@Override
	public Collection<Compte> auditerAgence(Gerant gerant) {
		Agence ag = gerant.getAgence();
		Collection<Conseiller> colConseiller = ag.getConseillers();
		double soldeDebiteurMax;

		Collection<Compte> comptesAudit = new ArrayList<Compte>();

		// parcourir les conseillers
		for (Conseiller conseiller : colConseiller) {
			// parcourir chaque clients
			for (Client client : conseiller.getClients()) {
				if (client.getCompteCourant() != null) {
					if (client.isEntreprise()) {
						soldeDebiteurMax = -50000;
					} else {
						soldeDebiteurMax = -5000;
					}
					double soldeCompteCourant = client.getCompteCourant().getSolde();

					if (soldeCompteCourant < soldeDebiteurMax) {
						comptesAudit.add(client.getCompteCourant());
					}
				}
			}
		}
		return comptesAudit;
	}

}
