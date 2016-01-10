package tree;

import java.util.LinkedList;
import java.util.Queue;



public class MinimumDepthBT {
  
  public static class TreeNode {
    public int item;
    public TreeNode left;
    public TreeNode right;

    private TreeNode(int item) {
      this.item = item;

    }

  }
  
  // recursion O(N)
  public int minDepth(TreeNode root) {
    if (root == null)
      return 0;

    if (root.left== null && root.right == null) {
      return 1;
    }

    if (root.left== null) {
      return minDepth(root.right) + 1;
    }

    if (root.right == null) {
      return minDepth(root.left) + 1;
    }

    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

  }

  /*
   * A Better Solution is to do Level Order Traversal. While doing traversal, returns depth of the
   * first encountered leaf node.
   */
  public int minDepthQueue(TreeNode root) {
    if (root == null)  return 0;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    LinkedList<Integer> depths = new LinkedList<Integer>();

    queue.add(root);
    depths.add(1);

    while (!queue.isEmpty()) {
      TreeNode current = queue.remove();

      int currentDepth = depths.remove();  

      if (current.left!= null) {
        queue.add(current.left);
        depths.add(currentDepth+1);
      }

      if (current.right != null) {
        queue.add(current.right);
        depths.add(currentDepth+1);
      }
      if (current.left== null && current.right == null) {
        return currentDepth;
      }

    }
    return 0;
  }

  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.left =new TreeNode(2);
    root.right =new TreeNode(3);
    root.left.left =new TreeNode(4);
    root.left.right =new TreeNode(5);

    MinimumDepthBT min = new MinimumDepthBT();
    int result = min.minDepthQueue(root);
    System.out.println(result);

  }

}
