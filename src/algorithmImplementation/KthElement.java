package algorithmImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class KthElement {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int T = input.nextInt();

    for (int i = 0; i < T; i++) {
      int n = input.nextInt();
      int k = input.nextInt();
      List<Integer> inputArray = new ArrayList<Integer>();

      for (int j = 0; j < n; j++) {
        inputArray.add(input.nextInt());
      }

      int min = findKth(inputArray, k);
      System.out.println(min);


    }
  }

  private static int findKth(List<Integer> inputArray, int k) {

    int p = 0;
    int q = inputArray.size() - 1;     
    Random ran = new Random();


    while (p <= q) {
      int pivot = ran.nextInt(q - p + 1) + p;

      int new_index = partition(inputArray, p, q, pivot);

      if (new_index == k - 1) {
        return inputArray.get(new_index);
      } else
        if (new_index > k - 1) {
        q = new_index - 1;
      } else {
        p = new_index + 1;
      }
    }
    return 0;
  }
  
  
  
 private static int partition(List<Integer> inputArray, int p, int q, int pivot) {
    
    int pivot_value = inputArray.get(pivot);
    
    int new_index = p;
    Collections.swap(inputArray, pivot, q);
    
    for(int i =p; i <q; i++) {
      // change the comparison
      if(inputArray.get(i) < pivot_value) {
        Collections.swap(inputArray, i, new_index++ );
      }
    }
    
    Collections.swap(inputArray, q, new_index );

    return new_index;
  }

}
