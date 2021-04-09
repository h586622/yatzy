package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Spill;

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

        String id = request.getParameter("spillid");
        int ids = Integer.parseInt(id);

        Spill spill = spillDAO.hentSpill(ids);
        spill.setSpillstatus("aktiv");
        spillDAO.lagreSpill(spill);
        response.sendRedirect("spill?spill=" + spill.getId());
    }
}
