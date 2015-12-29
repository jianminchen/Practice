package bitManipulation;

import java.util.Scanner;

/**
 * @author Shalini
 *
 */
public class FlippingBits {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int T = Integer.parseInt(input.nextLine());
   
   
    long max = (long)Math.pow(2, 32)-1;
    
    long result =0;
    for (int i = 0; i < T; i++) {
        
      long num = Long.parseLong(input.nextLine());
      
      //hint : XOR with 1 gives negation(flipping)
      result = max ^ num;
      
      System.out.println(result);
    }
  }

}
