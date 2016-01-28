package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

  /*
   * Given a list of non negative integers, arrange them such that they form the
   * largest number.
   */
  public static void main(String[] args) {

    LargestNumber find = new LargestNumber();
    int[] array = { 3, 30, 34, 5, 9 };
    System.out.print(find.largestNumber(array));
  }

  public String largestNumber(int[] nums) {

    String[] str = new String[nums.length];

    for (int i = 0; i < nums.length; i++) {
      str[i] = String.valueOf(nums[i]);
    }

    Arrays.sort(str, myComparator);

    StringBuilder sb = new StringBuilder();
    for (String s : str) {
      sb.append(s);
    }

    while (sb.charAt(0) == '0' && sb.length() > 1) {
      sb.deleteCharAt(0);
    }

    return sb.toString();

  }

  public static Comparator<String> myComparator = new Comparator<String>() {

    public int compare(String o1, String o2) {
      String comb1 = o1 + o2;
      String comb2 = o2 + o1;

      return -comb1.compareTo(comb2);
    }
  };

}
