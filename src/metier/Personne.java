package metier;

/**
 * Classe abstraite représentant les personnes
 * 
 * @author Jérôme IZARD
 * @version 1.1
 *
 */
public abstract class Personne {

	private int id;
	private String nom;
	private String prenom;

	private Coordonnee coordonnee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", coordonnee=" + coordonnee + "]";
	}

}
