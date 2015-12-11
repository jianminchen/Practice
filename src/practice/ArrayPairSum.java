package practice;
import java.util.Arrays;

public class ArrayPairSum {
  
  
  public void targetSum(int[] arr, int sum) {
     
    if(arr.length == 0) {
     System.out.println("Empty Array");
    }
    else {
      Arrays.sort(arr);
      int start = 0;
      int end = arr.length -1;
      while (start < end){
    
      int  count = arr[start] + arr[end];
        if(count == sum) {
          System.out.println(arr[start]+ " " + arr[end]);
          start++;
          end--;
        }
        else {
          if (count <sum) start++;
          else end--;
        }
      }
    }
  }

  public static void main(String[] args) {
    ArrayPairSum ap = new ArrayPairSum();
    int[] temp = {1,4,5,6,7,7,-3,0,20,10,13};
    ap.targetSum(temp,7);
  }

}
