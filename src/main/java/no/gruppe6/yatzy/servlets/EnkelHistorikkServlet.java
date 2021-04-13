package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.entities.Spilldeltagelse;
import no.gruppe6.yatzy.util.LoggInnUt;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
/**
 * This servlet Servlet implements class EnkelHistorikkServlet
 */

@WebServlet(name = "enkelHistorikk", value = "/enkelHistorikk")
public class EnkelHistorikkServlet extends HttpServlet {

    @EJB
    private SpillDAO dbDao;

    /**
     *this method handles the users previous games.
     * @param request is an object which is being passed as an argument to the servlet's service methods
     * @param response is an object for HttpServlets to return information to the client
     * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
     * @throws IOException It provides information to the caller of the method about the exception.
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(!LoggInnUt.isLoggedIn(request)){
            response.sendRedirect("logginn?requiresLogin");
        }else{
            int spillid = Integer.parseInt(request.getParameter("spillid"));
            Spill spill = dbDao.hentSpill(spillid);
            List<Spilldeltagelse> spilldeltagelser = dbDao.hentSpillDeltagelseListe(spill);
            request.setAttribute("spilldeltagelser", spilldeltagelser);

            request.getRequestDispatcher("pages/spillHistorikk.jsp")
                    .forward(request, response);
        }


    }


}
