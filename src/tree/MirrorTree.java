package tree;

import java.util.Stack;

import tree.TreeNode;

public class MirrorTree {

  // Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

  public boolean isSymmetric(TreeNode root) {

    if (root == null)
      return true;

    return isSymmetricTree(root.getLeft(), root.getRight());

  }

  // recursion Time and Space O(N)
  private boolean isSymmetricTree(TreeNode left, TreeNode right) {

    if (left == null && right == null) {
      return true;
    } else if (left == null || right == null) {
      return false;
    }

    if (left.getItem() != right.getItem()) {
      return false;
    }

    if (!isSymmetricTree(left.getLeft(), right.getRight())) {
      return false;
    }

    if (!isSymmetricTree(right.getLeft(), left.getRight())) {
      return false;
    }
    return true;
  }



  //  Time and Space O(N)
  private boolean isSymmetricTreeIterative(TreeNode root) {

    if (root == null)
      return true;

    Stack<TreeNode> left = new Stack<TreeNode>();
    Stack<TreeNode> right = new Stack<TreeNode>();

    left.push(root.getLeft());
    right.push(root.getRight());

    while (!left.isEmpty() && !right.isEmpty()) {
      TreeNode ltemp = left.pop();
      TreeNode rtemp = right.pop();

      if (ltemp == null && rtemp == null) {
        continue;
      } else if (ltemp == null || rtemp == null) {
        return false;
      }

      if (ltemp.getItem() != rtemp.getItem()) {
        return false;
      }

      left.push(ltemp.getLeft());
      left.push(ltemp.getRight());
      right.push(rtemp.getRight());
      right.push(rtemp.getLeft());
    }

    if (!left.isEmpty())
      return false;
    if (!right.isEmpty())
      return false;

    return true;


  }



  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
