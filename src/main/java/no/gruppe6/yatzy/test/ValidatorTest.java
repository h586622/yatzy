package no.gruppe6.yatzy.test;

import static org.junit.Assert.*;

import no.gruppe6.yatzy.util.Validator;
import org.junit.Test;

public class ValidatorTest {

    /*
     * A valid username should be at least 4 characters and contain
     * only letters and numbers, but not starting with a number.
     */
    @Test
    public void validUsernamesShouldBeOk() {
        assertTrue(Validator.isValidUsername("aaaa"));
        assertTrue(Validator.isValidUsername("aAaA"));
        assertTrue(Validator.isValidUsername("abc4"));
        assertTrue(Validator.isValidUsername("A6789b"));
        assertTrue(Validator.isValidUsername("A6789b"));
    }
    
    @Test
    public void norwegianLettersShouldBeAllowed() {
        assertTrue(Validator.isValidUsername("æøåÆØÅ"));
    }
    
    @Test
    public void shortUsernamesShouldNotBeOk() {
        assertFalse(Validator.isValidUsername(null));
        assertFalse(Validator.isValidUsername(""));
        assertFalse(Validator.isValidUsername("a"));
        assertFalse(Validator.isValidUsername("ABC"));
    }
    
    @Test
    public void usernamesWithIllegalCharsShouldNotBeOk() {
        assertFalse(Validator.isValidUsername("a-bcd"));
        assertFalse(Validator.isValidUsername("a@bcd"));
    }
    
    @Test
    public void usernamesStartingWithANumberShouldNotBeOk() {
        assertFalse(Validator.isValidUsername("1abcde"));
        assertFalse(Validator.isValidUsername("0ABCDE"));
    }    
    
    
    @Test
    public void epostGyldig() {
    	assertTrue(Validator.sjekkEpost("erik@ost.no"));
    	assertTrue(Validator.sjekkEpost("123@456.no"));
    	assertTrue(Validator.sjekkEpost("STOR@BOKSTAV.NO"));
    	assertTrue(Validator.sjekkEpost("1en2to@3tre.com"));
    	assertTrue(Validator.sjekkEpost("?!?@milk.org"));
    	assertTrue(Validator.sjekkEpost("u@ost.no"));
    	
    }
    @Test
    public void epostUgyldig() {
    	assertFalse(Validator.sjekkEpost("heihei"));
    	assertFalse(Validator.sjekkEpost("123"));
    	//assertFalse(Validator.sjekkEpost("1@2"));
    	assertFalse(Validator.sjekkEpost("vg.no"));
    	assertFalse(Validator.sjekkEpost("%&/"));
    	//assertFalse(Validator.sjekkEpost("123hei@123hei"));
    	assertFalse(Validator.sjekkEpost("@nrk.no"));
    	assertFalse(Validator.sjekkEpost("tegn!@tegn(.se"));

    }
    @Test
    public void gyldigPassord() {
    	assertTrue(Validator.passordSjekk("1En!sekslang"));
    	assertTrue(Validator.passordSjekk("LANG123#lang"));
    	assertTrue(Validator.passordSjekk("ko!T3)"));
    	assertTrue(Validator.passordSjekk("FysiskLab44&"));
    	assertTrue(Validator.passordSjekk("(89entotrE%"));
    	assertTrue(Validator.passordSjekk("Nytt3!Passord"));
    }
    @Test
    public void ugyldigPassord() {
    	assertFalse(Validator.passordSjekk("baresmaabokstaver"));
    	assertFalse(Validator.passordSjekk("IKKETALL"));
    	assertFalse(Validator.passordSjekk("1utenTegn"));
    	assertFalse(Validator.passordSjekk("!utenTall"));
    	assertFalse(Validator.passordSjekk("manglerstorbokstav123!"));
    	assertFalse(Validator.passordSjekk("manglerTegn123"));
    	assertFalse(Validator.passordSjekk("BARESTOREBOKSTAVER"));
    	assertFalse(Validator.passordSjekk("!#!!123"));
    	assertFalse(Validator.passordSjekk("!1eR"));
    }
}
