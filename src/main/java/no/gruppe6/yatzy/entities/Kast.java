package no.gruppe6.yatzy.entities;

public class Kast {

    private int verdi;
    private Bruker bruker;

    /**
     * Constructor
     * @param bruker user
     * @param verdi value of throw
     */
    public Kast(Bruker bruker, int verdi){
        this.verdi = verdi;
        this.bruker = bruker;
    }

    /**
     *Getters and setters for the object variables
     */
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
