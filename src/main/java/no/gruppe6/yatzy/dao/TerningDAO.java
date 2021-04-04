package no.gruppe6.yatzy.dao;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Kast;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TerningDAO {

    @PersistenceContext(name = "yatzyPU")
    private EntityManager em;

    /**
     * This method saves the thrown from a user
     * @param k refers to the current thrown from a user
     */
    public void lagreKast(Kast k){ em.persist(k); }

        public void registrerSum (List<Integer> liste) {
            int resultat = 0;

            for (Integer integer : liste) {
                resultat += integer;
            }
            em.persist(resultat);
        }

        public void registrerDelsum (List<Kast> liste) {
        // er det behov for dette?
        }
}
