package sorting;

public class SelectionSort {

  public static void main(String[] args) {

  int[] inputArray = { 4, 5, 6, 2, 3, 1 };

  int[] result = selectSort(inputArray);
  for (int i : result) {
    System.out.print(i + " ");
  }
}

/*
 *Stable O(1) extra space O(n2) comparisons and swaps Adaptive: O(n) when
 * nearly sorted
 */
private static int[] selectSort(int[] inputArray) {

  int n = inputArray.length;
  int min = 0;
  
  for (int i = 0; i < n - 1; i++) {
    min = i;
    for (int j = i+1; j < n ; j++) {
      
      if (inputArray[j] < inputArray[min]) {
        min = j;
      }
    }
    int temp = inputArray[i];
    inputArray[i] = inputArray[min];
    inputArray[min] = temp;
  }
  return inputArray;
}

}
