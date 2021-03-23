package no.gruppe6.yatzy.util;

import no.gruppe6.yatzy.entities.Bruker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoggInnUtUtil {

    public static void loggInn(HttpServletRequest request, Bruker bruker) {
        HttpSession sesjon = request.getSession(false);
        if (sesjon != null) {
            sesjon.invalidate();
        }
        sesjon = request.getSession(true);
        sesjon.setMaxInactiveInterval(120);

        sesjon.setAttribute("bruker", bruker);
    }
}
