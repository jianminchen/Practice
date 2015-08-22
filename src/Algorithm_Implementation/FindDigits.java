package Algorithm_Implementation;

import java.util.Scanner;


public class FindDigits {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();

		for (int i = 0; i < T; i++) {
			String val = input.next();
			if (Integer.parseInt(val) == 0 ||Integer.parseInt(val)  == 1) {
				System.out.println(val);
			}
			if (Integer.parseInt(val)  > 1) {
				getResult(val);

			}
		}

	}

	private static void getResult(String value) {
		int length = value.length();
		int digit = Integer.parseInt(value);
		int count = 0;
		for(int i =0 ;i<length; i++) {
			int div = Character.getNumericValue(value.charAt(i));
		
			if(div !=0 && digit % div == 0 ){
				count++;
			}			
		}
		
		System.out.println(count);
		
	}

}
