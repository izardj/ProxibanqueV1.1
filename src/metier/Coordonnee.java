package metier;

/**
 * Classe regroupant des coordonnées personnelles comme un numéro de téléphone,
 * une adresse complète
 * 
 * @author Jérôme IZARD
 * @version 1.1
 *
 */
public class Coordonnee {

	private String rue;
	private int codePostal;
	private String ville;
	private String telephone;

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Coordonnee [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", telephone=" + telephone
				+ "]";
	}
}
