package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.entities.Kopp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spill")
public class SpillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    	request.getSession().setAttribute("spill", request.getSession().getAttribute("nyttspill"));
    	
        request.getRequestDispatcher("WEB-INF/spill.jsp")
        		.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
        //String nyttspill = (String) request.getParameter("nyttspill");
        // M� opprette spill med navnet dersom det er unikt
        //System.out.println(nyttspill);

        Kopp kopp = new Kopp();
        kopp.rullKopp();
        //String koppString = kopp.toString();
        //System.out.println(koppString);

        request.getSession().setAttribute("kopp" , kopp);
        //request.getSession().setAttribute("nyttspill", nyttspill);
        response.sendRedirect("spill");
        
        
    }
}
