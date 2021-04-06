package no.gruppe6.yatzy.dao;

import no.gruppe6.yatzy.entities.Bruker;
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
        return em.createQuery("SELECT s FROM Spill s WHERE s.spillstatus = 'ledig'", Spill.class).getResultList();
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

    public List hentSpillDeltagelseListe(Spill spill){
        return em.createQuery("select s from Spilldeltagelse s where s.spill = ?1")
                .setParameter(1, spill).getResultList();
    }

    public List<Spilldeltagelse> hentSpillDeltagelserMedBrukerid(Bruker bruker){
        return em.createQuery("select s from Spilldeltagelse s where s.bruker = ?1")
                .setParameter(1, bruker).getResultList();
    }

    public Spilldeltagelse hentSpillDeltagelseBrukerSpill(Bruker bruker, Spill spill){
        return (Spilldeltagelse) em.createQuery("select s from Spilldeltagelse s where s.spill = ?1 AND s.bruker = ?2")
                .setParameter(1, spill).setParameter(2, bruker).getSingleResult();
    }

    public Spill hentSpillMedNavn(String navn){
        return (Spill) em.createQuery("SELECT s from Spill s where s.navn = ?1")
                .setParameter(1,navn).getSingleResult();
    }

    public void lagreNySpilldeltagelse(Spilldeltagelse spilldeltagelse){
        em.persist(spilldeltagelse);
    }

    public void lagreSpill (Spill s) { em.merge(s);}

    public void lagreNyttSpill(Spill spill){
        em.persist(spill);
    }
}
