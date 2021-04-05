package no.gruppe6.yatzy.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/spectate")
public class SpectateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList aktiveSpill = new ArrayList<>();
    	aktiveSpill.add("Spill 1");
    	aktiveSpill.add("Spill 2");
    	aktiveSpill.add("Spill 3");
    	
    	request.setAttribute("aktiveSpill", aktiveSpill);
        request.getRequestDispatcher("pages/spectate.jsp")
        		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
