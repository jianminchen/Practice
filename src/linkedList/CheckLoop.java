package linkedList;

import linkedList.Node;

public class CheckLoop {

  public static void main(String[] args) {

  //Preparing some linked list structure
    Node head = new Node(5);
    head.next = new Node(4);
    head.next.next = new Node(3);
    head.next.next.next = new Node(2);
    head.next.next.next.next = new Node(1);
  
    /*Create loop for testing */
    head.next.next.next.next = head;
    
    CheckLoop loop = new CheckLoop();
    loop.detectLoop(head);
    boolean flag = loop.detectLoop(head);

    System.out.println(flag);
  }

  
  //Time O(N) space O(1)
  private boolean detectLoop(Node head) {
  
    Node slow = head, fast = head;
    while (slow != null && fast != null && fast.next != null) {
         if (slow == fast) {
           // System.out.println("Found loop");
            return true;
        }
         slow = slow.next;
         fast = fast.next.next;
       
    }
    return false;
  }

}
