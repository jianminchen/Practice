package linkedList;

import linkedList.Node;

public class MthNode {

  public static void main(String[] args) {

    //Preparing some linked list structure
    Node head = new Node(5);
    head.next = new Node(4);
    head.next.next = new Node(3);
    head.next.next.next = new Node(2);
    head.next.next.next.next = new Node(1);
    
    MthNode mth = new MthNode();
    int m =3;
    Node mthNode =  mth.findNode(head, m);
    
    System.out.println(mthNode.item);
    
  }

  private Node findNode(Node head, int m) {
    
    if(head == null) {
      return null;
    }
    
    Node temp = head; 
    Node mthNode = head;
    int count =0;
    
    while (temp != null) {
      count++;
      
      if(m - count > 0) {
        mthNode = mthNode.next;
      }
      temp = temp.next;
    }
    
    if (count >= m) {
      return mthNode; 
    }
    return head;
    
  }

}
