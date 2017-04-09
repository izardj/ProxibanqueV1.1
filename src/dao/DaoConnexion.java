package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.exceptions.DaoConfigurationException;
import dao.exceptions.DaoException;

/**
 * Classe gérant la connexion à la base de donnée
 * 
 * @author Jérôme IZARD
 * @version 1.0
 *
 */
public abstract class DaoConnexion {
	private static final String PILOTE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/proxibanque";
	private static final String UTILISATEUR = "root";
	private static final String MDP = "";
	private static Connection conn;

	public static Connection getConnexion() {
		if (conn == null) {
			// chargement du pilote
			try {
				Class.forName(PILOTE);
			} catch (ClassNotFoundException e) {
				throw new DaoConfigurationException("Le pilote est introuvable", e);
			}
			// création de la connexion
			try {
				conn = DriverManager.getConnection(URL, UTILISATEUR, MDP);
			} catch (SQLException e) {
				throw new DaoException(e);
			}
		}
		// la connexion existe déja
		return conn;
	}

	public static void closeConnexion() {
		if (conn != null) {
			// fermeture de la connexion
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				throw new DaoException(e);
			}
		}
	}

}
