package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.BrukerDAO;
import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.entities.Spilldeltagelse;
import no.gruppe6.yatzy.util.LoggInnUt;
import no.gruppe6.yatzy.util.YatzyUtil;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    @EJB
    private BrukerDAO brukerDAO;
    @EJB
    private SpillDAO spillDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(!LoggInnUt.isLoggedIn(request)) {
            String loginMessage = "Forespørselen din krever pålogging. "
                    + "(Du kan ha blitt logget ut automatisk)";
            request.setAttribute("loginMessage", loginMessage);
            request.getRequestDispatcher("pages/logginn.jsp").forward(request, response);
        } else {
            List<Bruker> brukere = brukerDAO.hentAlleBrukere();
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
            request.getRequestDispatcher("pages/logginn.jsp").forward(request, response);
        } else {
            if (request.getParameter("slett") != null) {
                Bruker bruker = brukerDAO.finnBrukerMedBrukernavn(request.getParameter("slettDette"));
                List<Spilldeltagelse> deltagelser = spillDAO.hentSpillDeltagelserMedBrukerid(bruker);
                List<Spill> brukerSinTur = spillDAO.hentSpillTurMedBrukerId(bruker);
                // det er spillerns tur i et aktivt spill.
                if (brukerSinTur != null) {
                    for (Spill spill: brukerSinTur) {
                        List<Spilldeltagelse> alleSpillDeltagelser = spillDAO.hentSpillDeltagelseListe(spill);
                        for (Spilldeltagelse deltager: alleSpillDeltagelser) {
                            if (deltager.getBruker().equals(bruker)) {
                                spill.setBrukerTur(YatzyUtil.finnNeste(alleSpillDeltagelser,deltager));
                                spillDAO.lagreSpill(spill);
                            }
                        }
                    }
                }
                List<Spilldeltagelse> alleSpillTilBruker = bruker.getSpilldeltagelseList();
                if (alleSpillTilBruker != null) {
                    for (Spilldeltagelse sp: alleSpillTilBruker) {
                        spillDAO.fjernSpillDeltagelse(sp);
                    }
                }
                brukerDAO.slettBruker(request.getParameter("slettDette"));
            }
            response.sendRedirect("admin");
        }
    }
}
