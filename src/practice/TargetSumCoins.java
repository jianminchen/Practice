package practice;

/*
 * Given a list of N coins, their values (V1, V2, ... , VN), and the total sum S. Find the minimum
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

    int sum = 11;
    int[] coinValues = {1, 3, 5};

    int res = findMinCoins(coinValues, sum);
    System.out.println(res);

  }

  private static int findMinCoins(int[] coinValues, int sum) {

    int[] Min = new int[sum + 1];

    for (int i = 0; i <= sum; i++) {
      Min[i] = Integer.MAX_VALUE;
    }

    Min[0] = 0;

    for (int i = 1; i <= sum; i++) {

      for (int j = 0; j < coinValues.length; j++) {

        if (coinValues[j] <= i && (Min[i - coinValues[j]] + 1) < Min[i]) {
          Min[i] = Min[i - coinValues[j]] + 1;
        }
      }
    }
    return Min[sum];
  }

}
