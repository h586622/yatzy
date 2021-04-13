package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.BrukerDAO;
import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Kopp;
import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.entities.Spilldeltagelse;
import no.gruppe6.yatzy.util.LoggInnUt;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implements class LobbyServlet
 */

@WebServlet("/Lobby")
public class LobbyServlet extends HttpServlet {
    @EJB
    private SpillDAO spillDAO;

    /**
     * doGet method that gets a game with a list of participants.
     * @param request is an object which is being passed as an argument to the servlet's service methods
     * @param response is an object for HttpServlets to return information to the client
     * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
     * @throws IOException It provides information to the caller of the method about the exception.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!LoggInnUt.isLoggedIn(request)) {
            response.sendRedirect("logginn?requiresLogin");
        } else {
            Spill spill = spillDAO.hentSpill(Integer.parseInt(request.getParameter("spill")));
            List<Spilldeltagelse> spilldeltagelser = spillDAO.hentSpillDeltagelseListe(spill);
            request.setAttribute("spilldeltagelser", spilldeltagelser);
            request.setAttribute("spill", spill);

            for (Spilldeltagelse s : spilldeltagelser) {
                System.out.println(s.getBruker().getBrukernavn());
            }

            request.getRequestDispatcher("pages/Lobby.jsp").forward(request, response);
        }
    }

    /**
     * doPost method that lets the logged in user make a new game with a name and start this game.
     * @param request is an object which is being passed as an argument to the servlet's service methods
     * @param response is an object for HttpServlets to return information to the client
     * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
     * @throws IOException It provides information to the caller of the method about the exception.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesjon = request.getSession(false);
        if (!LoggInnUt.isLoggedIn(request)) {
            response.sendRedirect("logginn?requiresLogin");
        } else {
            Bruker bruker = (Bruker) sesjon.getAttribute("bruker");
            String spillnavn = request.getParameter("nyttspill");
            if (spillnavn == null || spillnavn.equals("")) {
                response.sendRedirect("startside");
            } else {
                Spill spill = new Spill();
                spill.setNavn(spillnavn);
                spill.setBrukerTur(bruker);
                spill.setSpillstatus("ledig");
                Kopp kopp = new Kopp();
                spill.setKopp(kopp);
                spillDAO.lagreNyttSpill(spill);

                Spilldeltagelse spilldeltagelse = new Spilldeltagelse(bruker, spill);
                spillDAO.lagreNySpilldeltagelse(spilldeltagelse);

                Spill spill2 = spillDAO.hentSpillMedNavn(spillnavn);

                request.setAttribute("spillid", spill2.getId());
                response.sendRedirect("Lobby?spill=" + spill2.getId());
            }

        }

    }
}
