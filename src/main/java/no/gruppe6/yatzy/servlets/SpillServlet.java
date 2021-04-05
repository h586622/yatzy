package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.entities.Kopp;
import no.gruppe6.yatzy.entities.Terning;
import no.gruppe6.yatzy.util.YatzyUtil;

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
    	
        request.getRequestDispatcher("pages/spill.jsp")
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
        int res = YatzyUtil.sjekkKast(kopp,1);
        //String koppString = kopp.toString();
        //System.out.println(koppString);
        String[] terningverdier = kopp.terningVerdi();

        request.getSession().setAttribute("kopp" , terningverdier);
        request.getSession().setAttribute("resultat" , res);

        //request.getSession().setAttribute("nyttspill", nyttspill);
        response.sendRedirect("spill");
        
        
    }
}
