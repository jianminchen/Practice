package matrix;

public class ZeroMatrix {



  public static void setZeros(int[][] matrix) {

    boolean rowHasZero = false;
    boolean colHasZero = false;

    // check first row and column

    for (int j = 0; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        rowHasZero = true;
        break;
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        colHasZero = true;
        break;
      }
    }


    // check for the rest

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    // nullify the rows based on values

    for (int i = 1; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        nullifyRow(matrix, i);
      }
    }

    // nullify the col based on values

    for (int j = 1; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        nullifyCol(matrix, j);
      }
    }

    // nullify the first row
    if (rowHasZero) {
      nullifyRow(matrix, 0);
    }
    // nullify the first col
    if (colHasZero) {
      nullifyCol(matrix, 0);
    }

  }

  private static void nullifyRow(int[][] matrix, int row) {

    for (int j = 0; j < matrix[0].length; j++) {
      matrix[row][j] = 0;
    }
  }


  private static void nullifyCol(int[][] matrix, int col) {

    for (int i = 0; i < matrix.length; i++) {
      matrix[i][col] = 0;
    }
  }
}
