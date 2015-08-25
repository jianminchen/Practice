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
    int elements;
    int[] rotation = new int[N/2];

    int[][] matrix = new int[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        matrix[i][j] = input.nextInt();
      }
    }

    for (int i = 0; i < N / 2; i++) {

      elements = ((N - ((i * 2) + 1)) + (M - ((i * 2) + 1))) * 2;
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
      int top = Integer.MAX_VALUE;
      int temp;
      int last = Integer.MAX_VALUE;
      int temp2;
      int firstLayer = i;
      int lastLayer = n - i - 1;

      int right = Integer.MAX_VALUE;
      int temp3;

      for (int j = firstLayer; j < lastLayer; j++) {
        if (top == Integer.MAX_VALUE) {
          top = matrix[j][i];
          last = matrix[lastLayer][j];
          right = matrix[n - 1 - j][lastLayer];

        }
        matrix[i][j] = matrix[i][j + 1];
        temp = matrix[j + 1][i];
        matrix[j + 1][i] = top;
        top = temp;
        temp2 = matrix[lastLayer][j + 1];
        matrix[lastLayer][j + 1] = last;
        last = temp2;
        temp3 = matrix[n - 1 - j - 1][lastLayer];
        matrix[n - 1 - j - 1][lastLayer] = right;
        right = temp3;

      }
      rotations[r]--;
      }

    }

  }
}


