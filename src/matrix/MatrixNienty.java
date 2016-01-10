package matrix;

import java.util.Scanner;

public class MatrixNienty {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);
		int M = input.nextInt();
		int N = input.nextInt();
		int R = input.nextInt();
		int elements;

		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = input.nextInt();
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");

			}
			System.out.println();
		}

		System.out.println();
		System.out.println();

		R = (R / 90) % 4;
		System.out.println(R);

		int[][] result = rotate(matrix, M, N, R);
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(result[i][j]);
				System.out.print(" ");

			}
			System.out.println();
		}

	}

	//extra space
	private static int[][] rotate(int[][] matrix, int m, int n, int r) {
	
		int[][] output = null;
		
		while (r > 0) {
			output = new int[n][m];

			for (int i = 0; i < m; i++) {

				for (int j = 0; j < n; j++) {

					output[j][m - 1 - i] = matrix[i][j];

				}

			}
			r--;
		}

		return output;

	}
}
