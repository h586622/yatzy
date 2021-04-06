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

@WebServlet("/aktivespill")
    public class AktivespillServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        @EJB
        SpillDAO spillDAO;

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

