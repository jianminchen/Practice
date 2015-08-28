package algorithmWarmUp;

import java.util.Scanner;

public class DiagonalDifference {

	  public static void main(String args[]) {

			Scanner input = new Scanner(System.in);

			int n = input.nextInt();
			int[][] matrix = new int[n][n];
			int dsum1 = 0, dsum2 = 0;  
			int flag = n -1;

			if ( n ==1 || n < 100 || n == 100) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						matrix[i][j] = input.nextInt(); 
						if( i == j){
							dsum1 = dsum1 + matrix[i][j];
						}
						if ( j == flag){
							dsum2 = dsum2 +  matrix[i][j];

						}				

					}
					flag = flag -1;
				}

				int difference = Math.abs(dsum1 - dsum2);
				System.out.println(""+difference);
			}



		}

}
