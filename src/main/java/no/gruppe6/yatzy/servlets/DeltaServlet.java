package no.gruppe6.yatzy.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/delta")
public class DeltaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    	ArrayList ledigeSpill = new ArrayList<>();
    	ledigeSpill.add("Spill 1");
    	ledigeSpill.add("Spill 2");
    	ledigeSpill.add("Spill 3");
    	
    	request.setAttribute("ledigeSpill", ledigeSpill);
        request.getRequestDispatcher("WEB-INF/delta.jsp")
        		.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    
    	

        
    }
}
