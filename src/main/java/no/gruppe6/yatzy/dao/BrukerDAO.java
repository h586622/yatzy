package no.gruppe6.yatzy.dao;

import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Kast;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BrukerDAO {

    @PersistenceContext(name = "yatzyPU")
    private EntityManager em;

    public Bruker finnBrukerMedBrukernavn(String brukernavn){
       return em.find(Bruker.class, brukernavn);
    }

    public void lagreBruker(Bruker b){
        em.persist(b);
    }
    }
