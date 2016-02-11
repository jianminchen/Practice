package arrays;

import java.util.Arrays;
import java.util.List;

public class MaximumDistant {

  public static void main(String[] args) {
    //int arr[] = {1,1};
     int arr[] = {34, 8, 10, 3, 2, 80, 30, 33, 1};
    int maxDiff = maxIndexDiff(arr);
    System.out.println(maxDiff);
  }

  private static int maxIndexDiff(int[] arr) {
    int size = arr.length;
    if (size < 1)
      return 0;

    if (size == 2) {
      if (arr[0] <= arr[1]) {
        return 1;
      } else
        return -1;
    }
    int[] lmin = new int[size];
    int[] rmax = new int[size];
    lmin[0] = arr[0];

    // LMin[i] holds the smallest element on left side of arr[i] including arr[i]
    for (int i = 1; i < size; i++) {
      lmin[i] = Math.min(arr[i], lmin[i - 1]);
    }
    System.out.println(Arrays.toString(lmin));
    
    // RMax[j] holds the greatest element on right side of arr[j] including arr[j]
    rmax[size - 1] = arr[size - 1];
    for (int j = size - 2; j >= 0; j--) {
      rmax[j] = Math.max(arr[j], rmax[j + 1]);
    }
    System.out.println(Arrays.toString(rmax));

    int i = 0, j = 0, maxDiff = -1;
    while (j < size && i < size) {
      if (lmin[i] <= rmax[j]) {
        maxDiff = Math.max(maxDiff, j - i);
        j = j + 1;
      } else
        i = i + 1;
    }

    return maxDiff;

  }
}
