package algorithmImplementation;

import java.util.Scanner;

public class UtophianTree {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		for (int i = 0; i < n; i++) {
			int val = input.nextInt();
			if (val == 0) {
				System.out.println(1);
			}
			if (val > 0) {
				calculateHeight(val);

			}
		}

	}

	private static void calculateHeight(int cycles) {
		// TODO Auto-generated method stub
		int height = 1;
		int i = 1;

		while (i <= cycles) {

			//System.out.println("Cycle = " + i);

			if (i % 2 == 0) {
				height = height + 1;
				//System.out.println("Height = " +height);

			} else {
				height = height * 2;
			//	System.out.println("Height = "+height);

			}

			i++;
		}

		System.out.println(height);
	}
}
