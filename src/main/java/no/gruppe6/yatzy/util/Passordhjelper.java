package no.gruppe6.yatzy.util;


import no.gruppe6.yatzy.entities.Passord;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * This class contains the logic behind hashing and validating of the passwords
 */
public class Passordhjelper {
	
	private static final int SALT_LENGTH = 16;

	/**
	 * This method generates a random salt to be used as a safe storing mechanism for passwords
	 * @return a random generated salt as a String
	 */
	public static String genererTilfeldigSalt() {
	    SecureRandom sr;
	    byte[] salt = new byte[SALT_LENGTH];
		try {
			sr = SecureRandom.getInstance("SHA1PRNG");
		    sr.nextBytes(salt);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	    return DatatypeConverter.printHexBinary(salt);
	}

	/**
	 * This method hashes the password using the SHA-256 algorithm
	 * @param passord is the password the user has chosen, represented as a String
	 * @param salt is the is the salt being used to store the password in a safe way
	 * @return the hashed password as a String, combined of the salt and the password chosen by the user
	 */
	public static String hashMedSalt(String passord, String salt) {
		
		byte[] passhash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] saltbytes = DatatypeConverter.parseHexBinary(salt);
			md.update(saltbytes);
			passhash = md.digest(passord.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return DatatypeConverter.printHexBinary(passhash);
	}

	/**
	 * This method validates the password of a user
	 * @param input is the indicated password of the user
	 * @param kryptert is the encrypted stored password
	 * @return true or false
	 */
	public static boolean valider(String input, Passord kryptert) {
		return kryptert.getHash().equals(hashMedSalt(input, kryptert.getSalt())); 
	}
	
	
}
