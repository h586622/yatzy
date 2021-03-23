package no.gruppe6.yatzy.util;


import no.gruppe6.yatzy.entities.Kopp;
import no.gruppe6.yatzy.entities.Terning;

public class YatzyUtil {

	
	public static int sjekkKast(Kopp kopp, int runde) {
		int verdi = 0;
		switch(runde) {
		case 1 : verdi = enkleRuter(kopp, runde);break;
		case 2 : verdi = enkleRuter(kopp, runde);break;
		case 3 : verdi = enkleRuter(kopp, runde);break;
		case 4 : verdi = enkleRuter(kopp, runde);break;
		case 5 : verdi = enkleRuter(kopp, runde);break;
		case 6 : verdi = enkleRuter(kopp, runde);break;
		case 7 : ;break;
		case 8 : ;break;
		case 9 : ;break;
		case 10 : ;break;
		case 11 : ;break;
		case 12 : ;break;
		case 13 : ;break;
		case 14 : ;break;
		case 15 : ;break;
		default : ;break;
		}
		
		return verdi;
	}
	
	private static int enkleRuter(Kopp kopp, int runde) {
		int resultat = 0;
		for(Terning t : kopp.getTerninger()) {
			if (t.getVerdi() == runde) {
				resultat += t.getVerdi();
			}
		}
		return resultat;
	}
}
