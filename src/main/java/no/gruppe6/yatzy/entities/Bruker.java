package no.gruppe6.yatzy.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "demoYatzy")
public class Bruker {

    @Id
    private String brukernavn;
    private String mobil;




    public Bruker(String brukernavn, String mobil){
        this.brukernavn = brukernavn;
        this.mobil = mobil;
    }
    public Bruker(){}


    public String getBrukernavn(){
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn){
        this.brukernavn = brukernavn;
    }

    @Override
    public boolean equals(Object o){
        Bruker b2 = (Bruker)o;
        String brukernavn2 = b2.getBrukernavn();
        return this.brukernavn.equals(brukernavn2);
    }


}
