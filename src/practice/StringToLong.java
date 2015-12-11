package practice;


/**
 * @author Shalini
 * 
 * This program is a routine that converts the string to a long, without using the built in functions.
 *
 */
public class StringToLong {

  /**
   * @param inputString the String which we need to convert in to long
   * @return long value of the given string
   * @throws NumberFormatException
   */
  private static long stringToLong(String inputString)
      throws NumberFormatException {

    long result = 0;
    long placeValue = 1;
    char digit;
    int length = inputString.length();
    boolean startChar = inputString.startsWith("-");
    boolean endChar = inputString.endsWith("L");
    int end = length - 1;
    int start = 0;
    boolean flag = false;

    if (endChar) {
      end = end - 1;
    }

    if (startChar) {
      start = 1;
    }

    for (int i = end; i >= start; i--) {

      digit = inputString.charAt(i);

      // negative values
      if (digit == '-') {
        flag = true;

      } else {

        /*
         * ASCII value for integer in java ranges between 48 and 56 '5' has the int
         * value 53 if we write '5'-'0' it evaluates to 53-48, or the integer 5
         */
        if (digit < 48 || digit > 57) {
          throw new NumberFormatException("Not a Valid Input");

        } else {
          // result = result + ((digit - 48) * placeValue);
          result = result + ((digit - '0') * placeValue);
          placeValue = placeValue * 10;
        }

      }

    }
    //if it is negative
    if (flag) {
      return -result;
    }
    return result;
  }
  
//test client 
 public static void main(String[] args) {

   /*
     Scanner stdIn = new Scanner(System.in); String inputString =
     stdIn.nextLine();
     long result = stringToLong("1234567793942389585");
     if (result == Long.parseLong(inputString)) {
     System.out.println("Success, the long value is = " + result);
   } else {
     System.out.println("Failure");
   }
    */

   long result = stringToLong("1234567793942389585");
   if (result == 1234567793942389585L) {
     System.out.println("Success, the long value is = " + result);
   } else {
     System.out.println("Failure");
   }
 }
}

