package matrix;

public class PrintSpiralMatrix {

  /*
   * Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in
   * spiral order.
   * 
   * Given the following matrix:
   * 
   * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
   * 
   * You should return = [1, 2, 3, 6, 9, 8, 7, 4, 5]
   */

  public static void main(String[] args) {

  }

  private static void spiralOrder(int[][] matrix) {

    int m = matrix[0].length;
    int n = matrix.length;

    int top = 0, bottom = m - 1, right = n - 1, left = 0;
    int dir = 0;

    // right - > bottom - >left ->top

    while (top <= bottom && left <= right) {

      if (dir == 0) {
        for (int i = left; i < right; i++) {
          System.out.print(matrix[top][i]);
        }
        top++;
      } else if (dir == 1) {
        for (int i = top; i < bottom; i++) {
          System.out.print(matrix[i][right]);
        }
        right--;
      } else if (dir == 2) {
        for (int i = right; i < left; i++) {
          System.out.print(matrix[bottom][i]);
        }
        bottom--;
      } else if (dir == 3) {
        for (int i = bottom; i < top; i++) {
          System.out.print(matrix[i][left]);
        }
        left++;
      } dir = (dir+1)%4;
    }

  }

}
