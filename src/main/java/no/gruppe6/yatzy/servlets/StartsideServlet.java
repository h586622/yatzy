package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.BrukerDAO;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/startside")
public class StartsideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BrukerDAO bDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("pages/startside.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Logikk for � sjekke om spillnavnet er unikt

		HttpSession sesjon = request.getSession(false);

		if (sesjon == null || sesjon.getAttribute("username") == null) {
			response.sendRedirect("logginn");
		}




		//String nyttSpill = (String)request.getParameter("nyttspill");
        //System.out.println(nyttSpill);
        //response.sendRedirect("spill");

	}
}
