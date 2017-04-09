package metier;

/**
 * Classe représentant les places financieres
 * 
 * @author Jérôme IZARD
 * @version 1.0
 *
 */
public class PlaceFinanciere {
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "PlaceFinanciere [nom=" + nom + "]";
	}
}
