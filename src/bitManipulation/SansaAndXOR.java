package bitManipulation;

import java.util.Scanner;

/**
 * @author Shalini
 *
 */
public class SansaAndXOR {

  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    int T = Integer.parseInt(input.nextLine());

    // XOR is associative - so we need not generate sub arrays
    // Such make sure how many times each number is multiplied.
    // if even = 0, odd = xor alternate numbers

    for (int i = 0; i < T; i++) {

      int N = Integer.parseInt(input.nextLine());
      String[] params = input.nextLine().split(" ");

      if (N <= 1) {
        System.out.println(params[0]);
      } else {

        if (N % 2 == 0) {
          System.out.println(0);
        }

        else {
          int result = 0;
          for (int j = 0; j < params.length; j = j + 2) {

            result ^= Integer.parseInt(params[j]);

          }
          System.out.println(result);

        }

      }

    }
  }
}
