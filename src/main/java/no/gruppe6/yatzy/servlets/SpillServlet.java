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
        HttpSession sesjon = request.getSession(false);
        if (!LoggInnUt.isLoggedIn(request)) response.sendRedirect("logginn?requiresLogin");
        else {

            Bruker bruker = (Bruker) sesjon.getAttribute("bruker");
            int id = Integer.parseInt(request.getParameter("spill"));

            Spill spill = (Spill) spillDAO.hentSpill(id);

        request.getSession().setAttribute("spill", request.getSession().getAttribute("nyttspill"));

        request.getRequestDispatcher("pages/spill.jsp")
                .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesjon = request.getSession(false);
        if (!LoggInnUt.isLoggedIn(request)) response.sendRedirect("logginn?requiresLogin");
        else {

            int id = Integer.parseInt(request.getParameter("spill"));

            Spill spill = spillDAO.hentSpill(id);
            List<Spilldeltagelse> spilldeltagelseListe = spillDAO.hentSpillDeltagelseListe(spill.getId());

            int spilldeltagelseId = 0;
            for (Spilldeltagelse spilldeltagelse : spilldeltagelseListe) {
                if (spilldeltagelse.getBruker() == spill.getBrukerTur()) spilldeltagelseId = spilldeltagelse.getId();
            }

            Spilldeltagelse spilldeltagelse = spillDAO.hentSpillDeltagelse(spilldeltagelseId);

            Bruker bruker = (Bruker) sesjon.getAttribute("bruker");


            if (spilldeltagelse.getRunde() >= 16) {
                //oppdater bruker til neste bruker eller send til historikk om spillet er avsluttet
            }

            Kopp kopp = spill.getKopp();
            String[] checkedBokser = request.getParameterValues("terninger");
            boolean[] tester = new boolean[checkedBokser.length];

            for (int i = 0; i < checkedBokser.length; i++) {
                if (checkedBokser[i] == null) tester[i] = false;
                else tester[i] = true;
            }

            kopp.rullKopp(tester);


            int res = YatzyUtil.sjekkKast(kopp, spilldeltagelse.getRunde());

            spilldeltagelse.setKast(+1);

            if (spilldeltagelse.getKast() == 3) {
                YatzyUtil.oppdaterVerdi(res, spilldeltagelse.getRunde(), spilldeltagelse);
                spilldeltagelse.setKast(0);
                //For å sette neste tur så bruker vi spillDeltagelseList til å hente neste index.
                spilldeltagelse.setRunde(+1);
                spillDAO.lagreSpillDeltagelse(spilldeltagelse);
            }

            // request.getSession().setAttribute("kopp" , terningverdier);
            request.getSession().setAttribute("resultat", res);

            //request.getSession().setAttribute("nyttspill", nyttspill);
            response.sendRedirect("spill");

        }
    }
}
