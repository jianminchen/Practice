package algorithmWarmUp;

import java.util.Scanner;

public class SolveMeFirst {

	static int solveMe(int a, int b) {
        return a+b;
   }

   
 public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;
        sum = solveMe(a, b);
        System.out.println(sum);
   }

}
