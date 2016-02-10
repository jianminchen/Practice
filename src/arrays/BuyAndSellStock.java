package arrays;

public class BuyAndSellStock {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  // keep track min element - One transaction
  public int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int profit = 0;

    for (int i : prices) {

      profit = Math.max(profit, i - min);
      min = Math.min(i, min);
    }

    return profit;
  }


  // find ascending pairs - multiple transaction
  public int maxProfitMultipleTransaction(int[] prices) {

    int diff = 0;
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {

      diff = prices[i] - prices[i - 1];
      if (diff > 0) {
        profit += diff;
      }

    }

    return profit;
  }

  // at most K transactions - dynamic programming
  public int maxProfitKTrans(int[] prices, int k) {
    if (prices == null || prices.length == 0 || k == 0)
      return 0;
    if (k >= prices.length) {
      return maxProfitMultipleTransaction(prices);
    }
    int[] local = new int[k + 1];
    int[] global = new int[k + 1];
    int res = 0;
    int diff = 0;
    for (int i = 1; i < prices.length; i++) {
      for (int j = 1; j <= k; j++) {
        diff = prices[i] - prices[i - 1];
        
        //local[j] + diff = if the transaction happens on today
        //global[j - 1] =  no transaction on the given day
        local[j] = Math.max(local[j] + diff, global[j - 1]);
        global[j] = Math.max(global[j], local[j]);
        res = Math.max(res, global[j]);
      }
    }
    return res;
  }

}
