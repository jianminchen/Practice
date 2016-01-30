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

  
  // Another way use 2 binary search :
  // 1. find the index of smallest element
  // 2. based on the index do binary search 
  /*
   * 
   *  int lo  = 0;
      int hi  = arr.size() -1;
      int mid = (lo + hi)/2; 
      
      while (lo < hi) {
         mid = (lo + hi)/2;
         if (mid == 0 || a[mid] < a[mid-1]) {
            return mid;
         } else if (a[mid] > a[lo]){
            lo = mid +1;
         }else {
            hi = mid -1; 
         }
      }
      return 0;
   }
   
   bool  bs(int []arr, num, int lo, int hi);
   
   public static boolean searchNum(int []arr, int num){
     
      int n =3;
      int pivot = getPivot(arr, n);
      
      if (a[0] < num) { 
         bs(arr,n, 0, pivot - 1); 
      } else {
          bs(arr,n, pivot, arr.size() -1); 
      }
   } 
   

   */
}
