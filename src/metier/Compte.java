package metier;

/**
 * Classe abstraite représentant les comptes des clients de la banque
 * 
 * @author Jérôme IZARD
 * @version 1.1
 *
 */
public abstract class Compte {

	private long id;
	private double solde;
	private String dateOuverture;

	private Client titulaire;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Client getTitulaire() {
		return titulaire;
	}

	public void setTitulaire(Client titulaire) {
		this.titulaire = titulaire;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", solde=" + solde + ", dateOuverture=" + dateOuverture + ", titulaire=" + titulaire
				+ "]";
	}

}
