package sorting;

public class InserionSort {

  public static void main(String[] args) {

    int[] inputArray = { 4, 5, 6, 2, 3, 1 };

    int[] result = insertSort(inputArray);
    for (int i : result) {
      System.out.print(i + " ");
    }
  }

  /*
   *Stable O(1) extra space O(n2) comparisons and swaps Adaptive: O(n) when
   * nearly sorted
   */
  private static int[] insertSort(int[] inputArray) {

    int n = inputArray.length;
    int current, j;
    for (int i = 0; i < n ; i++) {
      current = inputArray[i];
      j = i-1;
      
      while (j >=0 && inputArray[j] > current) {
        inputArray[j+1] = inputArray[j];
        j = j-1;
      }
      inputArray[j +1] = current;
    }
    return inputArray;
  }

}
