package no.gruppe6.yatzy.entities;

import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Embeddable
public class Kopp {
	
	public int Terning1;
	public int Terning2;
	public int Terning3;
	public int Terning4;
	public int Terning5;

	public Kopp(){}

	public Kopp(int terning1, int terning2, int terning3, int terning4, int terning5) {
		this.Terning1 = terning1;
		this.Terning2 = terning2;
		this.Terning3 = terning3;
		this.Terning4 = terning4;
		this.Terning5 = terning5;
	}

	public int[] rullKopp(boolean[] tester){
		Random rand = new Random();

		int[] tab = hentTerninger();

		for (int i = 0; i< tester.length; i++){
			if (tester[i] == true) tab[i] = rand.nextInt(6);
		}

		Terning1 = tab[0];
		Terning2 = tab[1];
		Terning3 = tab[2];
		Terning4 = tab[3];
		Terning5 = tab[4];

		return tab;
	}


	public int[] hentTerninger(){
		return new int[]{Terning1, Terning2, Terning3, Terning4, Terning5};
	}

	public int getTerning1() {
		return Terning1;
	}

	public void setTerning1(int terning1) {
		Terning1 = terning1;
	}

	public int getTerning2() {
		return Terning2;
	}

	public void setTerning2(int terning2) {
		Terning2 = terning2;
	}

	public int getTerning3() {
		return Terning3;
	}

	public void setTerning3(int terning3) {
		Terning3 = terning3;
	}

	public int getTerning4() {
		return Terning4;
	}

	public void setTerning4(int terning4) {
		Terning4 = terning4;
	}

	public int getTerning5() {
		return Terning5;
	}

	public void setTerning5(int terning5) {
		Terning5 = terning5;
	}
}
