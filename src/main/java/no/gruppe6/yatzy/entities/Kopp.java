package no.gruppe6.yatzy.entities;

public class Kopp {
	
	public Terning[] terninger;
	
	public Kopp() {
		terninger = new Terning[5];
		for (int i = 0; i<terninger.length; i++) {
			terninger[i] = new Terning("t"+(i+1));
		}
	}
	
	public String toString() {
		String koppString = "";
		for(Terning t : terninger) {
			koppString += t.getNavn() + " har verdien " + t.getVerdi() + "\n";
		}
		return koppString;
	}
	
	public void rullKopp() {
		for (Terning t : terninger) {
			t.rull();
		}
		System.out.println(toString());
	}
	
	public Terning[] getTerninger() {
		return terninger;
	}
}
