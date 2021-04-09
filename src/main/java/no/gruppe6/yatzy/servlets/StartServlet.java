package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.util.LoggInnUt;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/start")
public class StartServlet extends HttpServlet {

    @EJB
    private SpillDAO spillDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(!LoggInnUt.isLoggedIn(request)){
            response.sendRedirect("logginn?requiresLogin");
        }else {
            HttpSession sesjon = request.getSession(false);
            Bruker bruker = (Bruker) sesjon.getAttribute("bruker");
            String id = request.getParameter("spillid");
            int ids = Integer.parseInt(id);
            Spill spill = spillDAO.hentSpill(ids);
            if(!bruker.equals(spill.getBrukerTur())){
                spill.setSpillstatus("aktiv");
                spillDAO.lagreSpill(spill);
            }
            response.sendRedirect("spill?spill=" + spill.getId());
        }
    }
}
