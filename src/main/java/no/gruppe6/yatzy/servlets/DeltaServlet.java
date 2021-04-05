package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.entities.Spilldeltagelse;
import no.gruppe6.yatzy.util.LoggInnUt;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/delta")
public class DeltaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    SpillDAO spillDAO;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    	ArrayList ledigeSpill = new ArrayList<>();
    	ledigeSpill.add("Spill 1");
    	ledigeSpill.add("Spill 2");
    	ledigeSpill.add("Spill 3");
    	
    	request.setAttribute("ledigeSpill", ledigeSpill);
        request.getRequestDispatcher("pages/delta.jsp")
        		.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if(!LoggInnUt.isLoggedIn(request)){
            response.sendRedirect("logginn?requiresLogin");
        }else{
            int id = Integer.parseInt(request.getParameter("spill"));
            Spill spill = spillDAO.hentSpill(id);
            Bruker bruker = (Bruker)session.getAttribute("bruker");
            Spilldeltagelse sd = new Spilldeltagelse(bruker, spill);
            spillDAO.lagreSpillDeltagelse(sd);


            //Må bestemme hvor denne skal sendes - lobby eller spill ?
        }
    
    	

        
    }
}
