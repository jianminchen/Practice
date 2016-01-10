package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up
 * all the values along the path equals the given sum.
 */
public class PathSum {
  
  

  public static class TreeNode {

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
  }
  
  // recursion O(N)
  public boolean hasPathSum(TreeNode root, int sum) {
    if(root == null) return false;
    
    if (root.val == sum && root.getLeft() == null && root.getRight() == null) return true;
    
    return hasPathSum(root.getRight(), sum - root.val) || hasPathSum(root.getLeft(), sum - root.val); 
    
  }
  
  
  //using queue
  public boolean hasPathSumQueue(TreeNode root, int sum) {
    if(root == null) return false;
    

    Queue<TreeNode> nodes = new LinkedList<TreeNode>();
    LinkedList<Integer> values = new LinkedList<Integer>();
    
    nodes.add(root);
    values.add(root.val);
    
    while (!nodes.isEmpty()) {
      
      TreeNode current = nodes.poll();
      int subSum = values.poll();
      
      if (subSum == sum && current.getLeft() == null && current.getRight() == null) return true;
      
      
      if(current.getLeft() != null) {
        nodes.add(current.getLeft());
        values.add(subSum+current.getLeft().val);
      }

      if(current.getRight() != null) {
        nodes.add(current.getRight());
        values.add(subSum+current.getRight().val);
      }
    }
    
   return false;

  }
  
  
  public static List<List<Integer>> pathSum(TreeNode root, int sum) {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();    

    if (root == null) return result;
    
    List<Integer> list = new ArrayList<Integer>();
    list.add(root.val);
    dfs(root, sum - root.val, result, list);
    
    return result;        
  }
  
  private static void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list) {
        
    if(0 == sum && root.getRight() == null && root.getLeft() == null) {
      List<Integer> temp = new ArrayList<Integer>();
      temp.addAll(list);
      result.add(temp);
           
    }
    //search path of left node
    if(root.getLeft() != null){
      //  System.out.println(root.left.val);
        list.add(root.getLeft().val);
        dfs(root.getLeft(), sum-root.getLeft().val, result, list);
        list.remove(list.size()-1);
    }
 
    //search path of right node
    if(root.getRight()!=null){
        list.add(root.getRight().val);
       // System.out.println(root.right.val);
        dfs(root.getRight(), sum-root.getRight().val, result, list);
        list.remove(list.size()-1);
    }
    
  }


  public static void main(String[] args) {

    TreeNode root = new TreeNode(5);
    root.setLeft(new TreeNode(4));
    root.setRight(new TreeNode(8));
    root.left.setLeft(new TreeNode(11));
    root.left.left.setLeft(new TreeNode(7));
    root.getLeft().getLeft().setRight(new TreeNode(2));

    root.getRight().setLeft(new TreeNode(13));
    root.right.setRight(new TreeNode(4));
    root.getRight().getRight().setLeft(new TreeNode(5));
    root.right.right.setRight(new TreeNode(1));

    for ( List<Integer> temp : pathSum(root,22)) {
      for ( int i : temp) {
        System.out.print(i + " ");
      }   
      System.out.println();

      }
  }

}
