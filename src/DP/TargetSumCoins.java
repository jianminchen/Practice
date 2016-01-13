package DP;

/*
 * Given a list of N coins, 
   their values (V1, V2, ... , VN), and the total sum S. Find the minimum
 * number of coins the sum of which is S (we can use as many coins of one type as we want), or
 * report that it's not possible to select coins in such a way that they sum up to S.
 * 
 */
/**
 * @author Shalini
 *
 */
public class TargetSumCoins {

  public static void main(String[] args) {

    int sum = 5;
    int[] coinValues = {1, 2, 3};

    int res = findTotalCoins(coinValues, sum);
    System.out.println(res);

  }

  private static int findMinCoins(int[] coinValues, int sum) {

    int[] Min = new int[sum + 1];
    Min[0] = 0;

    for (int i = 1; i <= sum; i++) {
      Min[i] = Integer.MAX_VALUE;
      for (int j = 0; j < coinValues.length; j++) {

        // if coin value lesser than i value
        if (coinValues[j] <= i) {
          Min[i] = Math.min(Min[i - coinValues[j]] + 1, Min[i]);
        }
      }
    }
    return Min[sum];
  }
  
  private static int findTotalCoins(int[] coinValues, int sum) {

    int[][] DP = new int[coinValues.length+1][sum + 1];

    for (int i =0; i <=coinValues.length;i++) {
      DP[i][0] = 1;
    }
    for (int i = 1; i <= coinValues.length; i++) {
      for (int j = 1; j <= sum; j++) {

     if (coinValues[i -1] > j) { 
          DP[i][j] = DP[i -1][j];
        }   else{
          DP[i][j] = DP[i -1][j] + DP[i][j -coinValues[i-1]];
        } 
      }
    }
    return DP[coinValues.length][sum];
  }
}
