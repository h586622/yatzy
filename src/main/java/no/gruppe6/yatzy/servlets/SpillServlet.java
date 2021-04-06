package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.*;
import no.gruppe6.yatzy.util.LoggInnUt;
import no.gruppe6.yatzy.util.YatzyUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/spill")
public class SpillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private SpillDAO spillDAO;

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
            request.setAttribute("spill", spill);
            List<Spilldeltagelse> spilldeltagelser = spillDAO.hentSpillDeltagelseListe(spill);
            request.setAttribute("spilldeltagelser", spilldeltagelser);

            if (spill.getSpillstatus().equals("ledig")) {
                request.getRequestDispatcher("pages/venteliste.jsp").forward(request, response);
            } else if (spill.getSpillstatus().equals("avsluttet")) {
                //hent vinner + hele tabell
                //send til avsluttet.jsp.
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

            if (checkedBokser != null && spilldeltagelse.getKast() > 0) {
                for (int i = 0; i < checkedBokser.length; i++) {
                    tester[Integer.parseInt(checkedBokser[i])] = true;
                }
            }


            kopp.rullKopp(tester);


            int res = YatzyUtil.sjekkKast(kopp, spilldeltagelse.getRunde());

            spilldeltagelse.setKast(spilldeltagelse.getKast() + 1);


            if (spilldeltagelse.getKast() == 3) {
                YatzyUtil.oppdaterVerdi(res, spilldeltagelse.getRunde(), spilldeltagelse);
                spilldeltagelse.setKast(0);
                spilldeltagelse.setRunde(spilldeltagelse.getRunde() + 1);

                List<Spilldeltagelse> spilldeltagelser = spillDAO.hentSpillDeltagelseListe(spill);
                spill.setBrukerTur(YatzyUtil.finnNeste(spilldeltagelser));
            }

            Spilldeltagelse sd = spillDAO.hentSpillDeltagelseBrukerSpill(spill.getBrukerTur(), spill);

            if(sd.getRunde() >= 16){
                spill.setSpillstatus("avsluttet");
                //sett vinner?
            }
            spillDAO.lagreSpillDeltagelse(spilldeltagelse);
            spillDAO.lagreSpill(spill);

            response.sendRedirect("spill?spill=" + spill.getId());

        }
    }
}
