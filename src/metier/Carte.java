package metier;

/**
 * Classe abstraite repr�sentant les cartes bancaires propos�es aux clients
 * 
 * @author J�r�me IZARD
 * @version 1.1
 *
 */
public abstract class Carte {

	private int id;
	private boolean bloquee = false;
	private Compte compte;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBloquee(boolean bloquee) {
		this.bloquee = bloquee;
	}

	public boolean isBloquee() {
		return bloquee;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Carte [id=" + id + ", bloquee=" + bloquee + ", compte=" + compte + "]";
	}

}
