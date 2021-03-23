package no.gruppe6.yatzy.entities;

public class Terning {
	
	private int verdi;
	private String navn;
	
	public Terning() {
		verdi = 0;
	}
	public Terning(String navn) {
		this.navn=navn;
		verdi=0;
	}
	public Terning(String navn, int verdi) {
		this.navn = navn;
		this.verdi = verdi;
	}
	
	public int rull() {
		verdi = (int) (Math.random() * 6 + 1);
		return verdi;
	}
	public int getVerdi() {
		return verdi;
	}
	public void setVerdi(int verdi) {
		this.verdi = verdi;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	
	

}
