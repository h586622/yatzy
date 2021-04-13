package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.entities.Spilldeltagelse;
import no.gruppe6.yatzy.util.JavaMailUtil;
import no.gruppe6.yatzy.util.LoggInnUt;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalTime;

/**
 * Servlet implements class StartServelt
 */
@WebServlet("/start")
public class StartServlet extends HttpServlet {

    @EJB
    private SpillDAO spillDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * This method lets thee user start their turn when the game is active.
     * @param request is an object which is being passed as an argument to the servlet's service methods
     * @param response is an object for HttpServlets to return information to the client
     * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
     * @throws IOException It provides information to the caller of the method about the exception.
     */
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

            if(bruker.equals(spill.getBrukerTur())){

                Spilldeltagelse spilldeltagelse = spillDAO.hentSpillDeltagelseBrukerSpill(bruker, spill);
                spilldeltagelse.setPurren(LocalTime.now());
                spilldeltagelse.setAntallpurr(0);
                spillDAO.lagreSpillDeltagelse(spilldeltagelse);

                try {
                    JavaMailUtil.gameStartMail(spillDAO.hentSpillDeltagelseListe(spill), spill.getNavn());
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                spill.setSpillstatus("aktiv");
                spillDAO.lagreSpill(spill);



            }
                response.sendRedirect("spill?spill=" + spill.getId());

        }
    }
}
