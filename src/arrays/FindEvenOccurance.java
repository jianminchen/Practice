package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindEvenOccurance {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    int number[] = { 1, 6, 4, 1, 4, 5, 8, 8, 4, 6, 8, 8, 9, 7, 9, 5, 9 };
    FindEvenOccurance findEven = new FindEvenOccurance();
    findEven.getEvenDuplicates(number);

  }

  // Brute force
  private void getEvenDuplicates(int[] number) {

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i : number) {

      if (map.containsKey(i)) {
        // a XOR a XOR a ---- - -- - - odd times = a
        // a XOR a ---- -- -- --- - even times = 0
        int value = map.get(i) ^ i;
        map.put(i,value);
      } else {
        map.put(i, i);
      }
    }

    for (Entry<Integer, Integer> entry : map.entrySet()) {

      if (entry.getValue() == 0) {
        System.out.println(entry.getKey());
      }

    }
  }

}
