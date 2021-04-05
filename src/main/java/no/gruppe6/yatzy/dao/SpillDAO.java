package no.gruppe6.yatzy.dao;

import no.gruppe6.yatzy.entities.Spill;

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

    public List<Spill> hentTilgjengeligeSpill(Spill s) {
        return em.createQuery("SELECT s FROM Spill s WHERE s.spillstatus = 'tilgjengelig'", Spill.class).getResultList();
    }

    public List<Spill> hentAktiveSpill(Spill s) {
        return em.createQuery("SELECT s FROM Spill s WHERE s.spillstatus = 'aktiv'", Spill.class).getResultList();
    }

    public Spill hentSpill(String brukernavn) {
        return em.find(Spill.class, brukernavn);

    }
    public void lagreSpill (Spill s) { em.persist(s);}
}
