package linkedList;

import java.util.Stack;

import linkedList.Node;

public class Palindrome {

  private boolean isPalidrome(Node<Character> head) {

    Node firstHalf = head;

    Node middle = getMiddle(head);
  //  System.out.println(middle.item);
    
    middle.next = reverse(middle.next);
    Node secondHalf = middle.next;

    while (secondHalf != null) {
      
      if(!secondHalf.item.equals(firstHalf.item)) {
        return false;
      }
      firstHalf = firstHalf.next;
      secondHalf = secondHalf.next;
      
    }

    return true;
    }


    private Node reverse(Node node) {
    
      Node current = node;
      Node next = null;
      Node prev = null;
      
      while(current != null){
          next = current.next;
          current.next = prev;
          prev = current;
          current = next;
      }
   //   System.out.println(prev.toString());

      return prev;
  }


    // Time = O(N) space = O(1)
    private  Node getMiddle(Node head) {
      if (head == null)
        return null;

      int count  = 0;

      Node fast = head;
      Node slow = head;
      int i = 0;

      while (fast.next != null) {

        if (i == 0) {

          // increment twice pointer
          fast = fast.next;
          i = 1;
        }
        else if (i == 1) {

          // increment both pointer
          fast = fast.next;
          slow = slow.next;        
          i = 0;
        }
        count++;
      }
      
      return slow;

    }


  public static void main(String[] args) {
    // Preparing some linked list structure
    Node<Character> head = new Node<Character>('a');
    head.next = new Node('b');
    head.next.next = new Node('c');
    head.next.next.next = new Node('b');
    head.next.next.next.next = new Node('a');



    Palindrome check = new Palindrome();

    boolean flag = check.isPalidrome(head);

    System.out.println(flag);
  }



}
