package no.gruppe6.yatzy.entities;

import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class implements the logic for the cup of dices
 */
@Embeddable
public class Kopp {
	
	public int terning1;
	public int terning2;
	public int terning3;
	public int terning4;
	public int terning5;

	/**
	 * Default constructor for a cup of dices where all the dices gat a value of 0.
	 */
	public Kopp(){
		this.terning1 = 0;
		this.terning2 = 0;
		this.terning3 = 0;
		this.terning4 = 0;
		this.terning5 = 0;

	}

	/**
	 * Constructor for a cup of dices.
	 * @param terning1 Dice 1
	 * @param terning2 Dice 2
	 * @param terning3 Dice 3
	 * @param terning4 Dice 4
	 * @param terning5 Dice 5
	 */
	public Kopp(int terning1, int terning2, int terning3, int terning4, int terning5) {
		this.terning1 = terning1;
		this.terning2 = terning2;
		this.terning3 = terning3;
		this.terning4 = terning4;
		this.terning5 = terning5;
	}

	/**
	 *This method gives the dices a random number between 1-6
	 * @param tester test for empty value, if the value is nonexistent its
	 *                  assigned a random number between 1-6
	 */
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

	/**
	 * This method give all the dices in a cup the value of 0.
	 */
	public void resetKopp(){
		this.terning1 = 0;
		this.terning2 = 0;
		this.terning3 = 0;
		this.terning4 = 0;
		this.terning5 = 0;
	}

	/**
	 * Getter for table of integers
	 * @return returns a table of dices as integers
	 */
	public int[] hentTerninger(){
		return new int[]{terning1, terning2, terning3, terning4, terning5};
	}

	/**
	 * Getters and setters for the object variables
	 */
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
