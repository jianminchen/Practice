package tree;

import tree.TreeNode;
/*
 * When you do the inorder tra­ver­sal of a binary tree, the neigh­bors of given node are called
 * Predecessor(next small) and Successor (next big).
 * 
 */
public class SuccesorAndPredessor {

  private static int successor, predecessor;
  

  public static void main(String[] args) {

    
    TreeNode root = new TreeNode(20);
    root.setLeft(new TreeNode(10));
    root.setRight( new TreeNode(30));
    root.getLeft().setLeft(new TreeNode(5));
    root.getLeft().getLeft().setRight( new TreeNode(7));
    root.getLeft().setRight( new TreeNode(15));
    root.getRight().setLeft(new TreeNode(25));
    root.getRight().setRight( new TreeNode(35));
    root.getLeft().getRight().setLeft(new TreeNode(13));
    root.getLeft().getRight().setRight( new TreeNode(18));
    
    SuccesorAndPredessor sp = new SuccesorAndPredessor();
    
    TreeNode Succesor = sp.findSuccessor(root, 10);
    TreeNode Predecessor = sp.findPredecessor(root, 10);

    System.out.println("Inorder Successor of 10 is : " + Succesor.getItem() );
System.out.println("Inorder Predecessor of 10 is : " + Predecessor.getItem());
    
  }


  private  TreeNode findPredecessor(TreeNode root, int value) {
    
    
    TreeNode current =  findTreeNode(root,value);
    
    if(current == null) return null;
//If a node has right subtree then find the minimum in that right sub tree
    if(current.getLeft() != null) {
      return findMax(current.getLeft());
    }
    
    else {
      TreeNode Predecessor = null;
      TreeNode parent = root;
      
      while (parent != current) {
        if( current.getItem() > parent.getItem()) {
          Predecessor = parent;
          parent = parent.getRight();
        } else {
          parent = parent.getLeft();
        }
      }
      return Predecessor;
      
    }
  }


  private  TreeNode findSuccessor(TreeNode root, int value) {
    
    
    TreeNode current =  findTreeNode(root,value);

    
    if(current == null) return null;

    //If a node has right subtree then find the minimum in that right sub tree
    if(current.getRight() != null) {
      TreeNode temp = findMin(current.getRight());
      return temp;
    }
    
    else {
      TreeNode successor = null;
      TreeNode parent = root;
      
      while (parent != current) {
        if( current.getItem() < parent.getItem()) {
          successor = parent;
          parent = parent.getLeft();
        } else {
          parent = parent.getRight();
        }
      }
      return successor;
      
    }

  }
  
  private TreeNode findMin(TreeNode node) {
    while (node.getLeft() != null) {
      node = node.getLeft();
    }
    return node;
  }

  
  private TreeNode findMax(TreeNode node) {
    while (node.getRight() != null) {
      node = node.getRight();
    }
    return node;
  }

  private TreeNode findTreeNode(TreeNode current, int value) {

    // null check
    if (current == null) {
      System.out.println("No such Element = " + value);
      return current;
    }


    // if the value is greater than root then we are trying to find an item
    // from right tree
    else if (value > current.getItem()) {
      return findTreeNode(current.getRight(), value);
    }

    // if the value is smaller than root then we are trying to find an item
    // from left tree
    else if (value < current.getItem()) {
     return findTreeNode(current.getLeft(), value);
    }
    return current;
  }


}
