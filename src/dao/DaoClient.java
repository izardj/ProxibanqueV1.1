package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import dao.exceptions.DaoException;
import metier.Client;
import metier.Coordonnee;

public class DaoClient implements IDaoCRUD<Client> {

	@Override
	public Collection<Client> lister() {

		Collection<Client> clients = new ArrayList<Client>();

		// preparer la requête
		try {
			PreparedStatement ps = DaoConnexion.getConnexion().prepareStatement(
					"SELECT Client.id, Client.nom, Client.prenom, Client.entreprise, Client.nomentreprise,"
						+ " Coordonnee.rue, Coordonnee.ville, Coordonnee.codepostal, Coordonnee.telephone"
						+ " FROM Client LEFT JOIN Coordonnee ON Client.idcoordonnee = Coordonnee.id");
			// executer la requête
			ResultSet rs = ps.executeQuery();
			// présenter les résultats
			while (rs.next()) {
				Client c = new Client();
				Coordonnee cd = new Coordonnee();

				cd.setRue(rs.getString("rue"));
				cd.setVille(rs.getString("ville"));
				cd.setCodePostal(rs.getInt("codepostal"));
				cd.setTelephone(rs.getString("telephone"));

				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setEntreprise(rs.getBoolean("entreprise"));
				c.setNomEntreprise(rs.getString("nomentreprise"));
				c.setCoordonnee(cd);

				clients.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DaoConnexion.closeConnexion();
		}
		return clients;
	}

	@Override
	public void creer(Client obj) {
		try {
			// prepare les requetes
			PreparedStatement psCoord = DaoConnexion.getConnexion().prepareStatement(
					"INSERT INTO Coordonnee(rue, codepostal, ville, telephone) VALUES (?, ?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			PreparedStatement psClient = DaoConnexion.getConnexion().prepareStatement(
					"INSERT INTO Client(nom, prenom, entreprise, nomentreprise, idcoordonnee) VALUES (?, ?, ?, ?, ?)");

			Coordonnee coord = obj.getCoordonnee();

			psCoord.setString(1, coord.getRue());
			psCoord.setLong(2, coord.getCodePostal());
			psCoord.setString(3, coord.getVille());
			psCoord.setString(4, coord.getTelephone());

			// executer la requête pour Coordonnee
			psCoord.executeUpdate();

			// recuperer l'identifiant de coordonnee
			ResultSet rs = psCoord.getGeneratedKeys();

			if (rs.next()) {
				long idCoord = rs.getLong(1);
				psClient.setString(1, obj.getNom());
				psClient.setString(2, obj.getPrenom());
				psClient.setBoolean(3, obj.isEntreprise());
				psClient.setString(4, obj.getNomEntreprise());
				psClient.setLong(5, idCoord);

				// executer la requete pour Client
				psClient.executeUpdate();

			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DaoConnexion.closeConnexion();
		}
	}

	@Override
	public void modifier(Client obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimer(Client obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client getParId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
