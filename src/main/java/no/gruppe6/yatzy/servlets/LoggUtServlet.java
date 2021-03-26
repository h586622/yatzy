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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoggUtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoggInnUt.loggUt(request);

		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}


}
