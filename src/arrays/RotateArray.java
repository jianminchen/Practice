package arrays;

public class RotateArray {

  public static void main(String[] args) {

    int[] arr = {1,2,3,4,5,6,7};
    int k =2;
    rotate(arr, k);
    
    for (int i :arr){
      System.out.print(" "+i);
    }
  }
  
  //left to right
  public static void rotate(int[] arr, int order) {
  
    order = order % arr.length;
 
    if (arr == null || order < 0) {
        throw new IllegalArgumentException("Illegal argument!");
    }
 
    //length of first part
    int a = arr.length - order; 
 
    reverse(arr, 0, a-1);   //rotate first
    reverse(arr, a, arr.length-1);  //rotate second part
    reverse(arr, 0, arr.length-1); //rotate the whole array
 
}
 
public static void reverse(int[] arr, int left, int right){
    if(arr == null || arr.length == 1) 
        return;
 
    while(left < right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }   
}
}
