package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.entities.Spill;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Lobby")
public class LobbyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("pages/Lobby.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesjon = request.getSession(false);

        if (sesjon == null || sesjon.getAttribute("username") == null) {
            response.sendRedirect("logginn");
        }else{
            String spillnavn = request.getParameter("nyttspill");
            if(spillnavn == null){
                response.sendRedirect("startside");
            }else{
                Spill spill = new Spill();
                spill.setNavn(spillnavn);
                sesjon.setAttribute("spillnavn", spillnavn);
            }
            response.sendRedirect("Lobby");
        }


    }
}
