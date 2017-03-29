package presentation;
/**
 * @author Jonas Maeva
 *
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Adviser;
import service.ServiceAccount;
import service.ServiceActor;

/**
 * Servlet implementation class ServletLogin
 * Permet de v�rifier l'authentification de l'utilisateur
 * Met en session : liste des comptes, listes de clients
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ServletLogin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:zoo ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("loginuser");
		String pwd = request.getParameter("password");

		Adviser.getInstance();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30 * 60);

		RequestDispatcher dispatcher = null;

		if (Adviser.getInstance().checkPassword(login, pwd)) {
			session.setAttribute("user", Adviser.getInstance());
			session.setAttribute("list", ServiceActor.getAllClient());
			session.setAttribute("listCount", ServiceAccount.getAllAccount());
			dispatcher = request.getRequestDispatcher("advisorHome.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		dispatcher.forward(request, response);
	}

}
