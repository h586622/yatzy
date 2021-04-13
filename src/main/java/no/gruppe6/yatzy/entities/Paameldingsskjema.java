package no.gruppe6.yatzy.entities;

import no.gruppe6.yatzy.util.Validator;

import javax.servlet.http.HttpServletRequest;

/**
 * This class handles the logic behind the registration of a user
 */
public class Paameldingsskjema {

    private String brukernavn;
    private String fornavn;
    private String etternavn;
    private String epost;
    private String passord;
    private String passordRepetert;
    private String brukernavnFeilmelding;
    private String epostFeilmelding;
    private String fornavnFeilmelding;
    private String etternavnFeilmelding;
    private String passordFeilmelding;
    private String passordRepetertFeilmelding;

    /**
     * Constructor for the registration form
     * @param request requests parameters from a servlet
     */
    public Paameldingsskjema(HttpServletRequest request) {
        this.brukernavn = escapeHtml(request.getParameter("brukernavn"));
        this.fornavn = escapeHtml(request.getParameter("fornavn"));
        this.etternavn = escapeHtml(request.getParameter("etternavn"));
        this.passord = escapeHtml(request.getParameter("passord"));
        this.passordRepetert = escapeHtml(request.getParameter("passordRepetert"));
        this.epost = escapeHtml(request.getParameter("epost"));

    }

    /**
     * This method validates the user input as a whole
     * @return returns true or false depending on the validation of
     * the different variables, if one fails, false is returned.
     */
    public boolean allInputGyldig() {
        return Validator.isValidFirstName(fornavn) && Validator.isValidLastName(etternavn)
                && Validator.passordSjekk(passord) && Validator.isValidRepeatedPassword(passord,passordRepetert)
                && Validator.isValidUsername(brukernavn) && Validator.sjekkEpost(epost);
    }

    /**
     * This method sets the error messages for the validations.
     */
    public void settOppFeilmeldinger() {
        if(!Validator.isValidFirstName(fornavn)) {
            fornavn = "";
            fornavnFeilmelding = "Ugyldig fornavn";
        }
        if(!Validator.isValidLastName(etternavn)) {
            etternavn ="";
            etternavnFeilmelding = "Ugyldig etternavn";
        }
        if(!Validator.passordSjekk(passord)) {
            passord="";
            passordFeilmelding ="Ugyldig passord";
        }
        if(!Validator.isValidRepeatedPassword(passord, passordRepetert)) {
            passordRepetert ="";
            passordRepetertFeilmelding = "Passordene må være like";
        }
        if(!Validator.isValidUsername(brukernavn)) {
            brukernavn = "";
            brukernavnFeilmelding = "Ugyldig brukernavn";
        }
        if(!Validator.sjekkEpost(epost)) {
            epost = "";
            epostFeilmelding = "Ugyldig e-post";
        }
    }

    /**
     * sets the error message for when a username is already taken
     */
    public void ikkeUniktBrukernavn() {
        brukernavn = "";
        brukernavnFeilmelding = "Brukernavnet eksisterer i databasen fra før.";
    }

    /**
     * setts the error message for when a email is already registered
     */
    public void ikkeUnikEpost() {
        epost = "";
        epostFeilmelding = "Epost eksisterer i databasen fra før.";
    }

    /**
     * Getters and setters for the object variables
     */
    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getPassordRepetert() {
        return passordRepetert;
    }

    public void setPassordRepetert(String passordRepetert) {
        this.passordRepetert = passordRepetert;
    }

    public String getBrukernavnFeilmelding() {
        return brukernavnFeilmelding;
    }

    public void setBrukernavnFeilmelding(String brukernavnFeilmelding) {
        this.brukernavnFeilmelding = brukernavnFeilmelding;
    }

    public String getEpostFeilmelding() {
        return epostFeilmelding;
    }

    public void setEpostFeilmelding(String epostFeilmelding) {
        this.epostFeilmelding = epostFeilmelding;
    }

    public String getFornavnFeilmelding() {
        return fornavnFeilmelding;
    }

    public void setFornavnFeilmelding(String fornavnFeilmelding) {
        this.fornavnFeilmelding = fornavnFeilmelding;
    }

    public String getEtternavnFeilmelding() {
        return etternavnFeilmelding;
    }

    public void setEtternavnFeilmelding(String etternavnFeilmelding) {
        this.etternavnFeilmelding = etternavnFeilmelding;
    }

    public String getPassordFeilmelding() {
        return passordFeilmelding;
    }

    public void setPassordFeilmelding(String passordFeilmelding) {
        this.passordFeilmelding = passordFeilmelding;
    }

    public String getPassordRepetertFeilmelding() {
        return passordRepetertFeilmelding;
    }

    public void setPassordRepetertFeilmelding(String passordRepetertFeilmelding) {
        this.passordRepetertFeilmelding = passordRepetertFeilmelding;
    }

    /**
     * this method renders a string harmless for html disruption.
     * @param s the string we want to render harmless
     * @return returns a harmless string where the characters referenced are replaced with harmless characters.
     */
    private String escapeHtml(String s) {
        String resultat = s;
        if(resultat== null)
            return resultat;
        resultat = resultat.replaceAll("<", "&lt;");
        resultat = resultat.replaceAll(">", "&gt;");
        resultat = resultat.replaceAll("\"", "&quot;");
        return resultat;
    }

    /**
     * toString for the object variables
     * @return a structured string with error messages.
     */
    @Override
    public String toString() {
        return "Paameldingsskjema{" +
                "brukernavn='" + brukernavn + '\'' +
                ", fornavn='" + fornavn + '\'' +
                ", etternavn='" + etternavn + '\'' +
                ", epost='" + epost + '\'' +
                ", passord='" + passord + '\'' +
                ", passordRepetert='" + passordRepetert + '\'' +
                ", brukernavnFeilmelding='" + brukernavnFeilmelding + '\'' +
                ", epostFeilmelding='" + epostFeilmelding + '\'' +
                ", fornavnFeilmelding='" + fornavnFeilmelding + '\'' +
                ", etternavnFeilmelding='" + etternavnFeilmelding + '\'' +
                ", passordFeilmelding='" + passordFeilmelding + '\'' +
                ", passordRepetertFeilmelding='" + passordRepetertFeilmelding + '\'' +
                '}';
    }
}
