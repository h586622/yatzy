package no.gruppe6.yatzy.entities;

import javax.persistence.*;
import java.util.List;

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

    public Bruker(String brukernavn, String fornavn, String etternavn, String epost, Passord passord) {
        this.brukernavn = brukernavn;
        this.epost = epost;
        this.passord = passord;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public Bruker(Paameldingsskjema skjema){
        this.brukernavn = skjema.getBrukernavn();
        this.fornavn = skjema.getFornavn();
        this.etternavn = skjema.getEtternavn();
        this.epost = skjema.getEpost();
        this.passord = Passord.lagPassord(skjema.getPassord());
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

    @Override
    public boolean equals(Object obj) {
        Bruker b2 = (Bruker) obj;
        return this.getBrukernavn().equals(b2.getBrukernavn());
    }
}
