package algorithmWarmUp;

import java.util.Scanner;

public class SolveMeSecond {
	static int solveMe(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t;
        int sum;
        int a,b;
        t = in.nextInt();
        for (int i=0;i<t;i++) {
            a = in.nextInt();
            b = in.nextInt();
            sum = solveMe(a, b);
            System.out.println(sum);
        }
    }
}
