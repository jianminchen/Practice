package dataStructures;
import java.util.NoSuchElementException;

public class BinaryTreeInt {
  private Node root; // root node

  /**
   * Initializes an empty BinaryTRee.
   */
  public BinaryTreeInt() {
    root = null;
  }

  private static class Node {
    private int item;
    private Node left;
    private Node right;

    private Node(int item) {
      this.item = item;
      left = null;
      right = null;
    }

  }
  
  public int findNode(Node current, int value) {

    // null check
    if (current == null) {
      System.out.println("No such Element = " + value);
      return 0;
    }


    // if the value is greater than root then we are trying to find an item
    // from right tree
    else if (value > current.item) {
       findNode(current.right, value);
       return 1;
    }

    // if the value is smaller than root then we are trying to find an item
    // from left tree
    else if (value < current.item) {
       findNode(current.left, value);
       return 1;
    }
    return 0;
  }


  public boolean isEmpty() {
    return root == null;
  }

  public void insert(int item) {

    if (isEmpty()) {
      root = new Node(item);
    } else {
      insertNode(root, item);
    }
  }

  private void insertNode(Node current, int value) {

    if (current.item > value) {
      if (current.left != null) {
        insertNode(current.left, value);
      } else {
        current.left = new Node(value);
      }

    } else if ((current.item < value)) {
      if (current.right != null) {
        insertNode(current.right, value);
      } else {
        current.right = new Node(value);
      }

    }

  }

  public void printTree(Node current) {

    if (current != null) {

      System.out.println("Node (value) = " + current.item);
      printTree(current.left);
      printTree(current.right);
    }
  }


  public void findLCA(int val1, int val2) {

    if (isEmpty()) {
      System.out.println("Empty tree");
    } else {
      Node lca = findLowestCommonAncestor(root, val1, val2);

      if (lca == null) {
        System.out.println("Items may not be present");
      } else {
        System.out.println("LCA for "+ val1+ " and "+ val2 +" is = "+lca.item);
      }
    }
  }

  // Binary Tree LCA not BST
  private Node findLowestCommonAncestor(Node root, int value1, int value2) {

    Node leftLCA = null;
    Node rightLCA = null;

    if (root == null) {
      return null;
    }

    else {
      int value = root.item;

      if (value == value1 || value == value2) {
        return root;

      }

      else {

        leftLCA = findLowestCommonAncestor(root.left, value1, value2);
        rightLCA = findLowestCommonAncestor(root.right, value1, value2);

        if (leftLCA != null && rightLCA != null) {
          return root;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
      }
    }

  }

  public int isPresent (Node root, int val) {
    
  int result = 0;
  
  // null check 
  if (root == null) {
        result = 0;   
  } 
  
  // if value is greater than root 
  else if (val > root.item) {
      result = isPresent(root.right, val);
  }
  
  // if value is lesser than root
  else if (val < root.item) {
      result = isPresent(root.left, val);
  }
  
  else if (val == root.item) {
      result = 1;
  } 
  
  return result;
  
  }
  public Node findLCABST( Node root, int value1, int value2 ){
    while( root != null ){
      int value = root.item;

      if( value > value1 && value > value2 ){
        root = root.left;
      } else if( value < value1 && value < value2 ){
        root = root.right;
      } else {
        return root;
      }
    }
    return null; // only if empty tree
  }

  public static void main(String[] args) {
    BinaryTreeInt tree = new BinaryTreeInt();
    tree.insert(5);
    tree.insert(4);
    tree.insert(9);
    tree.insert(7);
    tree.insert(2);
    System.out.println(" ********** After Insertion **********");
    tree.printTree(tree.root);
    tree.findLCA(4,9);
    tree.findLCA(5,9);
    tree.findLCA(4,2);
    
    System.out.println(tree.findNode(tree.root,2));
    System.out.println(tree.findNode(tree.root,112));

    System.out.println("findLCABST "+tree.findLCABST(tree.root, 4, 2).item);

  }

}
