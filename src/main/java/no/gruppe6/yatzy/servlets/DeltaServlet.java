package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.entities.Spilldeltagelse;
import no.gruppe6.yatzy.util.LoggInnUt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This servlet Servlet implements class DeltaServlet
 */

@WebServlet("/delta")
public class DeltaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private SpillDAO spillDAO;

    /**
     * doGet method that checks to see if the user is logged in and gets a list of available games.
     * @param request is an object which is being passed as an argument to the servlet's service methods
     * @param response is an object for HttpServlets to return information to the client
     * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
     * @throws IOException It provides information to the caller of the method about the exception.
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        if (!LoggInnUt.isLoggedIn(request)) {
            response.sendRedirect("logginn?requiresLogin");
        } else {

            List<Spill> ledigeSpill = spillDAO.hentTilgjengeligeSpill();

            request.setAttribute("ledigeSpill", ledigeSpill);
            request.getRequestDispatcher("pages/delta.jsp")
                    .forward(request, response);
        }
    }

    /**
     * doPost method that checks if user is logged in and a session where the user can participate in a game
     * that has not yet started, but is in progress of starting and where the amount of participants are lower than 6.
     * @param request is an object which is being passed as an argument to the servlet's service methods
     * @param response is an object for HttpServlets to return information to the client
     * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
     * @throws IOException It provides information to the caller of the method about the exception.
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        if (!LoggInnUt.isLoggedIn(request)) {
            response.sendRedirect("logginn?requiresLogin");
        } else {
            HttpSession sesjon = request.getSession(false);
            Bruker bruker = (Bruker) sesjon.getAttribute("bruker");
            String sid = request.getParameter("spill");
            int id = Integer.parseInt(sid);
            Spill spill = spillDAO.hentSpill(id);
            List<Spilldeltagelse> spilldeltagelser = spillDAO.hentSpillDeltagelseListe(spill);
            List<Bruker> brukere = spilldeltagelser.stream().map(Spilldeltagelse::getBruker).collect(Collectors.toList());

            //Skal vi sjekke om spill er null?
            if (!spill.getSpillstatus().equals("ledig") || spilldeltagelser.size() >= 6) {
                response.sendRedirect("delta?feilmelding=ikketilgjengelig");
            } else if (brukere.contains(bruker)) {
                response.sendRedirect("spill?spill=" + spill.getId());
            } else {

                Spilldeltagelse spilldeltagelse = new Spilldeltagelse(bruker, spill);
                spillDAO.lagreNySpilldeltagelse(spilldeltagelse);

                if (spilldeltagelser.size() >= 6) {
                    spill.setSpillstatus("aktiv");
                    spillDAO.lagreSpill(spill);

                    //Legg inn epost
                }

                response.sendRedirect("spill?spill=" + spill.getId());
            }

        }


    }
}
