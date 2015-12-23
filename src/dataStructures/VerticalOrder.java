package dataStructures;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Shalini
 *
 */
public class VerticalOrder {

  public static TreeMap<Integer, ArrayList> veriticalOrder = new TreeMap<Integer, ArrayList>();
  Node root;
  ArrayList<Integer> nodeList;

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

  private void printResult(TreeMap<Integer, ArrayList> veriticalOrder2) {

    Set<Integer> keySet = veriticalOrder2.keySet();
    for (int i : keySet) {
      System.out.println(veriticalOrder2.get(i));
    }
  }


  private int findVerticalOrder(Node current, int level, boolean flag) {

    if (current != null) {
      level = findVerticalOrder(current.right, ++level, true);

      if (veriticalOrder.get(level) != null) {
        ArrayList temp = veriticalOrder.get(level);
        temp.add(current.item);
        veriticalOrder.put(level, temp);
      } else {
        nodeList = new ArrayList<Integer>();
        nodeList.add(current.item);
        veriticalOrder.put(level, nodeList);
      }
      findVerticalOrder(current.left, --level, false);
      return level;
    } else if (flag) {
      return --level;
    } else {
      return ++level;
    }
  }

  public static void main(String[] args) {

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);


    VerticalOrder vOrder = new VerticalOrder();
    vOrder.findVerticalOrder(root, 0, false);
    vOrder.printResult(veriticalOrder);
  }
}
