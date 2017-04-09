package metier;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe repr�sentant les conseiller de l'agence. Elle h�rite de la classe Personne
 * @author J�rome IZARD et Perrine EMIN
 *
 */
public class Conseiller extends Personne {

	private Agence agence;
	private Collection<Client> clients = new ArrayList<Client>();

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "[Conseiller : "+ getPrenom()+ " "+ getNom()+"]";
	}

	
}
