package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.BrukerDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Kast;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "DemoServlet", value = "/DemoServlet")
public class DemoServlet extends HttpServlet {


    @EJB
    private BrukerDAO brukerDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesjon = request.getSession(false);
        Bruker b = (Bruker) sesjon.getAttribute("bruker");

        List<Kast> kastList = brukerDAO.finnAlleKast();
        List<Kast> filtrertKastList = kastList.stream().filter(x -> x.getBruker().equals(b)).collect(Collectors.toList());
        request.setAttribute("kastliste", filtrertKastList);

        request.getRequestDispatcher("demoside.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesjon = request.getSession(false);
        Bruker b = (Bruker) sesjon.getAttribute("bruker");
        int verdi = (int) Math.random()*6+1;
        Kast k = new Kast(b, verdi);
        brukerDAO.lagreKast(k);

        response.sendRedirect("DemoServlet");

    }
}
