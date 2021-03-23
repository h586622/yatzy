package no.gruppe6.yatzy.entities;

public class Kast {

    private int verdi;
    private Bruker bruker;

    public Kast(Bruker bruker, int verdi){
        this.verdi = verdi;
        this.bruker = bruker;
    }

    public Bruker getBruker(){
        return bruker;
    }

    public void setBruker(Bruker bruker){
        this.bruker = bruker;
    }

    public int getVerdi(){
        return verdi;
    }

    public void setVerdi(int verdi){
        this.verdi = verdi;
    }
}
