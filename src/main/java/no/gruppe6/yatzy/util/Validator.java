package no.gruppe6.yatzy.util;

public class Validator {

    private static final String GYLDIG_FORNAVN = "^[A-ZÆØÅ][-a-zA-ZæøåÆØÅ ]{1,19}$";
    private static final String GYLDIG_ETTERNAVN = "^[A-ZÆØÅ][-a-zA-ZæøåÆØÅ]{1,19}$";


    /**
     * Denne metoden tester om e-posten skrevet inn av bruker er gyldig i forhold til regex vi har bestemt, og gjør
     * i tillegg om alt av store bokstaver i e-posten til små bokstaver
     * @param epost
     * @return
     */
    public static boolean sjekkEpost(String epost) {
		
		String epostLower = epost.toLowerCase();
		String pattern ="^[a-zA-Z0-9_!#$%&*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		return epostLower.matches(pattern);
	}
         
  //  Passord må inneholde en stor bokstav, ett tall, ett tegn og må være minst 6 tegn
      public static boolean passordSjekk(String passord) {
  	
      	String pattern = "^(?=.*[0-9])(?=.*[a-zæøå])(?=.*[A-ZÆØÅ])(?=.*[!@#$%&^+=]).{6,20}$";
      	return passord.matches(pattern);
      	
      	
      }

  	public static final String ANY_LETTER = "[a-zA-ZæøåÆØÅ]";
      public static final String ANY_LETTER_OR_DIGIT = "[a-zA-ZæøåÆØÅ0-9]";
      public static final String THREE_TIMES = "{3}";
      public static final String ZERO_OR_MORE_TIMES = "*";

      /**
       * 
       * @param username Brukernavnet som skal valideres
       * @return Om brukenavnet er gyldig eller ikke
       * 
       *         Et gyldig brukernavn består av 4 eller flere tegn. Lovlige tegn
       *         er bokstaver (små og store) inkl. de norske bokstavene, og tall.
       *         Brukernavnet kan ikke begynne med et tall.
       */
      public static boolean isValidUsername(String username) {

          if (username == null) {
              return false;
          }
          return username.matches("^" + ANY_LETTER 
                  + ANY_LETTER_OR_DIGIT + THREE_TIMES 
                  + ANY_LETTER_OR_DIGIT + ZERO_OR_MORE_TIMES + "$");
      }

    /**
     * Denne metoden tester om passordene skrevet inn stemmer overens
     * @param passord er det opprinnelige passordet skrevet inn av bruker
     * @param repetertPassord er det andre passordet skrevet inn av bruker, som er meningen skal være likt
     *                        det opprinnelige
     * @return true or false
     */
      public static boolean isValidRepeatedPassword(String passord, String repetertPassord) {

        if(repetertPassord == null || passord == null)
            return false;

        return repetertPassord.equals(passord);
    }

    /**
     * Denne metoden tester om fornavn skrevet inn av bruker er gyldig i forhold til regex vi har bestemt, og om
     * feltet for fornavn ikke er tomt
     * @param fornavn er navnet bruker skriver inn
     * @return true or false
     */
    public static boolean isValidFirstName(String fornavn) {
        if (fornavn == null)
            return false;

        return fornavn.matches(GYLDIG_FORNAVN);

    }

    /**
     * Denne metoden tester om etternavn skrevet inn av bruker er gyldig i forhold til regex vi har bestemt, og om
     * feltet for etternavn ikke er tomt
     * @param etternavn er etternavnet bruker har skrevet inn
     * @return true or false
     */
    public static boolean isValidLastName(String etternavn) {
        if (etternavn == null)
            return false;

        return etternavn.matches(GYLDIG_ETTERNAVN);
    }
      

}
