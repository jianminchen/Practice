package stackAndQueue;

public class StackLinkedList<Item>  {

  private int N;
  private Node first;
  
  private class Node {
    private Node next;
    private Item item;
  }
  
  StackLinkedList() {
    first = null;
    N = 0;
  }
  
  public boolean isEmpty() {
    return N==0;   
  }
  
  public int size() {
    return N;   
  }
  
  public void push(Item item) {
    
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    N++;
    
  }
  
  public void pop() {
    if (isEmpty()) {
      System.out.println("Empty");   

    } else {       
    Item item = first.item;
    first = first.next;
    N--;    
    System.out.println(item); 
    }
  }
  
  public void peek() {

    if (isEmpty()) {
      System.out.println("Empty");   

    } else {
       System.out.println(first.item);   
    }
  }
  
  
  public static void main(String[] args) {
    
    StackLinkedList<Integer> stack = new StackLinkedList<Integer>();
    stack.push(2);
    stack.push(22);
    System.out.println(stack.size());
    stack.push(3);
    stack.peek();
    stack.pop();
    System.out.println(stack.size());


  }

 
}