package no.gruppe6.yatzy.entities;

import javax.persistence.*;


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

    @ManyToOne
    @JoinColumn(name = "tur", referencedColumnName = "brukernavn")
    private Bruker brukerTur;

    /**
     * Default constructor for the class Spill
     */
    public Spill() {
    }

    /**
     * Constructor for the class Spill where each dice in the cup is given the value zero
     * @param bruker is the user who is playing a yatzy game
     * @param navn is the name of the game
     */
    public Spill(Bruker bruker, String navn) {
        this.brukerTur = bruker;
        this.navn = navn;
        this.kopp = new Kopp(0,0,0,0,0);
    }

    /**
     * Getters and setters for the object variables
     */
    public Kopp getKopp() {
        return kopp;
    }

    public void setKopp(Kopp kopp) {
        this.kopp = kopp;
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