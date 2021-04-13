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

/**
 * Servlet implements class LoggInnServlet
 */

@WebServlet("/logginn")
public class LoggInnServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @EJB
    private BrukerDAO dbDao;

    /**
     * doGet that handles error messages the logg in functions.
     * @param request is an object which is being passed as an argument to the servlet's service methods
     * @param response is an object for HttpServlets to return information to the client
     * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
     * @throws IOException It provides information to the caller of the method about the exception.
     */

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

    /**
     * doPost validate that the user exists in the database and the corresponding password
     * @param request is an object which is being passed as an argument to the servlet's service methods
     * @param response is an object for HttpServlets to return information to the client
     * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
     * @throws IOException It provides information to the caller of the method about the exception.
     */

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
