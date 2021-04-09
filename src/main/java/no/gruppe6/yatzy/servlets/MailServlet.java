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

@WebServlet("/mail")
public class MailServlet extends HttpServlet {

    @EJB
    private SpillDAO spillDao;
    @EJB
    private BrukerDAO brukerDao;




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int spillid = Integer.parseInt(request.getParameter("spill"));
        Bruker brukertur = spillDao.hentSpill(spillid).getBrukerTur();
        String epost = brukertur.getEpost();
        Spill spill = spillDao.hentSpill(spillid);
        try {
            JavaMailUtil.setupMail(epost,"Det er din tur i Yatzy-spillet " + spill.getNavn(),"Resten av deltagerene venter på deg.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        request.setAttribute("spill", spillid);

        response.sendRedirect("spill?spill=" + spillid);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {










    }
}
