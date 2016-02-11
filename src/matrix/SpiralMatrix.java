package matrix;

public class SpiralMatrix {

  /*
   * Given an integer n, generate a square matrix filled with elements from 1 to
   * n2 in spiral order.
   * 
   * For example, Given n = 3,
   * 
   * You should return the following matrix: 
   * [ [ 1, 2, 3 ],
   *   [ 8, 9, 4 ], 
   *   [ 7, 6, 5 ] ]
   */

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
  
  
  public int[][] generateMatrix(int n) {
  
 if (n<=0){
      return new int[0][0];
  }
 int [][] matrix=new int[n][n];
   
   int num = 1;
   
   int left =0, right = n-1, top =0, bottom =n-1;
   
   while (left < right && top  < bottom) {
     
     //left to right
     for (int i = left ; i < right;i++) {
       matrix[top][i] = num++;
     }
     
     //top to bottom
     for (int i = top ; i < bottom;i++) {
       matrix[i][right] = num++;
     }
     
     //right to left
     for (int i = right ; i > left;i--) {
       matrix[bottom][i] = num++;
     }
     
     //bottom to top
     for (int i = bottom ; i > top;i--) {
       matrix[i][left] = num++;
     }
     
     left++;
     right--;
     top++;
     bottom--;
     
   }
   
   if ( n%2 != 0) {
     matrix[n/2][n/2] = num;
   }
   
    return matrix;
  }

}
