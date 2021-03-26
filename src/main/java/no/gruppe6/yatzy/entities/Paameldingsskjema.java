package no.gruppe6.yatzy.entities;

import no.gruppe6.yatzy.util.Validator;

import javax.servlet.http.HttpServletRequest;

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

    public Paameldingsskjema(HttpServletRequest request) {
        this.brukernavn = escapeHtml(request.getParameter("brukernavn"));
        this.fornavn = escapeHtml(request.getParameter("fornavn"));
        this.etternavn = escapeHtml(request.getParameter("etternavn"));
        this.passord = escapeHtml(request.getParameter("passord"));
        this.passordRepetert = escapeHtml(request.getParameter("passordRepetert"));
        this.epost = escapeHtml(request.getParameter("epost"));

    }

    public boolean allInputGyldig() {
        return Validator.isValidFirstName(fornavn) && Validator.isValidLastName(etternavn)
                && Validator.passordSjekk(passord) && Validator.isValidRepeatedPassword(passord,passordRepetert)
                && Validator.isValidUsername(brukernavn) && Validator.sjekkEpost(epost);
    }

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

    public void ikkeUniktBrukernavn() {
        brukernavn = "";
        brukernavnFeilmelding = "Brukernavnet eksisterer i databasen fra før.";
    }
    public void ikkeUnikEpost() {
        epost = "";
        epostFeilmelding = "Epost eksisterer i databasen fra før.";
    }

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

    private String escapeHtml(String s) {
        String resultat = s;
        if(resultat== null)
            return resultat;
        resultat = resultat.replaceAll("<", "&lt;");
        resultat = resultat.replaceAll(">", "&gt;");
        resultat = resultat.replaceAll("\"", "&quot;");
        return resultat;
    }


}
