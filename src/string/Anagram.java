package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Anagram {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int T = Integer.parseInt(input.nextLine());
    int[] result = new int[T];
    for (int i = 0; i < T; i++) {
      String str = input.nextLine();
      result[i] = findAnagram(str);
    }

    for (int value : result) {
      System.out.println(value);
    }
  }

  private static int findAnagram(String str) {

    int length = str.length();
    int finalValue = -1;

    if (length % 2 == 0) {

      String tempStr1 = str.substring(0, length / 2);
      String tempStr2 = str.substring(length / 2, length);

      Arrays.sort(tempStr1.toCharArray());
      Arrays.sort(tempStr2.toCharArray());

      if (tempStr1.equals(tempStr2)) {
        finalValue = 0;
      } else {
        HashMap<Character, Integer> resultMap = new HashMap<Character, Integer>();

        for (int i = 0; i < tempStr2.length(); i++) {

          char key1 = tempStr2.charAt(i);

          if (resultMap.containsKey(key1)) {
            resultMap.put(key1, resultMap.get(key1) + 1);
          }

          else {
            resultMap.put(key1, 1);
          }
        }

        int sum = 0;
        for (int i = 0; i < tempStr1.length(); i++) {

          char temp = tempStr1.charAt(i);

          if (resultMap.containsKey(temp)) {

            int value = resultMap.get(temp);
            if (value == 0) {
              sum = sum + 1;
            } else {
              resultMap.put(temp, value - 1);
            }
          } else {
            sum = sum + 1;
          }

        }

        finalValue = sum;
      }

    }

    return finalValue;
  }

}
