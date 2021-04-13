package no.gruppe6.yatzy.servlets;

import no.gruppe6.yatzy.util.LoggInnUt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoggUtServlet
 */

@WebServlet("/LoggUtServlet")
public class LoggUtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoggUtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * this method handles the log out of the user
	 * @param request is an object which is being passed as an argument to the servlet's service methods
	 * @param response is an object for HttpServlets to return information to the client
	 * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
	 * @throws IOException It provides information to the caller of the method about the exception.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoggInnUt.loggUt(request);

		request.getRequestDispatcher("pages/logginn.jsp").forward(request, response);
	}


}
