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

	        request.getRequestDispatcher("WEB-INF/nybruker.jsp")
	        		.forward(request, response);
	    }

	    @Override
	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {

			request.setCharacterEncoding("UTF-8");
			Paameldingsskjema skjema = new Paameldingsskjema(request);

			if (skjema.allInputGyldig()) {
				Bruker d = dbDAO.finnBrukerMedBrukernavn(skjema.getBrukernavn());
				List<Bruker> brukerEpost = dbDAO.finnBrukerMedEpost(skjema.getEpost());

				if (d == null && brukerEpost == null) {
					d = new Bruker(skjema);
					dbDAO.lagreBruker(d);
					LoggInnUt.loggInn(request, d);
					response.sendRedirect("startside");
				} else if(brukerEpost == null){
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

	

