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

  private void merge(int lo, int mid, int hi) {

  int[] aux = new int[inputArray.length];

  //copy to aux[]
  for (int k = lo; k <= hi; k++) {
      aux[k] = inputArray[k]; 
  }

  // merge back to a[]
  int i = lo, j = mid+1;
  for (int k = lo; k <= hi; k++) {
      if      (i > mid)   inputArray[k] = aux[j++];
      else if (j > hi)     inputArray[k] = aux[i++];
      else if (aux[j] < aux[i])    inputArray[k] = aux[j++];
      else    inputArray[k] = aux[i++];
  }

}
}
