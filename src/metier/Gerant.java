package metier;

/**
 * Classe représentant le gérant d'une agence. Hérite de la classe Personne
 * 
 * @author Jérome IZARD et Perrine EMIN
 *
 */
public class Gerant extends Personne {

	private Agence agence;

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	@Override
	public String toString() {
		return "Gerant [agence=" + agence + ", getNom()=" + getNom() + "]";
	}

}
