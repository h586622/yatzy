package no.gruppe6.yatzy.util;


import no.gruppe6.yatzy.entities.Passord;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Passordhjelper {
	
	private static final int SALT_LENGTH = 16;

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
	
	public static boolean valider(String input, Passord kryptert) {
		return kryptert.getHash().equals(hashMedSalt(input, kryptert.getSalt())); 
	}
	
	
}
