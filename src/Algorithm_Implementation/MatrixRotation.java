package Algorithm_Implementation;

import java.util.Scanner;

/**
 * @author sravis0
 * 
 */
public class MatrixRotation {
	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);
		int M = input.nextInt();
		int N = input.nextInt();
		int R = input.nextInt();

		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = input.nextInt();
			}
		}

		if (R > 0) {
			rotate(matrix, M, N, R);
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");

			}
			System.out.println();
		}

	}

	private static void rotate(int[][] matrix, int m, int n, int r) {

		for (int i = 0; i < n / 2; i++) {

			int top = Integer.MAX_VALUE;
			int temp;
			int last =Integer.MAX_VALUE;
			int temp2;
			int firstLayer = i;
			int lastLayer = n - i - 1;
			
			int right = Integer.MAX_VALUE;
			int temp3;
			// int elements = ( (n - ((i *2)+1)) + (m - ((i *2)+1)))*2;
			// int rotation = r % (elements);

			// while (rotation > 0) {
			for (int j = firstLayer; j < lastLayer; j++) {
				if (top == Integer.MAX_VALUE) {
					top = matrix[j][i];
					last = matrix[lastLayer][j];
					
				}
				matrix[i][j] = matrix[i][j + 1];
				temp = matrix[j + 1][i];
				matrix[j + 1][i] = top;
				top = temp;
				temp2 = matrix[lastLayer][j + 1];
				matrix[lastLayer][j + 1] = last;
				last = temp2;
				matrix[n -1 -j][lastLayer] = matrix[n -1 -j][lastLayer];
				System.out.println("last  = " +last);
				

				/*if (last == Integer.MAX_VALUE) {
					last = matrix[lastLayer][j];
					right = matrix[j][lastLayer];
					System.out.println("last if = " +last);
				}
				System.out.println("last = " +last);
				matrix[j][lastLayer] = matrix[j+1][lastLayer];
				temp2 = matrix[lastLayer][j + 1];
				matrix[lastLayer][j + 1] = last;
				last = temp2;
				System.out.println("temp2 = " +temp2);
				
*/
				

				

			}
		}
	}

}

// }
