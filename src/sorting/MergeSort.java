package sorting;

import java.util.Arrays;

public class MergeSort {

  private static int[] inputArray = {2, 6, 3, 5, 1};

  public static void main(String[] args) {
    MergeSort doMerge = new MergeSort();
    int length = inputArray.length - 1;
    
    doMerge.mergeSort(0, length);
    System.out.println(Arrays.toString(inputArray));
  }

  private void mergeSort(int low, int high) {

    if (low >= high) {
      return;
    }
    int mid = low + ((high - low) / 2);
    mergeSort(low, mid);
    mergeSort(mid + 1, high);
    merge(low, mid, high);

  }

  private void merge(int low, int mid, int high) {

    int[] tempMergArr = new int[inputArray.length];
    
    for (int i = low; i <= high; i++) {
      tempMergArr[i] = inputArray[i];
  }
  int i = low;
  int j = mid +1;
  int k = low;
  while (i <= mid && j <= high) {
      if (tempMergArr[i] <= tempMergArr[j]) {
          inputArray[k] = tempMergArr[i];
          i++;
      } else {
          inputArray[k] = tempMergArr[j];
          j++;
      }
      k++;
  }
  while (i <= mid) {
      inputArray[k] = tempMergArr[i];
      k++;
      i++;
  }

}
}
