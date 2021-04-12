package test;

import no.gruppe6.yatzy.dao.BrukerDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Passord;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class BrukerDAOTest {

    //@Autowired
    @EJB
    private BrukerDAO bdao;



    @BeforeEach
    public void setUp(){
        EntityManager em = mock(EntityManager.class);
        bdao = new BrukerDAO();
        bdao.setEntityManager(em);
        Passord pass = Passord.lagPassord("123!Arne");
        Bruker testBruker = new Bruker("Testbruker", "Arne", "Hansen", "arne@hansen.no", pass);
    }

    @Test
    public void testFinnBrukerMedBrukernavnEmFind(){

        Passord pass = Passord.lagPassord("123!Arne");
        Bruker testBruker = new Bruker("Testbruker", "Arne", "Hansen", "arne@hansen.no", pass);

        EntityManager em = mock(EntityManager.class);
        when(em.find(Bruker.class,"Testbruker")).thenReturn(testBruker);
        bdao = new BrukerDAO();
        bdao.setEntityManager(em);

        Bruker nyBruker = bdao.finnBrukerMedBrukernavn("Testbruker");
        assertEquals("Testbruker", nyBruker.getBrukernavn());
        assertEquals(testBruker.getBrukernavn(), nyBruker.getBrukernavn());
        assertEquals(testBruker.getFornavn(), nyBruker.getFornavn());
        assertEquals(testBruker.getEtternavn(), nyBruker.getEtternavn());
        assertEquals(testBruker.getEpost(), nyBruker.getEpost());


    }
/*
    @Test
    @Transactional
    @Rollback(true)
    public void leggTilBrukerOgHent(){

        Passord pass = Passord.lagPassord("123!Arne");
        Bruker testBruker = new Bruker("Testbruker", "Arne", "Hansen", "arne@hansen.no", pass);

        bdao = new BrukerDAO();
        EntityManager em = mock(EntityManager.class);
        bdao.setEntityManager(em);

        bdao.lagreBruker(testBruker);

        Bruker ny = bdao.finnBrukerMedBrukernavn("Testbruker");

        assertEquals(testBruker.getBrukernavn(), ny.getBrukernavn());
        assertEquals(testBruker.getFornavn(), ny.getFornavn());
        assertEquals(testBruker.getEtternavn(), ny.getEtternavn());
        assertEquals(testBruker.getEpost(), ny.getEpost());

    }

    @Test
    public void testFinnBruker(){

        BrukerDAO bdao2;
        bdao2 = new BrukerDAO();
        EntityManagerFactory em2 = Persistence.createEntityManagerFactory("test");
        EntityManager em3 = em2.createEntityManager();
        bdao2.setEntityManager(em3);
        Bruker ny = bdao2.finnBrukerMedBrukernavn("Test1");
        assertNotNull(ny);

    }
*/


}
