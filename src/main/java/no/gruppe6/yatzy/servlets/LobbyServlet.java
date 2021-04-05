package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.BrukerDAO;
import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.entities.Spilldeltagelse;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Lobby")
public class LobbyServlet extends HttpServlet {
    @EJB
    private SpillDAO spillDAO;
    @EJB
    private BrukerDAO bdDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Spill spill = spillDAO.hentSpill(Integer.parseInt(request.getParameter("spill")));
        System.out.println(spill.getId() + "ops");

        request.setAttribute("spill", spill);

        request.getRequestDispatcher("pages/Lobby.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesjon = request.getSession(false);
        System.out.println("test1");
        if (sesjon == null || sesjon.getAttribute("bruker") == null) {
            System.out.println("test2");
            response.sendRedirect("logginn");
        }else{
            Bruker bruker = (Bruker) sesjon.getAttribute("bruker");
            String spillnavn = request.getParameter("nyttspill");
            System.out.println("test");
            if(spillnavn == null){
                System.out.println("test");
                response.sendRedirect("startside");
            }else{
                Spill spill = new Spill();
                spill.setNavn(spillnavn);
                spill.setBrukerTur(bruker);
                spill.setSpillstatus("ledig");
                spillDAO.lagreNyttSpill(spill);



                Spilldeltagelse spilldeltagelse = new Spilldeltagelse();
                spilldeltagelse.setBruker(bruker);
                spilldeltagelse.setSpill(spill);
                spillDAO.lagreNySpilldeltagelse(spilldeltagelse);

                Spill spill2 = spillDAO.hentSpillMedNavn(spillnavn);

                response.sendRedirect("Lobby?spill="+ spill2.getId());
            }

        }
        System.out.println("test3");

    }
}
