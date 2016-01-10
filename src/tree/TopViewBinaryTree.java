package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;


public class TopViewBinaryTree {


  Queue<QueuePack> queue = new LinkedList<QueuePack>();
  public static TreeMap<Integer, Integer> veriticalOrder = new TreeMap<Integer, Integer>();

  Node root;

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

  private static class QueuePack {

    private int level;
    private Node current;

    private QueuePack(Node current,int level) {
      this.current = current;
      this.level = level;

   
    }
  }


  private void findTopView(Node current, int level) {

    queue.add(new QueuePack(current,level));
    while (!queue.isEmpty()) {
      
      QueuePack qp = queue.remove();
      Node node = qp.current;
      int lvl = qp.level;
      
      if (veriticalOrder.containsKey(lvl)) {
        //don't do anything we just need first element in each level both left and right side
      } else {
        veriticalOrder.put(lvl, node.item);
      }
    
      // add the left and right children of visiting nodes to the queue
      if (node.left != null) {
          queue.add(new QueuePack( node.left, lvl - 1));
      }
      if (node.right != null) {
          queue.add(new QueuePack(node.right, lvl + 1));
      }
    
    }
    
    Set<Integer> keys = veriticalOrder.keySet();
    for (int i : keys) {
      System.out.print(veriticalOrder.get(i) + " ");
    }
    
  }

  public static void main(String[] args) {

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.left.left = new Node(8);
    root.left.left.right = new Node(9);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);



    TopViewBinaryTree topOrder = new TopViewBinaryTree();
    topOrder.findTopView(root, 0);
  }
}
