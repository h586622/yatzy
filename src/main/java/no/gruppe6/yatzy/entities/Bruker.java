package no.gruppe6.yatzy.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "yatzydb")
public class Bruker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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

    public Bruker(String brukernavn, String epost, Passord passord) {
        this.brukernavn = brukernavn;
        this.epost = epost;
        this.passord = passord;
    }

    public Bruker() {

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


}
