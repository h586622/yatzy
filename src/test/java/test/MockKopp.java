package test;


import no.gruppe6.yatzy.entities.Kopp;
import no.gruppe6.yatzy.entities.Terning;

public class MockKopp extends Kopp {

    private Terning t1;
    private Terning t2;
    private Terning t3;
    private Terning t4;
    private Terning t5;

    public MockKopp(int en, int to, int tre, int fire, int fem) {

        t1 = new Terning(en);
        terninger[0] = t1;
        t2 = new Terning(to);
        terninger[1] = t2;
        t3 = new Terning(tre);
        terninger[2] = t3;
        t4 = new Terning(fire);
        terninger[3] = t4;
        t5 = new Terning(fem);
        terninger[4] = t5;


    }

}