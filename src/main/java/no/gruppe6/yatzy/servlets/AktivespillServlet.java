package no.gruppe6.yatzy.servlets;


import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.entities.Spilldeltagelse;
import no.gruppe6.yatzy.util.LoggInnUt;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servlet implements class AktivespillServlet
 */

@WebServlet("/aktivespill")
    public class AktivespillServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        @EJB
        SpillDAO spillDAO;

    /**
     * This servlet handles your in progress games, checks to se if the user is logged in, starts a session
     * and gets all your in progress games.
     * @param request is an object which is being passed as an argument to the servlet's service methods
     * @param response is an object for HttpServlets to return information to the client
     * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
     * @throws IOException It provides information to the caller of the method about the exception.
     */

        @Override
        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {
            if(!LoggInnUt.isLoggedIn(request)){
                response.sendRedirect("logginn?requiresLogin");
            }else {
                HttpSession sesjon = request.getSession(false);
                Bruker bruker = (Bruker) sesjon.getAttribute("bruker");
                List<Spilldeltagelse> spilldeltagelser = spillDAO.hentSpillDeltagelserMedBrukerid(bruker);
                List <Spill> spilliste = spilldeltagelser.stream()
                        .filter(x-> x.getSpill().getSpillstatus().equals("aktiv"))
                        .map(Spilldeltagelse::getSpill)
                        .collect(Collectors.toList());
                request.setAttribute("spilliste", spilliste);
                request.getRequestDispatcher("pages/aktivespill.jsp")
                        .forward(request, response);
            }

        }
    }

