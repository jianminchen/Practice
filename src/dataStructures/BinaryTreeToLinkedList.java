package dataStructures;

import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreeToLinkedList {
  static LinkedList<TreeNode> list = new LinkedList<TreeNode>();


  private static class TreeNode {
    private int item;
    private TreeNode left;
    private TreeNode right;

    private TreeNode(int item) {
      this.item = item;
    }


  }

  // recursion : returns the last node in the list
  public TreeNode flatten(TreeNode root) {
    if (root == null)
      return root;
    TreeNode tempRight = root.right;
    // take the left tree and attach to right
    if (root.left != null) {
      root.right = root.left;
      root.left = null;
      root = flatten(root.right);
    }
    // append the original right tree to new right
    if (tempRight != null) {
      root.right = tempRight;
      root = flatten(root.right);
    }
    return root;
  }

  // Non recursion : This algorithm runs in time O(n) and uses O(n) extra spaces for the stack.
  public void flattenStack(TreeNode root) {
    if (root == null)
      return;
    TreeNode current = root;
    Stack<TreeNode> stack = new Stack<TreeNode>();

    while (current != null) {

      while (current.left != null) {
        if (current.right != null) {
          stack.push(current.right);
        }
        current.right = current.left;
        current.left = null;
      }

      if (!stack.isEmpty() && current.right == null) {
        current.right = stack.pop();
      }

      current = current.right;
    }

  }

  // Non recursion : This algorithm runs in time O(n) and uses O(1) space .
  // find the right-most leaf of the current left subtree, and append the right subtree there

  public void flattenNoStack(TreeNode root) {
    if (root == null)
      return;
    TreeNode current = root;

    while (current != null) {

      if (current.left != null) {

        TreeNode temp = current.left;

        while (temp.right != null) {
          temp = temp.right;
        }
        temp.right = current.right;
        current.right = current.left;
        current.left = null;
      }
      current = current.right;
    }

  }
  
  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(6);
    BinaryTreeToLinkedList bList = new BinaryTreeToLinkedList();
    bList.flattenNoStack(root);
  }

}
