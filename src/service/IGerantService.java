package service;

import java.util.Collection;

import metier.Compte;
import metier.Gerant;

public interface IGerantService {

	/**
	 * Méthode permettant d'auditer l'agence.
	 * 
	 * @param gerant
	 *            Gérant de l'agence auditée
	 * @return La liste des comptes particuliers débiteurs de plus de 5000€ et
	 *         des comptes entreprises débiteurs de plus de 50000€
	 */
	public Collection<Compte> auditerAgence(Gerant gerant);

}
