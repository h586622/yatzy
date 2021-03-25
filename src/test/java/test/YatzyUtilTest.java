package test;

import no.gruppe6.yatzy.entities.Kopp;
import no.gruppe6.yatzy.util.YatzyUtil;
import org.junit.Test;
import static org.junit.Assert.*;

public class YatzyUtilTest {

    @Test
    public void parTest() {
        Kopp k = new MockKopp(1,2,3,5,5);
        int res = YatzyUtil.sjekkKast(k, 7);
        assertEquals(10, res);
        k = new MockKopp(1,2,4,4,5);
        res = YatzyUtil.sjekkKast(k, 7);
        assertEquals(8, res);
        k = new MockKopp(1,1,4,4,5);
        res = YatzyUtil.sjekkKast(k, 7);
        assertEquals(8, res);
        k = new MockKopp(1,1,4,2,5);
        res = YatzyUtil.sjekkKast(k, 7);
        assertEquals(2, res);
    }

    @Test
    public void enereTilSeksereTest() {

        Kopp k = new MockKopp(1,1,4,2,5);
        int res = YatzyUtil.sjekkKast(k, 1);
        assertEquals(2, res);
        k = new MockKopp(1,2,4,2,5);
        res = YatzyUtil.sjekkKast(k, 2);
        assertEquals(4, res);
        k = new MockKopp(3,2,3,2,3);
        res = YatzyUtil.sjekkKast(k, 3);
        assertEquals(9, res);
        k = new MockKopp(3,4,3,2,3);
        res = YatzyUtil.sjekkKast(k, 4);
        assertEquals(4, res);
        k = new MockKopp(5,2,5,5,5);
        res = YatzyUtil.sjekkKast(k, 5);
        assertEquals(20, res);
        k = new MockKopp(3,2,6,2,6);
        res = YatzyUtil.sjekkKast(k, 6);
        assertEquals(12, res);

    }

    @Test
    public void toParTest() {
        Kopp k = new MockKopp(1,1,4,4,5);
        int res = YatzyUtil.sjekkKast(k, 8);
        assertEquals(10, res);
        k = new MockKopp(1,1,4,4,4);
        res = YatzyUtil.sjekkKast(k, 8);
        assertEquals(10, res);
        k = new MockKopp(1,6,4,4,6);
        res = YatzyUtil.sjekkKast(k, 8);
        assertEquals(20, res);
    }

    @Test
    public void treLikeTest() {
        Kopp k = new MockKopp(4,1,4,4,5);
        int res = YatzyUtil.sjekkKast(k, 9);
        assertEquals(12, res);
        k = new MockKopp(1,1,4,4,4);
        res = YatzyUtil.sjekkKast(k, 9);
        assertEquals(12, res);
        k = new MockKopp(1,1,4,2,4);
        res = YatzyUtil.sjekkKast(k, 9);
        assertEquals(0, res);
    }

    @Test
    public void fireLikeTest() {
        Kopp k = new MockKopp(4,1,4,4,4);
        int res = YatzyUtil.sjekkKast(k, 10);
        assertEquals(16, res);
        k = new MockKopp(1,1,4,2,4);
        res = YatzyUtil.sjekkKast(k, 10);
        assertEquals(0, res);

    }

    @Test
    public void litenStraightTest() {
        Kopp k = new MockKopp(4,1,4,4,4);
        int res = YatzyUtil.sjekkKast(k, 11);
        assertEquals(0, res);
        k = new MockKopp(1,2,3,4,5);
        res = YatzyUtil.sjekkKast(k, 11);
        assertEquals(15,res);
        k = new MockKopp(1,5,3,4,2);
        res = YatzyUtil.sjekkKast(k, 11);
        assertEquals(15,res);
        k = new MockKopp(1,2,2,5,5);
        res = YatzyUtil.sjekkKast(k, 11);
        assertEquals(0,res);
    }

    @Test
    public void storStraightTest() {
        Kopp k = new MockKopp(4,1,4,4,4);
        int res = YatzyUtil.sjekkKast(k, 12);
        assertEquals(0, res);
        k = new MockKopp(6,2,3,4,5);
        res = YatzyUtil.sjekkKast(k, 12);
        assertEquals(20,res);
        k = new MockKopp(6,5,3,4,2);
        res = YatzyUtil.sjekkKast(k, 12);
        assertEquals(20,res);
    }

    @Test
    public void husTest() {
        Kopp k = new MockKopp(4,1,4,4,4);
        int res = YatzyUtil.sjekkKast(k, 13);
        assertEquals(0, res);
        k = new MockKopp(6,5,6,5,6);
        res = YatzyUtil.sjekkKast(k, 13);
        assertEquals(28,res);
        k = new MockKopp(5,1,1,5,1);
        res = YatzyUtil.sjekkKast(k, 13);
        assertEquals(13,res);

    }

    @Test
    public void sjanseTest() {
        Kopp k = new MockKopp(4,1,4,4,4);
        int res = YatzyUtil.sjekkKast(k, 14);
        assertEquals(17, res);
        k = new MockKopp(5,1,1,5,1);
        res = YatzyUtil.sjekkKast(k, 14);
        assertEquals(13,res);
        k = new MockKopp(2,1,3,5,1);
        res = YatzyUtil.sjekkKast(k, 14);
        assertEquals(12,res);
    }

    @Test
    public void yatzyTest() {
        Kopp k = new MockKopp(4,1,4,4,4);
        int res = YatzyUtil.sjekkKast(k, 15);
        assertEquals(0, res);
        k = new MockKopp(2,2,2,2,2);
        res = YatzyUtil.sjekkKast(k, 15);
        assertEquals(50,res);

    }
}