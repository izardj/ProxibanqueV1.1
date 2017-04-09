package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Client;
import metier.Coordonnee;
import service.ConseillerService;
import service.IConseillerService;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/client-ajouter")
public class AjouterClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IConseillerService service =  new ConseillerService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1- récupérer les paramètres
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String rue = request.getParameter("rue");
		String ville = request.getParameter("ville");
		String telephone = request.getParameter("telephone");
		int codePostal = Integer.parseInt(request.getParameter("codepostal"));

		// 2- traitements avec la couche service
		Client c = new Client();
		Coordonnee cd = new Coordonnee();
		
		cd.setRue(rue);
		cd.setVille(ville);
		cd.setTelephone(telephone);
		cd.setCodePostal(codePostal);
		
		c.setCoordonnee(cd);
		c.setNom(nom);
		c.setPrenom(prenom);
		
		service.creerClient(c);


		// 3- préparation envoi

		// 4- envoi
		request.getRequestDispatcher("/index.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
