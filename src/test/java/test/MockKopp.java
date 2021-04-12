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
        terning1 = en;
        t2 = new Terning(to);
        terning2 = to;
        t3 = new Terning(tre);
        terning3 = tre;
        t4 = new Terning(fire);
        terning4 = fire;
        t5 = new Terning(fem);
        terning5 = fem;
    }

}