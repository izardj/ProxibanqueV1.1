package metier;

import java.util.Collection;

/**
 * Classe représentant une agence
 * 
 * @author Jérôme IZARD
 * @version 1.1
 *
 */
public class Agence {

	private int id;
	private String numAgence;
	private String dateCreation;

	private Coordonnee coordonnee;
	private Gerant gerant;
	private Collection<Conseiller> conseillers;

	public String getNumAgence() {
		return numAgence;
	}

	public void setNumAgence(String numAgence) {
		this.numAgence = numAgence;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public Collection<Conseiller> getConseillers() {
		return conseillers;
	}

	public void setConseillers(Collection<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Agence [id=" + id + ", numAgence=" + numAgence + ", dateCreation=" + dateCreation + "]";
	}

}
