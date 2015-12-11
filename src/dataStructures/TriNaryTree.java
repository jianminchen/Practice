package dataStructures;


import java.util.NoSuchElementException;

/**
 * @author Shalini
 * 
 * This program is an API for inserting and deleting a node in a tri-nary tree data structure.
 * TriNaryTree is much like a binary tree but with three child nodes for each parent instead of two -- 
 * with the left node being values less than the parent, 
 * the right node values greater than the parent, and the middle nodes values equal to the parent.
 * 
 */
public class TriNaryTree {

  private Node root; // root node

  /**
   * Initializes an empty TriNaryTree.
   */
  public TriNaryTree() {
    root = null;
  }

  private static class Node {
    private int item;
    private Node left;
    private Node right;
    private Node middle;

    private Node(int item) {
      this.item = item;
      left = null;
      right = null;
      middle = null;
    }

  }

  /**
   * Checks if the TriNaryTree is empty
   * 
   * @return true is the TriNaryTree is empty
   */
  public boolean isEmpty() {
    return root == null;
  }

  /**
   * Inserts a node into the TriNaryTree
   * 
   * @param item
   *          value to be inserted
   */
  private void insertNode(int item) {

    // If it is an empty tree, insert the value as the root
    if (root == null) {
      root = new Node(item);
      root.item = item;
    } else {
      insert(root, item);
    }
  }

  /**
   * Insert a node into the TriNaryTree based on the value
   * 
   * @param currentNode
   *          Current root node
   * @param item
   *          value to be inserted into the tree
   */
  private void insert(Node currentNode, int item) {

    // right child
    if (item > currentNode.item) {
      if (currentNode.right != null) {
        insert(currentNode.right, item);
      } else {
        currentNode.right = new Node(item);
      }
    }

    // left child
    else if (item < currentNode.item) {
      if (currentNode.left != null) {
        insert(currentNode.left, item);
      } else {
        currentNode.left = new Node(item);
      }
    }

    // middle node
    else {
      if (currentNode.middle != null) {
        insert(currentNode.middle, item);
      } else {
        currentNode.middle = new Node(item);
      }
    }

  }

  public void deleteNode(int value) {

    // check whether we are trying to delete from an empty tree
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot delete from an Empty tree");
    } else {
      delete(root, value);
    }
  }

  private Node delete(Node current, int value) {

    // null check
    if (current == null) {
      System.out.println("No such Element = " + value);
      return current;
    }

    // if the value is greater than root then we are trying to delete an item
    // from right tree
    else if (value > current.item) {
      current.right = delete(current.right, value);
    }

    // if the value is smaller than root then we are trying to delete an item
    // from left tree
    else if (value < current.item) {
      current.left = delete(current.left, value);
    }

    else {

      // leaf node
      if (current.left == null && current.middle == null
          && current.right == null) {
        current = null;
      }

      // delete the bottom most node if the value occur more than once
      else if (current.middle != null) {
        current.middle = delete(current.middle, value);
      }

      else {

        // delete the node with two child
        if (current.right != null && current.left != null) {

          int min = findMin(current.right);
          current.item = min;
          current.right = delete(current.right, min);
        }

        // delete the node with only one child(right)
        else if (current.left == null) {
          Node newNode = current.right;
          current = null;
          return newNode;
        }

        // delete the node with only one child(right)
        else if (current.right == null) {
          Node newNode = current.left;
          current = null;
          return newNode;
        }
      }
    }

    return current;

  }

  private int findMin(Node node) {
    while (node.left != null) {
      node = node.left;
    }
    return node.item;
  }

  public void printTree(Node current) {

    if (current != null) {

      System.out.println("Node (value) = " + current.item);
      printTree(current.left);
      printTree(current.middle);
      printTree(current.right);
    }

  }

  /**
   * @param args
   */
  public static void main(String[] args) {

    TriNaryTree tree = new TriNaryTree();
    tree.insertNode(5);
    tree.insertNode(4);
    tree.insertNode(9);
    tree.insertNode(5);
    tree.insertNode(7);
    tree.insertNode(2);
    tree.insertNode(2);
    System.out.println(" ********** After Insertion **********");
    tree.printTree(tree.root);

    tree.deleteNode(5);
    tree.deleteNode(5);
    tree.deleteNode(6);
    tree.deleteNode(4);
    
    System.out.println(" ********** After Deletion **********");
    tree.printTree(tree.root);

  }

}
