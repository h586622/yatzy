package no.gruppe6.yatzy.util;

import no.gruppe6.yatzy.entities.Bruker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LoggInnUt {

	/**
	 * This method logs a user in to the website
	 * @param request is an object which is being passed as an argument to the servlet's service methods
	 * @param bruker is the user who wants to sign in
	 */
	public static void loggInn(HttpServletRequest request, Bruker bruker) {
		HttpSession sesjon = request.getSession(false);
		if (sesjon != null) {
			sesjon.invalidate();
		}
		sesjon = request.getSession(true);
		sesjon.setMaxInactiveInterval(120);

		sesjon.setAttribute("bruker", bruker);
	}

	/**
	 * This method checks if a user is signed out
	 * @param req is an object which is being passed as an argument to the servlet's service methods
	 * @return
	 */
	public static boolean isLoggedIn(HttpServletRequest req) {
		HttpSession sesjon = req.getSession(false);
		if(sesjon==null) 
			return false;
		
		return sesjon.getAttribute("bruker")!=null;
		
		
		
	}

	/**
	 * This method logs a user out of the website
	 * @param request is an object which is being passed as an argument to the servlet's service methods
	 */
	public static void loggUt(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
        if (sesjon != null) {
            sesjon.invalidate();
        }
	}

}
