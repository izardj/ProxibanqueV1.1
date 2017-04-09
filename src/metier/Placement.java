package metier;
/**
 * Classe représentant les placements des clients fortunés
 * 
 * @author Jérôme IZARD
 * @version 1.0
 *
 */
public class Placement {

	private double montant;
	
	private Client client;
	private PlaceFinanciere placeFinanciere;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public PlaceFinanciere getPlaceFinanciere() {
		return placeFinanciere;
	}

	public void setPlaceFinanciere(PlaceFinanciere placeFinanciere) {
		this.placeFinanciere = placeFinanciere;
	}

	@Override
	public String toString() {
		return "Placement [montant=" + montant + ", client=" + client + ", placeFinanciere=" + placeFinanciere + "]";
	}
	
	
}
