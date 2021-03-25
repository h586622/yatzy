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
			case 7 : verdi = ettPar(kopp);break;
			case 8 : verdi = toPar(kopp);break;
			case 9 : verdi = treLike(kopp);break;
			case 10 : verdi = fireLike(kopp);break;
			case 11 : verdi = litenStraight(kopp);break;
			case 12 : verdi = storStraight(kopp);break;
			case 13 : verdi = hus(kopp);break;
			case 14 : verdi = sjanse(kopp);break;
			case 15 : verdi = yatzy(kopp);break;
			default : System.out.println("Noe gikk feil") ;break;
		}

		return verdi;
	}

	private static int enkleRuter(Kopp kopp, int runde) {
		int resultat = 0;
		for(Terning t : kopp.getTerninger()) {
			if (t.getVerdi() == runde) {
				resultat += runde;
			}
		}
		return resultat;
	}

	private static int ettPar(Kopp kopp) {
		int hoyestePar = 0;
		int nyttPar = 0;
		Terning[] terninger = kopp.getTerninger();
		for (int i = 0; i<5;i++) {
			for (int k = i+1;k<5;k++) {
				if (terninger[i].getVerdi() == terninger[k].getVerdi())
					nyttPar = terninger[i].getVerdi() *2;
				if (nyttPar > hoyestePar)
					hoyestePar = nyttPar;
			}
		}
		return hoyestePar;
	}
	private static int toPar(Kopp kopp) {
		int hoytPar = ettPar(kopp);
		int lavtPar = 0;
		int nyttPar = 0;
		Terning[] terninger = kopp.getTerninger();
		for (int i = 0; i<5;i++) {
			for (int k = i+1;k<5;k++) {
				if (terninger[i].getVerdi() == terninger[k].getVerdi())
					nyttPar = terninger[i].getVerdi() *2;
				if (nyttPar < hoytPar)
					lavtPar = nyttPar;
			}
		}

		if (hoytPar > 0 && lavtPar > 0)
			return hoytPar + lavtPar;
		else{
			return 0;
		}
	}

	private static int treLike(Kopp kopp) {
		int treLike = 0;
		Terning[] terninger = kopp.getTerninger();
		for (int i = 0;i<5;i++) {
			for (int k=i+1;k<5;k++) {
				if (terninger[i].getVerdi() == terninger[k].getVerdi()) {
					for (int t = k+1;t<5;t++) {
						if (terninger[t].getVerdi() == terninger[k].getVerdi())
							treLike = terninger[t].getVerdi() * 3;
					}
				}
			}
		}
		return treLike;
	}
	private static int fireLike(Kopp kopp) {
		int fireLike = 0;
		Terning[] terninger = kopp.getTerninger();
		for (int i = 0;i<5;i++) {
			for (int k=i+1;k<5;k++) {
				if (terninger[i].getVerdi() == terninger[k].getVerdi()) {
					for (int t = k+1;t<5;t++) {
						if (terninger[t].getVerdi() == terninger[k].getVerdi())
							for (int s = t+1;s<5;s++) {
								if (terninger[s].getVerdi() == terninger[t].getVerdi())
									fireLike = terninger[t].getVerdi() * 4;

							}
					}
				}
			}
		}
		return fireLike;
	}
	private static int litenStraight(Kopp kopp) {
		Terning[] terninger = kopp.getTerninger();
		if(sjanse(kopp) == 15){
			for (int i = 0;i<4;i++){
				if (terninger[i].getVerdi() == terninger[i+1].getVerdi())
					return 0;
			}
			return 15;
		}else
			return 0;
	}
	private static int storStraight(Kopp kopp) {
		Terning[] terninger = kopp.getTerninger();
		if(sjanse(kopp) == 20){
			for (int i = 0;i<4;i++){
				if (terninger[i].getVerdi() == terninger[i+1].getVerdi())
					return 0;
			}

			return 20;
		}else
			return 0;
	}
	private static int hus(Kopp kopp) {
		int trelike = treLike(kopp);
		int par = 0;
		int tempVerdi = 0;
		Terning[] terninger = kopp.getTerninger();
		if(trelike > 0) {
			int likverdi = trelike/3;
			for (int i = 0 ; i<5;i++){
				if (terninger[i].getVerdi() != likverdi ){
					if(tempVerdi == 0)
						tempVerdi = terninger[i].getVerdi();
					else
						if (terninger[i].getVerdi() == tempVerdi)
							par = tempVerdi*2;

				}

			}
		}
		if (par > 0 && trelike > 0)
			return par + trelike;
		else
			return 0;
	}
	private static int sjanse(Kopp kopp) {
		Terning[] terninger = kopp.getTerninger();
		return terninger[0].getVerdi() + terninger[1].getVerdi() + terninger[2].getVerdi() + terninger[3].getVerdi() + terninger[4].getVerdi();
	}
	private static int yatzy(Kopp kopp) {

		Terning[] terninger = kopp.getTerninger();
		if (terninger[0].getVerdi() == terninger[1].getVerdi() && terninger[0].getVerdi() == terninger[2].getVerdi() && terninger[0].getVerdi() == terninger[3].getVerdi() && terninger[4].getVerdi() == terninger[0].getVerdi())
			return 50;
		else
			return 0;

	}
}