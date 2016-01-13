package tree;

import tree.TreeNode;

public class BalancedBinaryTree {

 // Given a binary tree, determine if it is height-balanced.

  public boolean isBalanced(TreeNode root) {
    if(checkHeight(root) == -1) {
      return false;  
    } else {
    return true;
    }
  }

  //O(N) time and O(H) space
  private int checkHeight(TreeNode root) {
    if(root == null) return 0;
    
    //check left is balanced
    int left = checkHeight(root.getLeft());
    if (left == -1) {
      return -1;
    }
    
    int right = checkHeight(root.getRight());
    if (right == -1) {
      return -1;
    }
    
    int height = Math.abs(left - right);
    if(height > 1) {
      return -1;
    } else {
      return Math.max(right, left) +1;
    }
}

  public static void main(String[] args) {

  }

}
