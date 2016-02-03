package arrays;

import java.util.ArrayList;

public class MaxArraySubsetSum {

  public static void main(String[] args) {

    MaxArraySubsetSum ap = new MaxArraySubsetSum();
    int[] temp = {1,-4,-5,-6,-7,-7,-3,0,20,10,13};
     ap.findSubset(temp);
     int[] temp1 = {1,-4,-5,-6,-7,-7,-3,0,20,10,13};

  }

  //Time O(N)
  private void findSubset(int[] temp) {
        
    if (temp.length ==0) return;
    
    int n = temp.length;
    int cur= temp[0];
    int max = temp[0];
    int x= 1, y = 1;
    for (int i =1;i < n; i++) {
    /*  cur = temp[i] + cur;
      if (temp[i] > cur) {
        cur = temp[i];
        x = i+1;
      }
      
      if (cur > max) {
        max  =cur;
        y = i+1;
      }*/
     
      cur = Math.max(cur+temp[i], temp[i]);
      max = Math.max(max, cur);
    }
        
     System.out.println("Sum = "+max);
   // System.out.println("Sum = "+max+" x = "+x+" y = "+y);
  }

  
  private void flip(int[] temp) {
    
    if (temp.length ==0) return;
    
   
    
    int n = temp.length;
    for (int i =0;i < n; i++) {
      
      if (temp[i] == 0) {
        temp[i] = 1;
      }else {
        temp[i] = -1;
      }
    }
    int cur= temp[0];
    int max = temp[0];
    int x= 1, y = 1;
    for (int i =1;i < n; i++) {
      cur = temp[i] + cur;
      if (temp[i] > cur) {
        cur = temp[i];
        x = i+1;
      }
      
      if (cur > max) {
        max  =cur;
        y = i+1;
      }
     
     
    }
        
    System.out.println("Sum = "+max+" x = "+x+" y = "+y);
  
  }
}
