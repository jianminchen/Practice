package algorithmImplementation;

import java.util.Scanner;

public class SherlockAndSquare {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int T = Integer.parseInt(input.nextLine());
		for (int i = 0; i < T; i++) {
				String[] params = input.nextLine().split(" ");

				int A = Integer.parseInt(params[0]);
				int B = Integer.parseInt(params[1]);
				calculateSquares(A,B);
		
			}
	}


	private static void calculateSquares(int a, int b) {
		
      int sqrtCount = (int)(Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
		System.out.println(sqrtCount);
	}
}
