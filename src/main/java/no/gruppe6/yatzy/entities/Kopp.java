package no.gruppe6.yatzy.entities;

import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Embeddable
public class Kopp {
	
	public int terning1;
	public int terning2;
	public int terning3;
	public int terning4;
	public int terning5;

	public Kopp(){
		this.terning1 = 0;
		this.terning2 = 0;
		this.terning3 = 0;
		this.terning4 = 0;
		this.terning5 = 0;

	}

	public Kopp(int terning1, int terning2, int terning3, int terning4, int terning5) {
		this.terning1 = terning1;
		this.terning2 = terning2;
		this.terning3 = terning3;
		this.terning4 = terning4;
		this.terning5 = terning5;
	}

	public void rullKopp(boolean[] tester){

		Random rand = new Random();

		int[] tab = hentTerninger();

		for (int i = 0; i< tester.length; i++){
			if (!tester[i]) tab[i] = rand.nextInt(7-1) + 1;

		}

		this.terning1 = tab[0];
		this.terning2 = tab[1];
		this.terning3 = tab[2];
		this.terning4 = tab[3];
		this.terning5 = tab[4];

	}

	public void resetKopp(){
		this.terning1 = 0;
		this.terning2 = 0;
		this.terning3 = 0;
		this.terning4 = 0;
		this.terning5 = 0;
	}


	public int[] hentTerninger(){
		return new int[]{terning1, terning2, terning3, terning4, terning5};
	}

	public int getTerning1() {
		return terning1;
	}

	public void setTerning1(int terning1) {
		this.terning1 = terning1;
	}

	public int getTerning2() {
		return terning2;
	}

	public void setTerning2(int terning2) {
		this.terning2 = terning2;
	}

	public int getTerning3() {
		return terning3;
	}

	public void setTerning3(int terning3) {
		this.terning3 = terning3;
	}

	public int getTerning4() {
		return terning4;
	}

	public void setTerning4(int terning4) {
		this.terning4 = terning4;
	}

	public int getTerning5() {
		return terning5;
	}

	public void setTerning5(int terning5) {
		this.terning5 = terning5;
	}
}
