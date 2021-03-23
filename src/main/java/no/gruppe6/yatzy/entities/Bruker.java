package no.gruppe6.yatzy.entities;

public class Bruker {
	
	private String brukernavn;
	private String epost;
	private Passord passord;
	private boolean admin;
	
	public Bruker(String brukernavn, String epost, Passord passord) {
		this.brukernavn = brukernavn;
		this.epost = epost;
		this.passord = passord;
		admin = false;
	}
	
	public Bruker() {
		
	}
	
	
	

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getEpost() {
		return epost;
	}

	public void setEpost(String epost) {
		this.epost = epost;
	}

	public Passord getPassord() {
		return passord;
	}

	public void setPassord(Passord passord) {
		this.passord = passord;
	}
	
	

}
