package DP;

import java.math.BigInteger;

public class UniquePaths {

  public static void main(String[] args) {
    System.out.println(uniquePaths(3,100));
     System.out.println(uniquePathsDP(3,100));

  }
  
  //combination 
  public static int uniquePaths(int a, int b) {
    
    
    if(a==0 || b==0) return 0;
    if(a==1 || b==1) return 1;
 
    BigInteger p1 = factorial(a-1);

    BigInteger p2 = factorial(b-1);

    BigInteger p3 = factorial((a-1)+(b-1));

   
    BigInteger p4 = p3.divide((p1.multiply(p2)));
    
    return p4.intValue();
    
}
  //larger factorial
  private static BigInteger factorial(int number) {
    
    BigInteger factorial = BigInteger.ONE;

    for (int i = number; i > 0; i--) {
        factorial = factorial.multiply(BigInteger.valueOf(i));
    }

    return factorial;
}
  
  //DP
  public static int uniquePathsDP(int m, int n) {
    if(m==0 || n==0) return 0;
    if(m==1 || n==1) return 1;
 
    int[][] dp = new int[m][n];
 
    //left column
    for(int i=0; i<m; i++){
        dp[i][0] = 1;
    }
 
    //top row
    for(int j=0; j<n; j++){
        dp[0][j] = 1;
    }
 
    //fill up the dp table
    for(int i=1; i<m; i++){
        for(int j=1; j<n; j++){
            dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
    }
 
    return dp[m-1][n-1];
}

}
