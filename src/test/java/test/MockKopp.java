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
        Terning1 = en;
        t2 = new Terning(to);
        Terning2 = to;
        t3 = new Terning(tre);
        Terning3 = tre;
        t4 = new Terning(fire);
        Terning4 = fire;
        t5 = new Terning(fem);
        Terning5 = fem;
    }

}