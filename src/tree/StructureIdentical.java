package tree;

public class StructureIdentical {

  private static class TreeNode {

    private int item;
    private TreeNode left;
    private TreeNode right;

    private TreeNode(int item) {
      this.item = item;
   
    }
  }
  
  private boolean isIdenticalTrees(TreeNode root1, TreeNode root2) {
    
    if (root1 == null && root2 == null) {
      return true;
    }
    
    if (root1 != null && root2 != null) {
      
      return (root1.item == root2.item 
          && isIdenticalTrees(root1.left, root2.left) 
          && isIdenticalTrees(root1.right, root2.right));
      
    }
    return false;
  }
  
  
  public static void main(String[] args) {

    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);
    root1.left.left = new TreeNode(4);
    root1.left.right = new TreeNode(5);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(3);
    root2.left.left = new TreeNode(4);
    root2.left.right = new TreeNode(5);

    StructureIdentical check = new StructureIdentical();

    if (check.isIdenticalTrees(root1, root2)) {
        System.out.println("Both trees are identical");
    } else {
        System.out.println("Trees are not identical");
    }
  }

 

}
