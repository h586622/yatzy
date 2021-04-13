package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.*;
import no.gruppe6.yatzy.util.LoggInnUt;
import no.gruppe6.yatzy.util.YatzyUtil;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implements class SpillServlet
 */

@WebServlet("/spill")
public class SpillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private SpillDAO spillDAO;

    /**
     * doGet that lets the user join a game that is made, but not jet started, if the game is full(max players = 6)
     * the user is put in a waiting list. The method also handles the different ways to pe part of a game (spectate, participant and turn).
     * when the game is ended the method redirects to the game history.
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
            HttpSession sesjon = request.getSession(false);
            Bruker bruker = (Bruker) sesjon.getAttribute("bruker");

            String ids = request.getParameter("spill");
            int id = Integer.parseInt(ids);
            Spill spill = spillDAO.hentSpill(id);
            System.out.println(spill.getSpillstatus());
            request.setAttribute("spill", spill);
            List<Spilldeltagelse> spilldeltagelser = spillDAO.hentSpillDeltagelseListe(spill);
            request.setAttribute("spilldeltagelser", spilldeltagelser);

            if (spill.getSpillstatus().equals("ledig")) {
                if(spill.getBrukerTur().equals(bruker)){
                    response.sendRedirect("Lobby?spill="+ spill.getId());
                }else{
                    request.getRequestDispatcher("pages/venteliste.jsp").forward(request, response);
                }

            } else if (spill.getSpillstatus().equals("avsluttet")) {
                response.sendRedirect("enkelHistorikk?spillid=" + spill.getId());
            } else {
                String forward = "pages/";
                Bruker tur = spill.getBrukerTur();
                Spilldeltagelse spilldeltagelse = spillDAO.hentSpillDeltagelseBrukerSpill(tur, spill);

                if (bruker.equals(tur)) {
                    forward += "spill.jsp";
                } else if (spilldeltagelser.contains(spilldeltagelse)) {
                    forward += "deltager.jsp";
                } else {
                    forward += "spectator.jsp"; //Spectate for dette spillet

                }

                request.setAttribute("rundenavn", YatzyUtil.rundeNavn(spilldeltagelse.getRunde()));
                request.setAttribute("spilldeltagelse", spilldeltagelse);

                request.getRequestDispatcher(forward)
                        .forward(request, response);
            }


        }
    }

    /**
     * doPost handles the game in progress, when its the users turn, the users throw is registered and ends the game after
     * turn 16.
     * @param request is an object which is being passed as an argument to the servlet's service methods
     * @param response is an object for HttpServlets to return information to the client
     * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
     * @throws IOException It provides information to the caller of the method about the exception.
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesjon = request.getSession(false);
        if (!LoggInnUt.isLoggedIn(request)) response.sendRedirect("logginn?requiresLogin");
        else {

            int id = Integer.parseInt(request.getParameter("spill"));
            Bruker bruker = (Bruker) sesjon.getAttribute("bruker");
            Spill spill = spillDAO.hentSpill(id);
            System.out.println(spill.getId());
            Spilldeltagelse spilldeltagelse = spillDAO.hentSpillDeltagelseBrukerSpill(bruker, spill);

            Kopp kopp = spill.getKopp();

            String[] checkedBokser = request.getParameterValues("terninger");
            boolean[] tester = new boolean[5];

            if (checkedBokser != null && spilldeltagelse.getKast() < 3) {
                for (int i = 0; i < checkedBokser.length; i++) {
                    tester[Integer.parseInt(checkedBokser[i])] = true;
                }
            }


            kopp.rullKopp(tester);


            int res = YatzyUtil.sjekkKast(kopp, spilldeltagelse.getRunde());

            spilldeltagelse.setKast(spilldeltagelse.getKast() - 1);


            if (spilldeltagelse.getKast() == 0) {
                YatzyUtil.oppdaterVerdi(res, spilldeltagelse.getRunde(), spilldeltagelse);
                spilldeltagelse.setKast(3);
                spilldeltagelse.setRunde(spilldeltagelse.getRunde() + 1);

                List<Spilldeltagelse> spilldeltagelser = spillDAO.hentSpillDeltagelseListe(spill);
                Bruker nesteBruker = YatzyUtil.finnNeste(spilldeltagelser, spilldeltagelse);
                spill.setBrukerTur(nesteBruker);

                Spilldeltagelse nesteDeltagelse = null;

                for (Spilldeltagelse s:spilldeltagelser) {
                    if(s.getBruker().equals(nesteBruker))
                     nesteDeltagelse = s;
                }
                nesteDeltagelse.setPurren(LocalTime.now());
                nesteDeltagelse.setAntallpurr(0);
                spillDAO.lagreSpillDeltagelse(nesteDeltagelse);


            }

            Spilldeltagelse sd = spillDAO.hentSpillDeltagelseBrukerSpill(spill.getBrukerTur(), spill);

            if(sd.getRunde() >= 16){
                spill.setSpillstatus("avsluttet");
            }
            spillDAO.lagreSpillDeltagelse(spilldeltagelse);
            spillDAO.lagreSpill(spill);

            response.sendRedirect("spill?spill=" + spill.getId());

        }
    }
}
