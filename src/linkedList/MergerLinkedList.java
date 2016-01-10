package linkedList;
public class MergerLinkedList {

  private static class Node {
    private int data;
    private Node next;
  }
  
  
  //O(m+n)
  public Node merge(Node headA, Node headB) {
  
   Node current = new Node();
   Node temp = current;
   
   while (headA != null && headB != null){
     
     if (headA.data <= headB.data) {
       temp.next = headA;
       headA = headA.next;
     }
     else {
       temp.next = headB;
       headB = headB.next;
     }
     temp = temp.next;
   }
   if (headA != null) {
     temp.next = headA;
   }
   else {
     temp.next = headB;
   }  
  return current.next;
  }
  public static void main(String[] args) {

    MergerLinkedList mg = new MergerLinkedList();
    
  }

}
