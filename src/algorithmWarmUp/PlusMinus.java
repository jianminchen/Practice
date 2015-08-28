package algorithmWarmUp;

import java.util.Scanner;

public class PlusMinus {
	 
		public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double n = input.nextDouble();
		int pos = 0 , neg = 0, zero = 0;
		int[] digits = new int[(int) n];
		for (int i =0; i<n; i++) {
			digits[i] = input.nextInt(); 
			
			if (digits[i] == 0) {
				zero = zero + 1;
			}
			
			if (digits[i] > 0) {
				pos = pos + 1;
			}
			
			if (digits[i] < 0) {
				neg = neg + 1;
			}

		
		}
		
		System.out.println(pos/n);
		System.out.println(neg/n);
		System.out.println(zero/n);

		

		}
}
