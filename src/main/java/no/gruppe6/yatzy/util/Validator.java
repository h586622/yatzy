package no.gruppe6.yatzy.util;

public class Validator {
	
	public static boolean sjekkEpost(String epost) {
		
		String epostLower = epost.toLowerCase();
		String pattern ="^[a-zA-Z0-9_!#$%&�*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		return epostLower.matches(pattern);
	}
         
  //  Passord m� inneholde en stor bokstav, ett tall, ett tegn og m� v�re minst 6 tegn
      public static boolean passordSjekk(String passord) {
  	
      	String pattern = "^(?=.*[0-9])(?=.*[a-z���])(?=.*[A-Z���])(?=.*[!@#$%&^+=]).{6,20}$";
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
  
      

}
