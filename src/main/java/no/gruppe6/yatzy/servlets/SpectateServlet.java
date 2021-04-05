package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Spill;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/spectate")
public class SpectateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	@EJB
	private SpillDAO spillDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Spill> aktiveSpill = spillDAO.hentAktiveSpill();

    	request.setAttribute("aktiveSpill", aktiveSpill);
        request.getRequestDispatcher("pages/spectate.jsp")
        		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
