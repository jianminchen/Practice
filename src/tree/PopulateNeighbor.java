package tree;

public class PopulateNeighbor {



private static class TreeNode {
  
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode next;

  TreeNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
    this.next = null;
}
}

//recursive 
private void populateNextPointer(TreeNode root) {
 
  if (root == null) return;
  
  if (root.left != null) {
    root.left.next = root.right;
  }
  
  if (root.right!=null) {
    root.right.next = (root.next != null)?root.next.left : null;
  }
  populateNextPointer(root.left);
  populateNextPointer(root.right);  
}


}