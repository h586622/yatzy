package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.BrukerDAO;
import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.entities.Spilldeltagelse;
import no.gruppe6.yatzy.util.LoggInnUt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implements class OversiktHistorikkServlet
 */
@WebServlet("/historikk")
public class OversiktHistorikkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private SpillDAO dbDao;

    /**
     * this method shows the users previous ended games.
     * @param request is an object which is being passed as an argument to the servlet's service methods
     * @param response is an object for HttpServlets to return information to the client
     * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
     * @throws IOException It provides information to the caller of the method about the exception.
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesjon = request.getSession(false);
        if (!LoggInnUt.isLoggedIn(request)) {
            response.sendRedirect("logginn?requiresLogin");
        } else {
            Bruker b = (Bruker) sesjon.getAttribute("bruker");
            List<Spilldeltagelse> liste = dbDao.hentSpillDeltagelserMedBrukerid(b);

            List<Spilldeltagelse> spilldeltagelser = liste.stream()
                    .filter(d -> d.getSpill().getSpillstatus().equals("avsluttet"))
                    .collect(Collectors.toList());

            request.setAttribute("spilldeltagelser", spilldeltagelser);
            request.getRequestDispatcher("pages/historikk.jsp")
                    .forward(request, response);
        }


    }
}
