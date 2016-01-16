package arrays;

import java.util.HashMap;
import java.util.Map;

public class ConsecutiveNumbers {

  public static void main(String[] args) {
    int[] array = { 4, 5, 6, 7, 8, 9, 12, 15, 16, 17, 18, 20, 22, 23, 24, 27 };
    Map<Integer, Integer> list = new HashMap<Integer, Integer>();

    list = findIndex(array);
}

// Bruteforce
private static Map<Integer, Integer> findIndex(int[] array) {
    Map<Integer, Integer> list = new HashMap<Integer, Integer>();

    int end = array.length;
    if (end > 0) {
        int start = 0;
        for (int i = 1; i < end; i++) {
            if (array[i] != array[i - 1] + 1) {
                if (i - start > 1) {
                    list.put(start, i - 1);
                    System.out.println("i = " + start + " to j = " + (i - 1));
                }
                start = i;
            } 
        }
        if (end - start > 1) {
            list.put(start, end - 1);
            System.out.println("i = " + start + " to j = " + (end - 1));
        }
    }
    return list;
}

}
