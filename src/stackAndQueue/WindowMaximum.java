package stackAndQueue;

import java.util.Deque;

public class WindowMaximum {

  public static void main(String[] args) {

    int[] temp = {1,-4,-5,-6,-7,-7,-3,0,20,10,13};
    int k = 3; 
    WindowMaximum max = new WindowMaximum();
    int[] result = max.maxSlidingWindow(temp, k);
    
    for (int i : result) {
      System.out.println(i);
    }

  }
  
  public int[] maxSlidingWindow(int[] nums, int k) {
    return nums;
    
  }

}
