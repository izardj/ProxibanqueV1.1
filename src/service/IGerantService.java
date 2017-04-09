package service;

import java.util.Collection;

import metier.Compte;
import metier.Gerant;

public interface IGerantService {

	/**
	 * M�thode permettant d'auditer l'agence.
	 * 
	 * @param gerant
	 *            G�rant de l'agence audit�e
	 * @return La liste des comptes particuliers d�biteurs de plus de 5000� et
	 *         des comptes entreprises d�biteurs de plus de 50000�
	 */
	public Collection<Compte> auditerAgence(Gerant gerant);

}
