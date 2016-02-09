package tree;

import java.util.Stack;

/*
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * */
 
public class VerifyPreOrderBST {

  public static void main(String[] args) {
    
    VerifyPreOrderBST chk = new VerifyPreOrderBST();
    int[] num = {4,2,1,3,6,5,7};
    System.out.println(chk.verifyPreOrderHelper(num));

  }
  
  //using stack O(N) time and space
  public boolean verifyPreOrderHelper(int[] pre) {
    if(pre == null || pre.length <= 1) return true;
    
    Stack<Integer> stack = new Stack<Integer>();
    int max = Integer.MIN_VALUE;    
    
    for (int num :pre) {
      
      if (num < max) {
        return false;
      }
      while (!stack.isEmpty() && num > stack.peek()) {
        max = stack.pop();
      }
      stack.push(num);
    }
    return true;
  }

//using O(N) time and O(1)space
  public boolean verifyPreOrder(int[] pre) {
    if(pre == null || pre.length <= 1) return true;
    
    int max = Integer.MIN_VALUE; 
    int i =-1;
    
    for (int num :pre) {
      
      if (num < max) {
        return false;
      }
      while (i >= 0 && num > pre[i]) {
        max = pre[i];
        i--;
      }
      i++;
      pre[i] = num;
    }
    return true;
  }
}
