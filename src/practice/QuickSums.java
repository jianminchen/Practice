package practice;

/**
 * @author Shalini
 * 
 *         Given a string of digits, find the minimum number of additions required for the string to
 *         equal some target number. Each addition is the equivalent of inserting a plus sign
 *         somewhere into the string of digits. After all plus signs are inserted, evaluate the sum
 *         as usual. For example, consider the string "12" (quotes for clarity). With zero
 *         additions, we can achieve the number 12. If we insert one plus sign into the string, we
 *         get "1+2", which evaluates to 3. So, in that case, given "12", a minimum of 1 addition is
 *         required to get the number 3. As another example, consider "303" and a target sum of 6.
 *         The best strategy is not "3+0+3", but "3+03". You can do this because leading zeros do
 *         not change the result.
 * 
 *         Write a class QuickSums that contains the method minSums, which takes a String numbers
 *         and an int sum. The method should calculate and return the minimum number of additions
 *         required to create an expression from numbers that evaluates to sum. If this is
 *         impossible, return -1.
 *
 */

public class QuickSums {

  public static void main(String args[]) {
    String input = "99999";
    int total = 45;
    int res = minSums(input, total);
    System.out.println(res);
  }

  // With at most 10 digits, there are at most 2^9 ways to insert plus signs into the string.
  // Therefore, there are at most 29 possibilities to consider. We can use recursion to go through
  // all possibilities and keep track of the minimum number of additions required
  public static int minSums(String numbers, int sum) {
    int N = numbers.length();

    // base cases
    if (N <= 3 && sum == Integer.parseInt(numbers)) {
      return 0;
    }

    else if (N == 2 && Integer.parseInt(numbers.substring(0, N - 1))
        + Integer.parseInt(numbers.substring(N - 1)) == sum) {
      return 1;
    } else if (N == 2 && Integer.parseInt(numbers.substring(0, N - 1))
        + Integer.parseInt(numbers.substring(N - 1)) != sum) {
      return -1;
    }
    else if (N == 1 && Integer.parseInt(numbers) != sum) {
      return -1;
    }

    // solution
    else {

      int lenOFStr = N-1;
      int possibleCombination = (int) Math.pow(2, lenOFStr);

      // numbers will contain between 1 and 10 characters, inclusive.
      int min = 20;
      StringBuilder tempString;
      for (int i = 0; i < possibleCombination; i++) {
        String plus = Integer.toBinaryString(i);
        while (plus.length() < lenOFStr) {
          plus = "0" + plus;
        }
        // System.out.println(plus);

        // Add plus sign to the string
        tempString = new StringBuilder(numbers);
        int len = N;
        for (int k = 0; k < lenOFStr ; k++) {
          if (plus.charAt(k) == '1') {
            len = len + 1;
            int offset = len-N+k;
           // System.out.println(offset);
            tempString.insert(offset, " ");
          }
        }
        // System.out.println(tempString);

        // compute the sum
        String[] arr = tempString.toString().split(" ");
        long tempSum = 0;
        for (String s : arr) {
          tempSum +=Long.parseLong(s);
        }

        // check if the sum is same
        if (tempSum == sum) {
          min = Math.min(arr.length-1, min);
        }


      }
      return (min == 20) ? -1 : min;

    }
  }

}
