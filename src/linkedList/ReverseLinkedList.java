package linkedList;


public class ReverseLinkedList {

  private static class Node {
    
    private int item;
    private Node next;
    
    private Node(int item) {
     this.item = item; 
     this.next = null;
  }
    @Override
    public String toString() {
 
        String data = "";
        Node current = this;
        do {
            data += current.item + ",";
            current = current.next;
        } while (current != null);
 
        return data;
    }
  }
  
  //recursion O(N) space and time
  public static Node recursiveReverse (Node head) {
    
    //base condition
    if (head == null || head.next == null) {
      return head;
    }
    
    Node second = head.next;
    head.next = null;
    
    Node rest = recursiveReverse(second);
    second.next = head;
    
    return rest;
  }
  
  //iterative O(1) space and  O(N)time
  public static Node iterativeReverse (Node head) {
    
    //base condition
    if (head == null || head.next == null) {
      return head;
    }
    
    Node previous = head;
    Node current = head.next;
    head.next = null;
    
    while (previous !=null && current != null) {
      Node nextNode = current.next;
      current.next =  previous;
      
      //reset
      previous = current;
      if(nextNode != null) {
        current = nextNode;
      } else {
        break;
      }
    }
    return current;
  }
  
  
  public static void main(String[] args) {
    
  //Preparing some linked list structure
    Node head = new Node(5);
    head.next = new Node(4);
    head.next.next = new Node(3);
    head.next.next.next = new Node(2);
    head.next.next.next.next = new Node(1);
    
    System.out.println("Original Linked List: " + head.toString());
    
    //recursively reverse and print
    head = recursiveReverse(head);
    System.out.println("Recursively Reversed List: "
            + head.toString());
    
    //iteratively reverse and print
    head = iterativeReverse(head);
    System.out.println("Iteratively Recursed to Original: "
            + head.toString());
  }

}
