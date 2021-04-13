package no.gruppe6.yatzy.entities;

import javax.persistence.*;
import java.util.List;

/**
 * This class implements the logic for the users
 */
@Entity
@Table(schema = "yatzydb")
public class Bruker {

    @Id
    private String brukernavn;
    private String fornavn;
    private String etternavn;
    @Embedded
    private Passord passord;
    private String epost;

    @OneToMany(mappedBy = "bruker")
    private List<Spilldeltagelse> spilldeltagelseList;

    @OneToMany(mappedBy = "brukerTur")
    private List<Spill> spillTur;

    /**
     * Constructor
     * @param brukernavn username
     * @param fornavn   firstname
     * @param etternavn lastname
     * @param epost Email
     * @param passord Password
     */
    public Bruker(String brukernavn, String fornavn, String etternavn, String epost, Passord passord) {
        this.brukernavn = brukernavn;
        this.epost = epost;
        this.passord = passord;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    /**
     * Constructor based on a form
     * @param skjema refers to a registration form containing
     *               username, firstname, lastname, password, password repeat, email
     */
    public Bruker(Paameldingsskjema skjema){
        this.brukernavn = skjema.getBrukernavn();
        this.fornavn = skjema.getFornavn();
        this.etternavn = skjema.getEtternavn();
        this.epost = skjema.getEpost();
        this.passord = Passord.lagPassord(skjema.getPassord());
    }

    /**
     * default constructor
     */
    public Bruker() {

    }

    /**
     * Getters and setters for the object variables
     *
     */
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

    public List<Spilldeltagelse> getSpilldeltagelseList() {
        return spilldeltagelseList;
    }

    public void setSpilldeltagelseList(List<Spilldeltagelse> spilldeltagelseList) {
        this.spilldeltagelseList = spilldeltagelseList;
    }

    public List<Spill> getSpillTur() {
        return spillTur;
    }

    public void setSpillTur(List<Spill> spillTur) {
        this.spillTur = spillTur;
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

    /**
     * This method checks if a user already exists
     * @param obj refers to a user
     * @return returns true/false depending of the existence of a user.
     */
    @Override
    public boolean equals(Object obj) {
        Bruker b2 = (Bruker) obj;
        return this.getBrukernavn().equals(b2.getBrukernavn());
    }
}
