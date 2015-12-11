package practice;

public class MaxArraySum {
  
  private int maxSum(int[] arr) {
    
    int max =0;
    int sum = 0;
    
    for(int i =0 ;i < arr.length ; i++) {
      
      sum += arr[i];
      
      if (max < sum ){
        max = sum;
      }
      else if (sum <0) {
        sum =0;
      }
    }
    return max;
  }
  
  
  public static void main(String args[]) {
    
    MaxArraySum  mx = new MaxArraySum();
    int[] A = {5, -9,6,-2,3};
    System.out.println(mx.maxSum(A));
  }

}
