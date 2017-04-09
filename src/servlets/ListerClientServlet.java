package servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Client;
import service.ConseillerService;
import service.IConseillerService;

/**
 * Servlet implementation class ListerClientServlet
 */
@WebServlet("/client-lister")
public class ListerClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IConseillerService service =  new ConseillerService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1- récupérer les paramètres
		
		// 2- traitements avec la couche service
		Collection<Client> clients = service.listerClients();
		
		// 3- préparation envoi
		request.setAttribute("clients", clients);
		
		// 4- envoi
		request.getRequestDispatcher("/lister_clients.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
