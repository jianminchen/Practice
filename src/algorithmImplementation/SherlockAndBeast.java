package algorithmImplementation;
import java.util.Scanner;


public class SherlockAndBeast {
	
		public static void main(String args[]) {
			Scanner input = new Scanner(System.in);
			int n = input.nextInt();

			for (int i = 0; i < n; i++) {
				int val = input.nextInt();
				if (val <= 2) {
					System.out.println(-1);
				}
				if (val > 2) {
					calculateBeast(val);
				}
			}

		}

		private static void calculateBeast(int digit) {
			// TODO Auto-generated method stub
			int fives = 0;
			int threes = 0;
			int temp = digit;

			while (temp > 2) {

				if (temp % 3 == 0) {
					fives = temp;
					System.out.println("Fives :" + fives);
					break;
				}

				temp = temp - 5;
			}

			threes = digit - fives;
			System.out.println("threes :" + threes);

			StringBuilder result = new StringBuilder();
			if (fives % 3 == 0 && threes % 5 == 0) {
				while (fives > 0) {
					result.append(5);
					fives--;

				}
				while (threes > 0) {
					result.append(3);
					threes--;
				}
				System.out.println("result :" + result);
			}

			else {
				System.out.println(-1);

			}
		}


}
