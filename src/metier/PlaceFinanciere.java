package metier;

/**
 * Classe repr�sentant les places financieres
 * 
 * @author J�r�me IZARD
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
