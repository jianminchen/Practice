package arrays;

public class SearchRotatedArray {

  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 7, 1, 2, 3};
    int k = 2;
    boolean flag = find(arr, k);
    System.out.print(flag);

  }

  //Time O(log N)
  private static boolean find(int[] arr, int k) {
    

    int low = 0;
    int high = arr.length -1;
    
    int mid = low + ((high - low) / 2);
    while (low <=high) {
      
      //case 1 
      if (arr[mid] == k) { 
        return true;
      } 
      
      
      //case 2 : Right half is sorted
      else if ( arr[mid] <= arr[high]) {
       
        if (k > arr[mid] && k <= arr[high]) {
          low = mid +1; // search in right sorted half
        } else {
          high = mid -1;
        }        
      }
      //case 3 :left sorted half
      else {          
          if (k <= arr[low] && k < arr[mid]) {
            high = mid -1; // search in l sorted half
          } else {
            low = mid +1;
          }
          
        }
      }

  return false;
}

}
