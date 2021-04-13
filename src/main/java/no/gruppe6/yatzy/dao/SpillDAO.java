package no.gruppe6.yatzy.dao;

import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Spill;
import no.gruppe6.yatzy.entities.Spilldeltagelse;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * This DAO access the database for the overall games and it's players
 */
@Stateless
public class SpillDAO {

    @PersistenceContext(name = "yatzyPU")
    private EntityManager em;

    /**
     * This method retrieves all yatzy games that exsists
     * @return all yatzy games as a list
     */
    public List<Spill> hentAlleSpill() {
        return em.createQuery("SELECT s FROM Spill s", Spill.class).getResultList();

    }

    /**
     * This method retrieves all yatzy games that are available to be played, meaning the game hasn't
     * been started yet and there are more spots left
     * @return all available games as a list
     */
    public List<Spill> hentTilgjengeligeSpill() {
        return em.createQuery("SELECT s FROM Spill s WHERE s.spillstatus = 'ledig'", Spill.class).getResultList();
    }

    /**
     * This method retrieves all yatzy games that are currently active, meaning the game has started
     * @return all active games as a list
     */
    public List<Spill> hentAktiveSpill() {
        return em.createQuery("SELECT s FROM Spill s WHERE s.spillstatus = 'aktiv'", Spill.class).getResultList();
    }

    /**
     * This method fetches a specific game according to the id each yatzy game consists of
     * @param id is a generated id each game will be assigned, represented by integer
     * @return the game that matches the id
     */
    public Spill hentSpill(int id) {
        return em.find(Spill.class, id);
    }

    /**
     * This method retrieves the game participation to a user
     * @param id is a generated id each game will be assigned, represented by integer
     * @return the user and the current game the user is or have been involved with
     */
    public Spilldeltagelse hentSpillDeltagelse(int id){
        return em.find(Spilldeltagelse.class, id);
    }

    /**
     * This method saves the game participation to a user
     * @param spilldeltagelse is the information of the user and which game the user is currently
     *                        involved with (the name of the game)
     */
    public void lagreSpillDeltagelse(Spilldeltagelse spilldeltagelse) {
        em.merge(spilldeltagelse);
    }

    /**
     * This method fetches the game participation to a user as a list
     * @param spill is the yatzy game which contains the information of the user as well
     *              as the name of the game
     * @return the user and the current games the user is or have been involved with as a list
     */
    public List<Spilldeltagelse> hentSpillDeltagelseListe(Spill spill){
        return em.createQuery("select s from Spilldeltagelse s where s.spill = ?1")
                .setParameter(1, spill).getResultList();
    }

    /**
     * This method retrieves the game participation to a user as a list, based on the id of the user, which
     * in this case is the username
     * @param bruker is the current user we want to fetch game information about
     * @return the user and the current games the user is or have been involved with as a list
     */
    public List<Spilldeltagelse> hentSpillDeltagelserMedBrukerid(Bruker bruker){
        return em.createQuery("select s from Spilldeltagelse s where s.bruker = ?1")
                .setParameter(1, bruker).getResultList();
    }

    /**
     * This method retrieves the game participation to a user based on a user and a game
     * @param bruker is the current user we want to fetch game information about
     * @param spill is the current game we want to receive information about
     * @return the user and the current game the user is or have been involved with
     */
    public Spilldeltagelse hentSpillDeltagelseBrukerSpill(Bruker bruker, Spill spill){
        return (Spilldeltagelse) em.createQuery("select s from Spilldeltagelse s where s.spill = ?1 AND s.bruker = ?2")
                .setParameter(1, spill).setParameter(2, bruker).getSingleResult();
    }

    /**
     * This method fetches information about a yatzy game based on the name of the game
     * @param navn is the name of the game represented by a String
     * @return the game which matches the name given as a parameter
     */
    public Spill hentSpillMedNavn(String navn){
        return (Spill) em.createQuery("SELECT s from Spill s where s.navn = ?1")
                .setParameter(1,navn).getSingleResult();
    }

    /**
     * This method saves a new game participation to a user
     * @param spilldeltagelse is the information of the user and which game the user is currently
     *      *                 involved with (the name of the game)
     */
    public void lagreNySpilldeltagelse(Spilldeltagelse spilldeltagelse){
        em.persist(spilldeltagelse);
    }

    /**
     * This method saves a yatzy game
     * @param s is the current game we want to save
     */
    public void lagreSpill (Spill s) { em.merge(s);}

    /**
     * This method saves a new game
     * @param spill is the current game we want to save
     */
    public void lagreNyttSpill(Spill spill){
        em.persist(spill);
    }
    /**
     * Finds the games the user is set to active player.
     * @param bruker
     * @return List of all the games
     */
    public List hentSpillTurMedBrukerId(Bruker bruker) {
        return em.createQuery("select s from Spill s where s.brukerTur = ?1")
                .setParameter(1, bruker).getResultList();
    }

    /**
     * Removes a users game participation
     * @param sp Spilldeltagelse object to be removed
     */
    public void fjernSpillDeltagelse(Spilldeltagelse sp) {
        if (sp != null) {
            em.remove(em.merge(sp));
        }
    }
}
