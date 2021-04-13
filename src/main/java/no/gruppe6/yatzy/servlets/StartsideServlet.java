package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.BrukerDAO;
import no.gruppe6.yatzy.util.LoggInnUt;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implements class StartsideServlet
 */
@WebServlet("/startside")
public class StartsideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BrukerDAO bDao;

	/**
	 * This method redirects the user to the homepage when the user is logged in.
	 * @param request is an object which is being passed as an argument to the servlet's service methods
	 * @param response is an object for HttpServlets to return information to the client
	 * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
	 * @throws IOException It provides information to the caller of the method about the exception.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!LoggInnUt.isLoggedIn(request)){
			response.sendRedirect("logginn?requiresLogin");
		}else{
			request.getRequestDispatcher("pages/startside.jsp").forward(request, response);
		}


	}
}
