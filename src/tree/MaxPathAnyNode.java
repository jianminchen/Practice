package tree;

import tree.MinimumDepthBT.TreeNode;

public class MaxPathAnyNode {

  

  /*
   * For each node there can be four ways that the max path goes through the node:
    1. Node only
    2. Max path through Left Child + Node
    3. Max path through Right Child + Node
    4. Max path through Left Child + Node + Max path through Right Child
   */
  public int maxPathSum(TreeNode root) {
    
    if(root == null) return 0;
    
    int max =Integer.MIN_VALUE;
    int res = calculateMaxSum(root, max);
    return res;
  }
  
  private int calculateMaxSum(TreeNode root, int max) {

    
    if (root == null) return 0;
    int leftSum = 0;
    int rightSum =0;
    
    if(root.left != null) {
       leftSum = calculateMaxSum(root.left, max);
    }
    

    if(root.right != null) {
       rightSum = calculateMaxSum(root.right, max);
    }
       
    int currentMax = Math.max(root.item, Math.max(root.item+rightSum, root.item+leftSum));
    
    max = Math.max(currentMax, root.item+leftSum+rightSum);
    
    return max;
  }

  public static void main(String[] args) {

  }
}
