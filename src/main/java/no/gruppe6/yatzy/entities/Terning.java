package no.gruppe6.yatzy.entities;

/**
 * This class handles the logic behind the dices in a yatzy game
 */
public class Terning {
	
	private int verdi;
	private String navn;

	/**
	 * Default constructor for the class Terning where the dice gets the value zero
	 */
	public Terning() {
		verdi = 0;
	}

	/**
	 * Constructor for the class Terning where the dice gets the value zero
	 * @param navn is the name of the specific dice
	 */
	public Terning(String navn) {
		this.navn = navn;
		verdi = 0;
	}

	/**
	 * Constructor for the class Terning
	 * @param navn is the name of the specific dice
	 * @param verdi is the value the dice is being given
	 */
	public Terning(String navn, int verdi) {
		this.navn = navn;
		this.verdi = verdi;
	}

	/**
	 * Constructor of the class Terning where the dice gets the value of a given number
	 * @param tall is the given number which decides the value of the dice
	 */
	public Terning(int tall) {
		this.verdi = tall;
	}

	/**
	 * This method rolls the dice and gives it a random value between one and six
	 * @return the random value being generated in the method
	 */
	public int rull() {
		verdi = (int) (Math.random() * 6 + 1);
		return verdi;
	}

	/**
	 * Getters and setters for the object variables
	 */
	public int getVerdi() {
		return verdi;
	}
	public void setVerdi(int verdi) {
		this.verdi = verdi;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}

	/**
	 * toString method
	 * @return the name and value of a dice as a String
	 */
	@Override
	public String toString() {
		return "Terning{" +
				"navn=" + navn +
				", verdi='" + verdi + '\'' +
				'}';
	}
}
