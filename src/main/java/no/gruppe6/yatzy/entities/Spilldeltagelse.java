package no.gruppe6.yatzy.entities;

import javax.persistence.*;

@Entity
@Table(schema = "yatzydb")
public class Spilldeltagelse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int enere;
    private int toere;
    private int treere;
    private int firere;
    private int femere;
    private int seksere;
    private int par;
    private int topar;
    private int trelike;
    private int firelike;
    private int litenstraight;
    private int storstraight;
    private int hus;
    private int sjanse;
    private int yatzy;

    @ManyToOne
    @JoinColumn(name="brukernavn", referencedColumnName = "brukernavn")
    private Bruker bruker;

    @ManyToOne
    @JoinColumn(name="spillid", referencedColumnName = "id")
    private Spill spill;

    public Spilldeltagelse(){}

    public int getEnere() {
        return enere;
    }

    public void setEnere(int enere) {
        this.enere = enere;
    }

    public int getToere() {
        return toere;
    }

    public void setToere(int toere) {
        this.toere = toere;
    }

    public int getTreere() {
        return treere;
    }

    public void setTreere(int treere) {
        this.treere = treere;
    }

    public int getFirere() {
        return firere;
    }

    public void setFirere(int firere) {
        this.firere = firere;
    }

    public int getFemere() {
        return femere;
    }

    public void setFemere(int femere) {
        this.femere = femere;
    }

    public int getSeksere() {
        return seksere;
    }

    public void setSeksere(int seksere) {
        this.seksere = seksere;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public int getTopar() {
        return topar;
    }

    public void setTopar(int topar) {
        this.topar = topar;
    }

    public int getTrelike() {
        return trelike;
    }

    public void setTrelike(int trelike) {
        this.trelike = trelike;
    }

    public int getFirelike() {
        return firelike;
    }

    public void setFirelike(int firelike) {
        this.firelike = firelike;
    }

    public int getLitenstraight() {
        return litenstraight;
    }

    public void setLitenstraight(int litenstraight) {
        this.litenstraight = litenstraight;
    }

    public int getStorstraight() {
        return storstraight;
    }

    public void setStorstraight(int storstraight) {
        this.storstraight = storstraight;
    }

    public int getHus() {
        return hus;
    }

    public void setHus(int hus) {
        this.hus = hus;
    }

    public int getSjanse() {
        return sjanse;
    }

    public void setSjanse(int sjanse) {
        this.sjanse = sjanse;
    }

    public int getYatzy() {
        return yatzy;
    }

    public void setYatzy(int yatzy) {
        this.yatzy = yatzy;
    }

    public Bruker getBruker() {
        return bruker;
    }

    public void setBruker(Bruker bruker) {
        this.bruker = bruker;
    }

    public Spill getSpill() {
        return spill;
    }

    public void setSpill(Spill spill) {
        this.spill = spill;
    }
}
