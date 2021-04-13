package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.BrukerDAO;
import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.entities.Spilldeltagelse;
import no.gruppe6.yatzy.util.JavaMailUtil;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Servlet implements class MailServlet
 */
@WebServlet("/mail")
public class MailServlet extends HttpServlet {

    @EJB
    private SpillDAO spillDao;
    @EJB
    private BrukerDAO brukerDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       int spillid = Integer.parseInt(request.getParameter("spill"));
       String handling = request.getParameter("mail");
        response.sendRedirect("mail?mail="+handling+"&spill=" + spillid);

    }


    /**
     * this method notify the user by email when its their turn in an active game.
     * @param request is an object which is being passed as an argument to the servlet's service methods
     * @param response is an object for HttpServlets to return information to the client
     * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
     * @throws IOException It provides information to the caller of the method about the exception.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int spillid = Integer.parseInt(request.getParameter("spill"));
        Bruker brukertur = spillDao.hentSpill(spillid).getBrukerTur();
        String epost = brukertur.getEpost();
        Spill spill = spillDao.hentSpill(spillid);
        // params for å sjekke antall purr og tiden mellom hver purr
        Spilldeltagelse sdt = spillDao.hentSpillDeltagelseBrukerSpill(brukertur, spill);
        int antallpurr = sdt.getAntallpurr();
        LocalTime purren = sdt.getPurren();
        String emne = "Det er din tur i Yatzy-spillet";
        String tekst = "";

        //Duration duration = Duration.between(LocalTime.now(),purren);
        //boolean tid = duration.getSeconds() >= 20;

        if(true) {
            switch (antallpurr){
                case 0:
                    sdt.setAntallpurr(1);
                    sdt.setPurren(LocalTime.now());
                    tekst = "Dette er den første purringen.";
                    break;
                case 1:
                    sdt.setAntallpurr(2);
                    sdt.setPurren(LocalTime.now());
                    tekst = "Dette er den andre purringen.";
                    break;
                case 2:
                   emne = "Du er blitt fjernet fra spillet";
                   tekst = "Grunnet inaktivitet er du fjernet fra spillet";
                   break;
                default: System.out.println("Bunnen av switch case");
            }

            spillDao.lagreSpillDeltagelse(sdt);
            try {
                JavaMailUtil.setupMail(epost, emne, tekst);
                System.out.println("purremail sendt");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("spill?spill=" + spillid);

    }



    }

