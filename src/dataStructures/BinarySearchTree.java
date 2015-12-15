package dataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

  private Node root;



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

  public BinarySearchTree() {
    root = null;
  }

  public boolean isEmpty() {
    return root == null;
  }



  private void insertNode(int item) {

    // If it is an empty tree, insert the value as the root
    if (root == null) {
      root = new Node(item);
      root.item = item;
    } else {
      insert(root, item);
    }
  }

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
      if (current.left == null && current.middle == null && current.right == null) {
        current = null;
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


  public Node find(int num) {
    Node toFind = null;
    if (isEmpty()) {
      System.out.println("Empty tree");
    } else {
      toFind = findNode(root, num);
    }
    return toFind;
  }

  private Node findNode(Node current, int value) {

    // null check
    if (current == null) {
      System.out.println("No such Element = " + value);
      return current;
    }


    // if the value is greater than root then we are trying to find an item
    // from right tree
    else if (value > current.item) {
      current.right = findNode(current.right, value);
    }

    // if the value is smaller than root then we are trying to find an item
    // from left tree
    else if (value < current.item) {
      current.left = findNode(current.left, value);
    }
    return current;
  }


  public void preOrder(Node current) {

    if (current != null) {

      System.out.println("Node (value) = " + current.item);
      preOrder(current.left);
      preOrder(current.right);
    }

  }

  public void inorder(Node current) {

    if (current != null) {
      inorder(current.left);
      System.out.println("Node (value) = " + current.item);
      inorder(current.right);
    }

  }

  public void postOrder(Node current) {

    if (current != null) {
      postOrder(current.left);
      postOrder(current.right);
      System.out.println("Node (value) = " + current.item);

    }

  }
  // using queue
  public void levelOrder(Node root) {

    Queue<Node> parentQueue = new LinkedList<Node>();
    parentQueue.add(root);
    
    while (!parentQueue.isEmpty()) {
      Node current = parentQueue.poll();
      System.out.println("Node (value) = " + current.item);
      if(current.left != null){
        parentQueue.add(current.left);
      }
      if(current.right != null){
        parentQueue.add(current.right);
      }

    }

  }

  public int height() {

    int wid = 0;
    if (isEmpty()) {
      System.out.println("Empty tree");
    } else {
      wid = findheight(root);
    }
    return wid;


  }

  private int findheight(Node current) {

    if (current == null) {
      return -1;
    }

    else {
      return 1 + Math.max(findheight(current.left), findheight(current.right));
    }
  }


  public int width() {

    int max = 0;
    if (isEmpty()) {
      System.out.println("Empty tree");
    } else {
      for (int k = 0; k <= height(); k++) {
        int tmp = width(root, k);
        if (tmp > max)
          max = tmp;
      }
    }
    return max;
  }

  // returns the number of node on a given level
  public int width(Node p, int depth) {
    if (p == null)
      return 0;
    else if (depth == 0)
      return 1;
    else
      return width(p.left, depth - 1) + width(p.right, depth - 1);
  }



  public int diameter() {

    int dm = 0;
    if (isEmpty()) {
      System.out.println("Empty tree");
    } else {
      dm = diameter(root);
    }
    return dm;
  }

  private int diameter(Node p) {

    if (p == null)
      return 0;
    else {
      int lheight = findheight(p.left);
      int rheight = findheight(p.right);


      return Math.max(lheight + rheight + 1, Math.max(diameter(p.left), diameter(p.right)));
    }
  }

  public int countLeaves() {

    int leaves = 0;
    if (isEmpty()) {
      System.out.println("Empty tree");
    } else {
      leaves = count(root);
    }
    return leaves;

  }


  private int count(Node p) {

    if (p == null)
      return 0;
    else if (p.left == null && p.right == null)
      return 1;
    else
      return count(p.left) + count(p.right);
  }

  public static void main(String[] args) {

  }

}
