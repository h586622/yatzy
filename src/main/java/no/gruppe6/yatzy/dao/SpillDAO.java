package no.gruppe6.yatzy.dao;

import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.entities.Spilldeltagelse;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class SpillDAO {

    @PersistenceContext(name = "yatzyPU")
    private EntityManager em;

    public List<Spill> hentAlleSpill() {
        return em.createQuery("SELECT s FROM Spill s", Spill.class).getResultList();

    }

    public List<Spill> hentTilgjengeligeSpill() {
        return em.createQuery("SELECT s FROM Spill s WHERE s.spillstatus = 'tilgjengelig'", Spill.class).getResultList();
    }

    public List<Spill> hentAktiveSpill() {
        return em.createQuery("SELECT s FROM Spill s WHERE s.spillstatus = 'aktiv'", Spill.class).getResultList();
    }

    public Spill hentSpill(int id) {
        return em.find(Spill.class, id);
    }

    public Spilldeltagelse hentSpillDeltagelse(int id){
        return em.find(Spilldeltagelse.class, id);
    }

    public void lagreSpillDeltagelse(Spilldeltagelse spilldeltagelse) {
        em.merge(spilldeltagelse);
    }

    public List<Spilldeltagelse> hentSpillDeltagelseListe(int spillId){
        return em.createQuery("select s from Spilldeltagelse s where s.spill = ?1")
                .setParameter(1, spillId).getResultList();
    }

    public void lagreSpill (Spill s) { em.persist(s);}
}
