package tree;

import tree.MinimumDepthBT.TreeNode;

public class MaxPathAnyNode {

  int max =Integer.MIN_VALUE;


  /*
   * For each node there can be four ways that the max path goes through the node:
    1. Node only
    2. Max path through Left Child + Node
    3. Max path through Right Child + Node
    4. Max path through Left Child + Node + Max path through Right Child
   */
  public int maxPathSum(TreeNode root) {
    
    if(root == null) return 0;
    
    int res = calculateMaxSum(root);
    return Math.max(res, max);
  }
  
  private int calculateMaxSum(TreeNode root) {

    
    if (root == null) return 0;
    
    int leftSum = calculateMaxSum(root.left);
    int rightSum = calculateMaxSum(root.right);
    
       
    int currentMax = Math.max(root.item, Math.max(rightSum,leftSum)+root.item);
    
    max =  Math.max(max, Math.max(currentMax, root.item+leftSum+rightSum));
    
    return currentMax;
  }

  public static void main(String[] args) {

  }
}
