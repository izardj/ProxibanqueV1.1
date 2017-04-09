package metier;

/**
 * Classe représentant un type spécifique de compte, les compte épargne
 * 
 * @author Jérôme IZARD
 * @version 1.1
 *
 */
public class CompteEpargne extends Compte {

	private double tauxRemuneration = 0.03;

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

	@Override
	public String toString() {
		return "CompteEpargne [tauxRemuneration=" + tauxRemuneration + ", getId()=" + getId() + ", getSolde()="
				+ getSolde() + "]";
	}

	
	
}
