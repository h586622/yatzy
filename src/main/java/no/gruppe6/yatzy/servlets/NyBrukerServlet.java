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


	@WebServlet("/nybruker")
	public class NyBrukerServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;


		@EJB
		private BrukerDAO dbDAO;

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

	

