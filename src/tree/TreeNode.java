package tree;

public class TreeNode {
  
    private int val;
    private TreeNode left;
    private TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

    public TreeNode getLeft() {
      return left;
    }

    public void setLeft(TreeNode left) {
      this.left = left;
    }

    public TreeNode getRight() {
      return right;
    }

    public void setRight(TreeNode right) {
      this.right = right;
    }
    
    public int getItem() {
      return val;
    }

    public void setItem(int val) {
      this.val = val;
    }
  }

