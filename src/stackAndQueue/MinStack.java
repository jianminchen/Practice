package stackAndQueue;


public class MinStack {

  private int N;
  private Node first;
  
  private class Node {
    private Node next;
    private int item;
    private int min = Integer.MIN_VALUE;
    
    Node (int x) {
      item = x;
      next = null;
      min = x;
    }
  }
  
  MinStack() {
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
    
    if (first == null) {
      first = new Node(item);
     
    }
    
    else {
    Node temp = new Node(item);
    temp.next = first;
    temp.min = Math.min(item, first.min);
    first = temp;
    }
    N++;
    
  }
  
  public void pop() {
    if (isEmpty()) {
      System.out.println("Empty");   

    } else {       
    int item = first.item;
    first = first.next;
    N--;    
  //  System.out.println(item); 
    }
  }
  
  public void peek() {

    if (isEmpty()) {
      System.out.println("Empty");   

    } else {
       System.out.println(first.item);   
    }
  }
  
  public int getMin() {

    if (isEmpty()) {
      System.out.println("Empty"); 
      return -1;

    } else {
       return first.min;   
    }
  }
  
  
  public static void main(String[] args) {
    
    MinStack stack = new MinStack();
    stack.push(2);
    stack.push(22);
  //  System.out.println(stack.size());
    System.out.println(stack.getMin());

    stack.push(1);
 //   stack.peek();
  //  stack.pop();
  //  System.out.println(stack.size());

    System.out.println(stack.getMin());

  }

 
}
