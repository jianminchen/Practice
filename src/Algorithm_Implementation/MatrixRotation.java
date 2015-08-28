package Algorithm_Implementation;

import java.util.Scanner;

/**
 * @author shalini
 * 
 */
public class MatrixRotation {
  public static void main(String args[]) {

    Scanner input = new Scanner(System.in);
    int M = input.nextInt();
    int N = input.nextInt();
    int R = input.nextInt();
    int elements;
    int[] rotation = new int[N / 2];

    int[][] matrix = new int[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        matrix[i][j] = input.nextInt();
      }
    }

    int min = Math.min(M, N);
    for (int i = 0; i < min / 2; i++) {

      elements = ((M - ((i * 2) + 1)) + (N - ((i * 2) + 1))) * 2;
      rotation[i] = R % (elements);
    }


    rotate(matrix, M, N, rotation);
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(matrix[i][j]);
        System.out.print(" ");

      }
      System.out.println();
    }



  }

  private static void rotate(int[][] matrix, int m, int n, int[] rotations) {

    for (int r = 0; r < rotations.length; r++) {

      while (rotations[r] > 0) {

        int i = r;
        int firstRow = i;
        int lastRow = m - i - 1;
        int left = Integer.MAX_VALUE;
        int temp = 0;
        int temp1 = 0;
        int temp3 = 0;
        int temp4 = 0;

        int right = Integer.MAX_VALUE;
        int firstCol = r;
        int lastCol = n - i - 1;

        for (int j = firstRow; j < lastRow; j++) {

          if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) {

            left = matrix[j][i];
            right = matrix[m - 1 - j][lastCol];

          }
          temp = matrix[j + 1][i];
          matrix[j + 1][i] = left;
          left = temp;

          temp1 = matrix[m - 1 - (j + 1)][lastCol];
          matrix[m - 1 - (j + 1)][lastCol] = right;
          right = temp1;


        }

        for (int k = firstCol; k < lastCol; k++) {

          temp3 = matrix[lastRow][k + 1];
          matrix[lastRow][k + 1] = left;
          left = temp3;

          temp4 = matrix[firstRow][n - 1 - (k + 1)];
          matrix[firstRow][n - 1 - (k + 1)] = right;
          right = temp4;

        }



        rotations[r]--;
      }

    }

  }
}


