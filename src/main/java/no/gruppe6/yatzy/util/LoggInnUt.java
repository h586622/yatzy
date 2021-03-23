package no.gruppe6.yatzy.util;

import no.gruppe6.yatzy.entities.Bruker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LoggInnUt {
	
	public static void loggInn(HttpServletRequest request, Bruker bruker) {
		HttpSession sesjon = request.getSession(false);
		if (sesjon != null) {
			sesjon.invalidate();
		}
		sesjon = request.getSession(true);
		sesjon.setMaxInactiveInterval(120);

		sesjon.setAttribute("bruker", bruker);
	}
	
	
	public static boolean isLoggedIn(HttpServletRequest req) {
		HttpSession sesjon = req.getSession(false);
		if(sesjon==null) 
			return false;
		
		return sesjon.getAttribute("bruker")!=null;
		
		
		
	}
	
	public static void loggUt(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
        if (sesjon != null) {
            sesjon.invalidate();
        }
	}

}
