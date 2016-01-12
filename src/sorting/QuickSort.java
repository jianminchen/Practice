package sorting;

import java.util.Arrays;
public class QuickSort {

  private static int[] inputArray = { 9, 2, 4, 7, 3, 7, 10 };
  
  
  private static void quickSort(int[] arr, int low, int high) {
    
    if (low >= high || arr.length == 0 ||arr == null) {
      return;
    }
    
    int pivot = partition(arr, low, high);
     
    //recursively sort 
    quickSort(arr, low, pivot -1);
    quickSort(arr, pivot +1, high);
    
  }

  private static int partition(int[] arr, int low, int high) {
    
    int i = low;
    int j = high;
    
    int pivotElement = arr[low];
    
    while (true) {
      
      while (arr[i] < pivotElement) {
        i++;
        if (i == high) break;
      }
      
      while (arr[j] > pivotElement) {
        j--;
        if (j == low) break;
      }
      
      //check if the pointers cross
      if (i >= j) break; 
      
      if (i <= j) {
      swap(i,j);
      i++;
      j--;
      }
    }
    
    //put pivot at the partition
    swap(low,j);
    
    return j;
  }

  private static void swap(int i, int j) {
    int temp = inputArray[i];
    inputArray[i] = inputArray[j];
    inputArray[j] = temp;
}
 
  
  public static void main(String[] args) {
    System.out.println(Arrays.toString(inputArray));

    int low = 0;
    int high = inputArray.length - 1;

    quickSort(inputArray, low, high);
    System.out.println(Arrays.toString(inputArray));
  }


}
