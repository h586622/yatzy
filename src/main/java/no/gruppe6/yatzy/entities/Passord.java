package no.gruppe6.yatzy.entities;

import no.gruppe6.yatzy.util.Passordhjelper;

import javax.persistence.Embeddable;


@Embeddable
public class Passord {

	private String pwd_hash;
    private String pwd_salt;

	/**
	 * Constructor for the class Passord
	 * @param hash is the password after it has been through a hashing algorithm
	 * @param salt is the salt being used to store the password in a safe way, represented by a String
	 */
	private Passord(String hash, String salt) {
		pwd_hash = hash;
		pwd_salt = salt;
	}

	/**
	 * Default constructor of the class Passord
	 */
	public Passord() {}

	/**
	 * toString method
	 * @return the hash and the salt in the password as a String
	 */
	@Override
	public String toString() {
		return "Passord [pwd_hash=" + pwd_hash + ", pwd_salt=" + pwd_salt + "]";
	}

	/**
	 * This method creates a password using a random generated salt and then hashes it using the
	 * original password and the salt
	 * @param passordKlartekst is the password the user has chosen, represented as a String
	 * @return a password, containing a String of the hashed password and a String of the random salt
	 */
	public static Passord lagPassord(String passordKlartekst) {
		String salt = Passordhjelper.genererTilfeldigSalt();
		String hash = Passordhjelper.hashMedSalt(passordKlartekst, salt);
		return new Passord(hash, salt);
	}

	/**
	 * Getters and setters for the object variables
	 */
	public String getHash() {
		return pwd_hash;
	}

	public String getSalt() {
		return pwd_salt;
	}

	private void setHash(String pwd_hash) {
		this.pwd_hash = pwd_hash;
	}

	private void setSalt(String pwd_salt) {
		this.pwd_salt = pwd_salt;
	}
}
