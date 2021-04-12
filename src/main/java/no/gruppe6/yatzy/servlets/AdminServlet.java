package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.BrukerDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.util.LoggInnUt;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    @EJB
    private BrukerDAO dbDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(!LoggInnUt.isLoggedIn(request)) {
            String loginMessage = "Forespørselen din krever pålogging. "
                    + "(Du kan ha blitt logget ut automatisk)";
            request.setAttribute("loginMessage", loginMessage);
            request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
        } else {
            List<Bruker> brukere = dbDao.hentAlleBrukere();
            request.setAttribute("brukere", brukere);
            request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(!LoggInnUt.isLoggedIn(request)) {
            String loginMessage = "Forespørselen din krever pålogging. "
                    + "(Du kan ha blitt logget ut automatisk)";
            request.setAttribute("loginMessage", loginMessage);
            request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
        } else {
            if (request.getParameter("slett") != null) {
//                dbDao.slettBruker(request.getParameter("slettDette"));
                System.out.println(request.getParameter("slettDette"));
            }
            response.sendRedirect("admin");
        }
    }
}
