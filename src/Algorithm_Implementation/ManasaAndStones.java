package Algorithm_Implementation;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Shalini
 *
 */
public class ManasaAndStones {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int i = 0; i < T; i++) {

			int N = input.nextInt();
			int A = input.nextInt();
			int B = input.nextInt();

			if (A == B) {
				System.out.println(A * (N - 1));
			}

			else {
				calculateLastStone(N, A, B);
			}
		}

	}
	
	/*
	 * If there is a*i stones then there must be (n-1-i)b stones remaining. The total would give
	 * us the last stone in the set. 
	 * 
	 */

	private static void calculateLastStone(int n, int a, int b) {

		if (a < b) {
			//because we need stones in increasing order
			calculateLastStone(n, b, a);
		}

		if (a > b) {

			for (int i = 0; i <= n - 1; i++) {
				System.out.print((a * i) + ((n - 1 - i) * b));
				System.out.print(" ");
			}
			System.out.println();

		}

	}
}
