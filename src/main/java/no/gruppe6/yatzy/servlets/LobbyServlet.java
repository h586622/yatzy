package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.BrukerDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.entities.Spilldeltagelse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Lobby")
public class LobbyServlet extends HttpServlet {

    BrukerDAO bdDao = new BrukerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

                Spilldeltagelse spilldeltagelse = new Spilldeltagelse();
                spilldeltagelse.setBruker(bruker);
                spilldeltagelse.setSpill(spill);
            }
            response.sendRedirect("Lobby");
        }
        System.out.println("test3");

    }
}
