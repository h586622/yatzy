package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.BrukerDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Paameldingsskjema;
import no.gruppe6.yatzy.util.LoggInnUt;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implements class NyBrukerServlet
 */

	@WebServlet("/nybruker")
	public class NyBrukerServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;


		@EJB
		private BrukerDAO dbDAO;

	/**
	 *doGet method redirect the user from the logg in page to ether the frontpage if they logg in or to the page where
	 * the user can register a new user.
	 * @param request is an object which is being passed as an argument to the servlet's service methods
	 * @param response is an object for HttpServlets to return information to the client
	 * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
	 * @throws IOException It provides information to the caller of the method about the exception.
	 */

	    @Override
	    protected void doGet(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
			if(LoggInnUt.isLoggedIn(request)){
				response.sendRedirect("startside");
			}else{
				request.getRequestDispatcher("pages/nybruker.jsp")
						.forward(request, response);
			}

	    }

	/**
	 * doPost makes a new schema, validates that the input from the user is in the correct format and redirects to
	 * front page if all is correct and creates a new user in the database, if not the user gets error information
	 * and is redirected to the registration form.
	 * @param request is an object which is being passed as an argument to the servlet's service methods
	 * @param response is an object for HttpServlets to return information to the client
	 * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
	 * @throws IOException It provides information to the caller of the method about the exception.
	 */
	    @Override
	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {

			request.setCharacterEncoding("ISO-8859-1");
			Paameldingsskjema skjema = new Paameldingsskjema(request);

			if (skjema.allInputGyldig()) {
				Bruker d = dbDAO.finnBrukerMedBrukernavn(skjema.getBrukernavn());
				List<Bruker> brukerEpost = dbDAO.finnBrukerMedEpost(skjema.getEpost());

				if (d == null && brukerEpost.size() == 0) {
					d = new Bruker(skjema);
					dbDAO.lagreBruker(d);
					LoggInnUt.loggInn(request, d);
					response.sendRedirect("startside");
				} else if(brukerEpost.size() == 0){
					skjema.ikkeUniktBrukernavn();
					request.getSession().setAttribute("skjema", skjema);
					response.sendRedirect("nybruker");
				}else{
					skjema.ikkeUnikEpost();
					request.getSession().setAttribute("skjema", skjema);
					response.sendRedirect("nybruker");
				}
			} else {
				skjema.settOppFeilmeldinger();
				request.getSession().setAttribute("skjema", skjema);
				response.sendRedirect("nybruker");
			}
		}
	}

	

