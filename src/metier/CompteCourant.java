package metier;

/**
 * Classe représentant un type spécifique de compte : les comptes courants
 * 
 * @author Jérôme IZARD
 * @version 1.1
 *
 */
public class CompteCourant extends Compte {

	private double decouvert = 1000;
	private Carte carte;

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;

	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + ", carte=" + carte + ", getId()=" + getId() + ", getSolde()="
				+ getSolde() + "]";
	}

	

	

}
