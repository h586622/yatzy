package no.gruppe6.yatzy.entities;

import org.eclipse.persistence.annotations.CacheCoordinationType;

import javax.persistence.*;
import java.time.LocalTime;

/**
 * This class handles the implementation of the logic for a user who is playing yatzy
 */
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
    private int bonus;
    private int totalsum;
    private int sumbonus;
    private int runde;
    private int kast;
    private int antallpurr;
    private LocalTime purren;
    private LocalTime purrto;
    private LocalTime rundestart;

    @ManyToOne
    @JoinColumn(name = "brukernavn", referencedColumnName = "brukernavn")
    private Bruker bruker;

    @ManyToOne
    @JoinColumn(name = "spillid", referencedColumnName = "id")
    private Spill spill;


    /**
     * Default constructor for the class Spilldeltagelse
     */
    public Spilldeltagelse() {
    }

    /**
     * Constructor for the class Spilldeltagelse where the round is given the value one and the
     * thrown is given the value zero, meaning no dices has been rolled yet
     * @param bruker is the current user who is participating in the current game
     * @param spill is the current game
     */
    public Spilldeltagelse(Bruker bruker, Spill spill){
        this.bruker = bruker;
        this.spill = spill;
        this.runde = 1;
        this.kast = 3;
        this.antallpurr = 0;
    }

    public int getAntallpurr() {
        return antallpurr;
    }

    public LocalTime getPurren(){
        return this.purren;
    }

    public LocalTime getPurrto(){
        return this.purrto;
    }

    public LocalTime getRundestart(){
        return this.rundestart;
    }

    public void setPurren(LocalTime lt){
        this.purren = lt;
    }

    public void setPurrto(LocalTime lt){
        this.purrto = lt;
    }

    public void setRundestart(LocalTime lt){
        this.rundestart = lt;
    }


    public void setAntallpurr(int antallpurr) {
        this.antallpurr = antallpurr;
    }

    /**
     * Getters and setters for the object variables
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(int totalsum) {
        this.totalsum = totalsum;
    }

    public int getSumbonus() {
        return sumbonus;
    }

    public void setSumbonus(int sumbonus) {
        this.sumbonus = sumbonus;
    }

    public int getRunde() {
        return runde;
    }

    public void setRunde(int runde) {
        this.runde = runde;
    }

    public int getKast() {
        return kast;
    }

    public void setKast(int kast) {
        this.kast = kast;
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

    /**
     * This method checks if an object as Spilldeltagelse equals another object of Spilldeltagelse
     * @param obj is the variable we want to compare
     * @return true or false
     */
    @Override
    public boolean equals(Object obj){
        Spilldeltagelse spilldeltagelse = (Spilldeltagelse) obj;
        return this.getId() == spilldeltagelse.getId();
    }
}