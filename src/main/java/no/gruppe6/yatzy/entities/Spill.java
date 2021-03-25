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
    private int terning1;
    private int terning2;
    private int terning3;
    private int terning4;
    private int terning5;

    @OneToMany(mappedBy = "spill")
    private List<Spilldeltagelse> spilldeltagelseList;

    @ManyToOne
    @JoinColumn(name = "tur", referencedColumnName = "id")
    private Bruker brukerTur;


    public Spill(){}

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

    public int getTerning1() {
        return terning1;
    }

    public void setTerning1(int terning1) {
        this.terning1 = terning1;
    }

    public int getTerning2() {
        return terning2;
    }

    public void setTerning2(int terning2) {
        this.terning2 = terning2;
    }

    public int getTerning3() {
        return terning3;
    }

    public void setTerning3(int terning3) {
        this.terning3 = terning3;
    }

    public int getTerning4() {
        return terning4;
    }

    public void setTerning4(int terning4) {
        this.terning4 = terning4;
    }

    public int getTerning5() {
        return terning5;
    }

    public void setTerning5(int terning5) {
        this.terning5 = terning5;
    }
}
