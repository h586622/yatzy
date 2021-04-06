package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.BrukerDAO;
import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.entities.Spilldeltagelse;
import no.gruppe6.yatzy.util.LoggInnUt;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/historikk")
public class HistorikkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private SpillDAO dbDao;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);
		if (!LoggInnUt.isLoggedIn(request)){
			response.sendRedirect("logginn?requiresLogin");
		} else {
			Bruker b = (Bruker) sesjon.getAttribute("bruker");
			List<Spilldeltagelse> spilldeltagelser =  dbDao.hentSpillDeltagelserMedBrukerid(b);

			request.setAttribute("spilldeltagelser", spilldeltagelser);

			for (Spilldeltagelse s: spilldeltagelser) {
				System.out.println(s.getSpill().getNavn());
			}
			request.getRequestDispatcher("pages/historikk.jsp")
					.forward(request, response);
		}




	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int spillid = Integer.parseInt(request.getParameter("spillid"));
		Spill spill = dbDao.hentSpill(spillid);
		List<Spilldeltagelse> spilldeltagelser = dbDao.hentSpillDeltagelseListe(spill);

		for (Spilldeltagelse s: spilldeltagelser) {
			System.out.println("Enere:" + s.getEnere());
		}
		System.out.println("Spillid : " + spillid);

		request.setAttribute("spilldeltagelser", spilldeltagelser);

		request.getRequestDispatcher("pages/spillHistorikk.jsp")
				.forward(request, response);


	}

}
