package matrix;

import java.util.Scanner;

/**
 * @author Shalini
 *
 */
public class ClockwiseRotation {
  public static void main(String args[]) {

    Scanner input = new Scanner(System.in);
    String testCase = input.nextLine();
    int row = Integer.parseInt(testCase);
    int[][] matrix = new int[row][row];

    for (int i = 0; i < row; i++) {
      String temp = input.nextLine();
      String[] array = temp.split(" ");

      if (array.length != row) {
        System.out.println("ERROR");
        System.exit(0);
      } else {

        for (int j = 0; j < row; j++) {
          matrix[i][j] = Integer.parseInt(array[j]);
        }
      }

    }


    rotate(matrix, row);
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < row; j++) {
        System.out.print(matrix[i][j]);
        System.out.print(" ");

      }
      System.out.println();
    }



  }

  private static void rotate(int[][] matrix, int n) {

    // No of Layers to be rotated 
    for (int i = 0; i < n / 2; i++) {


      int top = Integer.MAX_VALUE;
      int temp;
      int last = Integer.MAX_VALUE;
      int temp2;
      int firstLayer = i, temp4;
      int lastLayer = n - i - 1;
      int bottom = Integer.MAX_VALUE, left = Integer.MAX_VALUE;

      int right = Integer.MAX_VALUE;
      int temp3;

      // Layer wise rotation
      for (int j = firstLayer; j < lastLayer; j++) {

        if (top == Integer.MAX_VALUE) {

          top = matrix[i][j];
          right = matrix[j][lastLayer];
          left = matrix[n - 1 - j][i];
          bottom = matrix[lastLayer][n - 1 - j];
        }

        temp = matrix[i][j + 1];
        matrix[i][j + 1] = top;
        top = temp;

        temp2 = matrix[j + 1][lastLayer];
        matrix[j + 1][lastLayer] = right;
        right = temp2;

        temp3 = matrix[n - 1 - (j + 1)][i];
        matrix[n - 1 - (j + 1)][i] = left;
        left = temp3;

        temp4 = matrix[lastLayer][n - 1 - (j + 1)];
        matrix[lastLayer][n - 1 - (j + 1)] = bottom;
        bottom = temp4;

      }



    }

  }
}
