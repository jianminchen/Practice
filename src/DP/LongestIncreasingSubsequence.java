package DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {

    int[] arr = {5, 3, 4, 8, 6, 7};
    int res = findLongestSeq(arr);
    System.out.println(res);

  }

  // Using Dp Time = O(N^2) Space = O(N)
  private static int findLongestSeq(int[] arr) {
    
    int[] LIS = new int[arr.length]; // An array which holds the length of increasing subsequence

    LIS[0] = 1;
    int ans = 1;
    
    for (int i = 1; i <arr.length ;i++) {
      LIS[i] = 1;

      for (int j =0; j <i; j++) {
        
        // increasing subsequence
        if (arr[j] < arr[i]) {
          LIS[i] = Math.max(LIS[i], LIS[j] +1);
        }
         ans =  Math.max(LIS[i], ans);
        }
        
      }
      
  return ans;

}

}