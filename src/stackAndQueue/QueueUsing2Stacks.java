package stackAndQueue;

import java.util.Stack;

public class QueueUsing2Stacks<Item> {
  private Stack<Item> stack1;    // back of queue
  private Stack<Item> stack2;    // front of queue
  
  
  // create an empty queue
  public QueueUsing2Stacks() {
      stack1 = new Stack<Item>();
      stack2 = new Stack<Item>();
  }
  
  public boolean isEmpty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }
  
  
  public int size() {
    return stack1.size()+stack2.size();
  }
  
  public void enqueue(Item item) {
    stack1.push(item);
  }
  
  public Item dequeue() {
    if(isEmpty()) throw new RuntimeException("Queue underflow");

    if (stack2.isEmpty()){
      moveStack1To2();
    }
    
    return stack2.pop();
  }
  
  public Item peek(Item item) {
    if(isEmpty()) throw new RuntimeException("Queue underflow");
    
    if (stack2.isEmpty()){
      moveStack1To2();
    }
   return stack2.peek();
  }
  private void moveStack1To2() {
    while (!stack1.isEmpty())
      stack2.push(stack1.pop());    
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
