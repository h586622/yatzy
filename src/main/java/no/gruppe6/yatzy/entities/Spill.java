package no.gruppe6.yatzy.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "yatzydb")
public class Spill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String navn;
    private String spillstatus;

    @Embedded
    private Kopp kopp;

    @OneToMany(mappedBy = "spill")
    private List<Spilldeltagelse> spilldeltagelseList;

    @ManyToOne
    @JoinColumn(name = "tur", referencedColumnName = "brukernavn")
    private Bruker brukerTur;


    public Spill() {
    }

    public Spill(Bruker bruker, String navn) {
        this.brukerTur = bruker;
        this.navn = navn;
        this.kopp = new Kopp();
    }

    public List<Spilldeltagelse> getSpilldeltagelseList() {
        return spilldeltagelseList;
    }

    public void setSpilldeltagelseList(List<Spilldeltagelse> spilldeltagelseList) {
        this.spilldeltagelseList = spilldeltagelseList;
    }

    public Bruker getBrukerTur() {
        return brukerTur;
    }

    public void setBrukerTur(Bruker brukerTur) {
        this.brukerTur = brukerTur;
    }

    public int getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getSpillstatus() {
        return spillstatus;
    }

    public void setSpillstatus(String spillstatus) {
        this.spillstatus = spillstatus;
    }
}