package algorithmImplementation;

import java.util.Scanner;

public class TaumandBday {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();

		for (int i = 0; i < testCases; i++) {
			long B = input.nextLong();
			long W = input.nextLong();
			long X = input.nextLong();
			long Y = input.nextLong();
			long Z = input.nextLong();

			findMinAmount(B, W, X, Y, Z);
		}

	}

	private static void findMinAmount(long b, long w, long x, long y, long z) {

		long result = 0;

		if ((x == z && y == z) || (z > x && z > y)) {

			result = x * b + y * w;

		}

		else {

			result = b * Math.min(x, y + z) + w * Math.min(y, x + z);

		}
		System.out.println(result);

	}

}
