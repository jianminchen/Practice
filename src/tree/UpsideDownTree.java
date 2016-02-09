package tree;

/*
 Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left
 node that shares the same parent node) or empty, flip it upside down and turn it into a tree
 where the original right nodes turned into left leaf nodes. Return the new root.
 */

public class UpsideDownTree {

  public static void main(String[] args) {

  }

  public TreeNode filpTree(TreeNode root) {

    if (root == null) {
      return root;
    } else {
      return recursive(root, null);
    }
  }

  // bottom up
  private TreeNode recursive(TreeNode p, TreeNode parent) {

    if (p == null)
      return parent;
    TreeNode root = recursive(p.left, p);
    p.left = parent == null ? parent : p.right;
    p.right = parent;

    return root;

  }

  // Top down
  private TreeNode iteratve(TreeNode root) {

    if (root == null) {
      return root;
    } else {

      TreeNode p = root, parent = null, parentRight = null;

      while (p != null) {

        TreeNode next = p.left;

        p.left = parentRight;
        parentRight = p.right;
        p.right = parent;

        parent = p;
        p = next;
      }
      return parent;
    }
  }

}
