package practice;

public class MaxSubArraySum {

  public static void main(String[] args) {

    
    int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    
    int max = findMaxSum(arr);
    System.out.print( "Total = " +max);
  }

  //O(N) time
  private static int findMaxSum(int[] arr) {

    int currentMax = arr[0];
    int totalMax = arr[0];
    int x =0, y =0;
    
    for (int i =1; i<arr.length; i++) {
      
     // currentMax = Math.max(currentMax+arr[i], arr[i]);
      
      currentMax = currentMax + arr[i]; 
      if (currentMax < arr[i]) {
        currentMax = arr[i]; 
        x = i; //index 
      }
    //  totalMax = Math.max(totalMax, currentMax);
      if (totalMax < currentMax) {
        totalMax = currentMax;
        y =i;
      }
    }
    System.out.println( "subset = "+ (x +1) +" to " + (y+1) );
  

    return totalMax;
  }

}
