package algorithmWarmUp;

import java.util.Scanner;

public class StairCase {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int flag = 1;


		if(n <101 && n >0) {
			int i = 1;
			while (i < n +1 ){
				for (int i1 = 0; i1 < n - flag; i1++ ){
					System.out.print(" ");
				}

				for(int j = 0; j < flag; j++) {
					System.out.print("#");
				}

				flag = flag + 1;
				i = i+1;
				System.out.println("");

			}
		}

	}
}
