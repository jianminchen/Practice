package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class WindowMaximum {

  public static void main(String[] args) {

    int[] temp = {1,-4,-5,-6,-7,-7,-3,0,20,10,13};
    int k = 3; 
    WindowMaximum max = new WindowMaximum();
    int[] result = max.windowMax(temp, k);
    
    for (int i : result) {
      System.out.println(i);
    }

  }
  
  public int[] windowMax(int[] nums, int window) {  
    int w = (nums.length < window) ? nums.length : window;  
    // A deque allows insertion/deletion on both ends.  
    // Maintain the first as the index of maximal of the window  
    // and elements after it are all smaller and came later than the first.  
    Deque<Integer> que = new ArrayDeque<Integer>();  
    
    // initialize window  
    int i=0;  
    while (i<w) {  
      while (!que.isEmpty() && nums[que.getLast()] <= nums[i]) {  
        que.removeLast();  
      }  
      que.addLast(i++);  
    }  
    
    // sliding window  
    int[] max = new int[nums.length - w + 1];  
    max[i-w] = nums[que.getFirst()];  
    while (i<nums.length) {  
      // add new element  
      while (!que.isEmpty() && nums[que.getLast()] <= nums[i]) {  
        que.removeLast();  
      }  
      que.addLast(i);  
      // remove old element if still in que  
      if (!que.isEmpty() && i-w >= que.getFirst()) {  
        que.removeFirst();  
      }  
      // get maximal  
      ++i;  
      max[i-w] = nums[que.getFirst()];  
    }  
    
    return max;  
  }  

}
