package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.entities.Spilldeltagelse;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "enkelHistorikk", value = "/enkelHistorikk")
public class EnkelHistorikkServlet extends HttpServlet {

    @EJB
    private SpillDAO dbDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int spillid = Integer.parseInt(request.getParameter("spillid"));
        Spill spill = dbDao.hentSpill(spillid);
        List<Spilldeltagelse> spilldeltagelser = dbDao.hentSpillDeltagelseListe(spill);
        request.setAttribute("spilldeltagelser", spilldeltagelser);

        request.getRequestDispatcher("pages/spillHistorikk.jsp")
                .forward(request, response);

    }


}
