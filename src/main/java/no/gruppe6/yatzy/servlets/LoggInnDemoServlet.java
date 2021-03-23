package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.BrukerDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.util.LoggInnUtUtil;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoggInnDemoServlet", value = "/LoggInnDemoServlet")
public class LoggInnDemoServlet extends HttpServlet {

    @EJB
    private BrukerDAO brukerDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String brukernavn = request.getParameter("brukernavn");
        if(brukernavn == null || brukernavn.equals("")){
            response.sendRedirect("LoggInnDemoServlet?feilmelding=feilBruker");
        }else{
            Bruker b = brukerDAO.finnBrukerMedBrukernavn(brukernavn);
            if(b == null){
              //  b = new Bruker(brukernavn);
                brukerDAO.lagreBruker(b);
            }

            LoggInnUtUtil.loggInn(request, b);

            response.sendRedirect("DemoServlet");
        }
    }
}
