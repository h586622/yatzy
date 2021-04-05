package test;

import no.gruppe6.yatzy.dao.BrukerDAO;
import no.gruppe6.yatzy.entities.Bruker;
import no.gruppe6.yatzy.entities.Passord;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class BrukerDAOTest {

   // @Autowired
    private BrukerDAO bdao;

    @BeforeEach
    private void setup(){
        bdao = new BrukerDAO();
        Passord pass = Passord.lagPassord("123!Arne");
        Bruker testBruker = new Bruker("Testbruker", "Arne", "Hansen", "arne@hansen.no", pass);
    }
/*
    @Test
    public void testFinnBrukerMedBrukernavnEmFind(){





        EntityManager em = mock(EntityManager.class);
        when(em.find(Bruker.class,1L)).thenReturn(testBruker);

        BrukerDAO brukerDAO = new BrukerDAO();
        brukerDAO.setEntityManager(em);

        List<Bruker> testBrukerListe = new ArrayList<Bruker>();
        testBrukerListe.add(testBruker);
        List<Bruker> nyBrukerListe = brukerDAO.finnBrukerMedBrukernavn("Testbruker");
        assertEquals(testBrukerListe, nyBrukerListe);


    }
*/
    @Test
    @Transactional
    @Rollback(true)
    public void leggTilBrukerOgHent(){

        Passord pass = Passord.lagPassord("123!Arne");
        Bruker testBruker = new Bruker("Testbruker", "Arne", "Hansen", "arne@hansen.no", pass);

        bdao = new BrukerDAO();
        bdao.lagreBruker(testBruker);

        Bruker ny = bdao.finnBrukerMedBrukernavn("Testbruker");

        assertEquals(testBruker.getBrukernavn(), ny.getBrukernavn());
        assertEquals(testBruker.getFornavn(), ny.getFornavn());
        assertEquals(testBruker.getEtternavn(), ny.getEtternavn());
        assertEquals(testBruker.getEpost(), ny.getEpost());

    }



}
