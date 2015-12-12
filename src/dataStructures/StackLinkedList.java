package dataStructures;

public class StackLinkedList {

  private int N;
  private Node first;
  
  private static class Node {
    private int item;
    private Node next;
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
  
  public void push(int item) {
    
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
    int item = first.item;
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
    
    StackLinkedList stack = new StackLinkedList();
    stack.push(2);
    stack.push(22);
    System.out.println(stack.size());
    stack.push(3);
    stack.peek();
    stack.pop();
    System.out.println(stack.size());


  }

}