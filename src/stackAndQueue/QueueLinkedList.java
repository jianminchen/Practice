package stackAndQueue;
public class QueueLinkedList<Item> {

  private int N; //size of the queue
  private Node first;   //beginning of the queue
  private Node last;    //end of the queue

  
  private class Node {
    private Node next;
    private Item item;
  }
  
  
  QueueLinkedList() {
    first = null;
    last = null;
    N = 0;
  }
  
  public boolean isEmpty() {
    return first == null;
  }
  
  public int size() {
    return N;
  }
  
  public Item peek() {
    if(isEmpty()) throw new RuntimeException("Queue underflow");
    return first.item;
  }
  
  //add item at the end of the linked list
  public void enqueue(Item item) {
    
    Node newNode = new Node();
    newNode.item = item;
    newNode.next = null;

    if(isEmpty()) {
      first = newNode;
      last = newNode;
    } else {
      last.next = newNode;
    }
   N++;

  }
  
  //remove from the front of the Linked List
  public Item dequeue() {
    if(isEmpty()) throw new RuntimeException("Queue underflow");
    Item item = first.item;
    first = first.next;
    N--;
    if (isEmpty()) {
      last = null; // to avoid loitering
    }
    
    return item;

  }
  public static void main(String[] args) {

    QueueLinkedList<Integer> queue = new QueueLinkedList<Integer>();
    queue.enqueue(2);
    queue.enqueue(22);
    System.out.println(queue.size());
    queue.enqueue(3);
    queue.peek();
    queue.dequeue();
    System.out.println(queue.size());

  }

}
