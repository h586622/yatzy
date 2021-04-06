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
        if (!LoggInnUt.isLoggedIn(request)) {
            response.sendRedirect("logginn?requiresLogin");
        } else {

            //Her bør det gjøres sjekk på om bruker er spectator, deltager med tur eller deltager uten tur.
            Bruker bruker = (Bruker) sesjon.getAttribute("bruker");

            String ids = request.getParameter("spill");
            int id = Integer.parseInt(ids);

            Spill spill = spillDAO.hentSpill(id);
            List<Spilldeltagelse> spilldeltagelser = spillDAO.hentSpillDeltagelseListe(spill);

            request.setAttribute("spill", spill);
            request.setAttribute("spilldeltagelser", spilldeltagelser);

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
            Bruker bruker = (Bruker) sesjon.getAttribute("bruker");
            Spill spill = spillDAO.hentSpill(id);
            System.out.println(spill.getId());
            Spilldeltagelse spilldeltagelse = spillDAO.hentSpillDeltagelseBrukerSpill(bruker, spill);





            if (spilldeltagelse.getRunde() >= 16) {
                //oppdater bruker til neste bruker eller send til historikk om spillet er avsluttet
            }

            Kopp kopp = spill.getKopp();

            String[] checkedBokser = request.getParameterValues("terninger");
            boolean[] tester = new boolean[5];

            if(checkedBokser != null){
                for(int i = 0; i<checkedBokser.length; i++){
                    tester[Integer.parseInt(checkedBokser[i])] = true;
                }
            }



            kopp.rullKopp(tester);



            int res = YatzyUtil.sjekkKast(kopp, spilldeltagelse.getRunde());

            spilldeltagelse.setKast(+1);

            if (spilldeltagelse.getKast() == 3) {
                YatzyUtil.oppdaterVerdi(res, spilldeltagelse.getRunde(), spilldeltagelse);
                spilldeltagelse.setKast(0);
                //For å sette neste tur så bruker vi spillDeltagelseList til å hente neste index.
                spilldeltagelse.setRunde(+1);

            }

            spillDAO.lagreSpillDeltagelse(spilldeltagelse);
            spillDAO.lagreSpill(spill);

            // request.getSession().setAttribute("kopp" , terningverdier);
            request.getSession().setAttribute("resultat", res);

            //request.getSession().setAttribute("nyttspill", nyttspill);
            response.sendRedirect("spill?spill=" + spill.getId());

        }
    }
}
