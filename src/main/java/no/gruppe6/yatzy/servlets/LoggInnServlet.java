package no.gruppe6.yatzy.servlets;
import no.gruppe6.yatzy.dao.BrukerDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.util.LoggInnUt;
import no.gruppe6.yatzy.util.Passordhjelper;
import no.gruppe6.yatzy.util.Validator;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logginn")
public class LoggInnServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @EJB
    private BrukerDAO dbDao;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        if(!LoggInnUt.isLoggedIn(request)) {
            String loginMessage = "";

            if (request.getParameter("requiresLogin") != null) {
                loginMessage = "Forespørselen din krever pålogging. "
                        + "(Du kan ha blitt logget ut automatisk)";

            } else if (request.getParameter("invalidUser") != null) {
                loginMessage = "Ugyldig brukernavn og/eller passord";
            }

            request.setAttribute("loginMessage", loginMessage);

            request.getRequestDispatcher("pages/logginn.jsp").forward(request, response);
        }else{
            response.sendRedirect("startside");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String brukernavn = request.getParameter("brukernavn");
        String passord = request.getParameter("passord");
        Bruker bruker = null;
        String admin = getServletContext().getInitParameter("Admin");

        if(Validator.isValidUsername(brukernavn) && Validator.passordSjekk(passord))
            bruker = dbDao.finnBrukerMedBrukernavn(brukernavn);

        if (bruker == null || !Passordhjelper.valider(passord, bruker.getPassord())) {
            response.sendRedirect("logginn?invalidUser");

        } else {
            LoggInnUt.loggInn(request, bruker);
            if (brukernavn.equals(admin)) {
                response.sendRedirect("admin");
            } else {
                response.sendRedirect("startside");
            }
        }
         

        
    }
}
