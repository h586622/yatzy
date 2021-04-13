package no.gruppe6.yatzy.dao;

import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Kast;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
/**
 * This DAO access the database for the users and their information
 */

@Stateless
public class BrukerDAO {

    @PersistenceContext(name = "yatzyPU")
    private EntityManager em;

    /**
     * THis method finds a user with username
     * @param brukernavn refers to the username
     * @return returns the username if it exists.
     */
    public Bruker finnBrukerMedBrukernavn(String brukernavn){
       return em.find(Bruker.class, brukernavn);
    }

    /**
     * This method finds all throws from a specific user
     * @param bruker Referse to the user you want to find
     * @return returns all throws a user has made
     */
    public List<Kast> finnAlleKast (Bruker bruker){
        String brukernavn = bruker.getBrukernavn();
        return em.createQuery("SELECT s FROM Spill s WHERE s.navn = 'brukernavn'", Kast.class).getResultList(); }

    /**
     * This method saves a user
     * @param b the current user you want too save
     */
    public void lagreBruker(Bruker b){
        em.persist(b);
    }

    /**
     * This method deletes a user with its username.
     * @param brukernavn The username of the user.
     */
    public void slettBruker(String brukernavn) {
        Bruker bruker = em.find(Bruker.class, brukernavn);
        if (bruker != null) {
            em.remove(bruker);
        }
    }

    /**
     * Save the throw a user has made
     * @param k refers to the trow
     */
    public void lagreKast(Kast k){
        em.persist(k);
    }

    /**
     * This method makes a user from a specific email
     * @param epost refers to the email of a user
     * @return returns a list of a user with said email.
     */
    public List<Bruker> finnBrukerMedEpost(String epost){
        TypedQuery<Bruker> query = em.createQuery(
                "SELECT b FROM Bruker b WHERE b.epost= '" + epost + "'", Bruker.class);
        return query.getResultList();
    }

    /**
     * This method gets all users.
     * @return a list of all users.
     */
    public List<Bruker> hentAlleBrukere() {

            TypedQuery<Bruker> query = em.createQuery("SELECT b FROM Bruker b", Bruker.class);
            return query.getResultList();
    }
    /**
     * Sets the entity
     * @param em refers to the entity
     */
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}
