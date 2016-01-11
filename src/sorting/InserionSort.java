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
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        if (inputArray[j] > inputArray[j + 1]) {
          int temp = inputArray[j];
          inputArray[j] = inputArray[j + 1];
          inputArray[j +1] = temp;
        }
      }
    }
    return inputArray;
  }

}
