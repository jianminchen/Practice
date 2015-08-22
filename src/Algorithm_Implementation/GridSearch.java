package Algorithm_Implementation;

import java.util.Scanner;

/**
 * @author Shalini
 *
 */

public class GridSearch {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		int T = Integer.parseInt(input.nextLine());

		for (int i = 0; i < T; i++) {
			String[] matrixRC = (input.nextLine()).split(" ");

			int R = Integer.parseInt(matrixRC[0]);
			int C = Integer.parseInt(matrixRC[1]);

			char[][] matrix = new char[R][C];

			for (int j = 0; j < R; j++) {
				char[] tempArray = (input.nextLine()).toCharArray();

				for (int k = 0; k < C; k++) {
					matrix[j][k] = tempArray[k];
				}
			}

			String[] patternRC = (input.nextLine()).split(" ");

			int newR = Integer.parseInt(patternRC[0]);
			int newC = Integer.parseInt(patternRC[1]);

			char[][] patternMatrix = new char[newR][newC];

			for (int j = 0; j < newR; j++) {
				char[] tempPattern = (input.nextLine()).toCharArray();

				for (int k = 0; k < newC; k++) {
					patternMatrix[j][k] = tempPattern[k];
				}
			}

			boolean result = checkfirstOccurance(matrix, R, C, patternMatrix, newR, newC);

			if (result) {

				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}

	}

	private static boolean checkfirstOccurance(char[][] matrix, int r, int c, char[][] patternMatrix, int newR, int newC) {
		for (int a = 0; a < r; a++) {
			for (int b = 0; b < c; b++) {
				if (matrix[a][b] == patternMatrix[0][0]) {

					if (a + newR <= r && b + newC <= c) {
						boolean flag = findPattern(a, b, matrix, patternMatrix, newR, newC);

						if (flag) {
							return true;
						}
					}
				}

			}
		}
		return false;
	}

	private static boolean findPattern(int a, int b, char[][] matrix, char[][] patternMatrix, int newR, int newC) {

		for (int i = 0; i < newR; i++) {
			int newb = b;
			for (int j = 0; j < newC; j++) {

				if (patternMatrix[i][j] != matrix[a][newb]) {
					return false;
				}
				newb = newb + 1;
			}
			a = a + 1;
		}

		return true;
	}
}
