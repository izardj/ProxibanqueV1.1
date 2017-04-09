package metier;

/**
 * Classe représentant les clients de la banque, héritant de la classe Personne
 * 
 * @author Jérôme IZARD
 * @version 1.1
 *
 */
public class Client extends Personne {

	private boolean entreprise = false;

	private String nomEntreprise;
	private Conseiller conseiller;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;

	public boolean isEntreprise() {
		return entreprise;
	}

	public void setEntreprise(boolean entreprise) {
		this.entreprise = entreprise;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	@Override
	public String toString() {
		return "Client [entreprise=" + entreprise + ", nomEntreprise=" + nomEntreprise + ", conseiller=" + conseiller
				+ ", compteCourant=" + compteCourant + ", compteEpargne=" + compteEpargne + "]";
	}

}
