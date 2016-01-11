package stackAndQueue;


import java.util.NoSuchElementException;

public class QueueArray<Item> {

  private Item[] queueArray;            // queue elements
  private int N = 0;           // number of elements on queue
  private int front = 0;      
  private int last  = 0;  
  private int qSize = 10;

  QueueArray(int size) {
    qSize = size;
    queueArray = (Item[]) new Object[qSize]; 
    front = -1;
    last =-1;
   }
   
   public boolean isEmpty() {
     return front == -1 && last ==-1;   
   }
   
   
   public boolean isFull() {
     return (last+1)%qSize == front ? true : false;
   
   }
   
   public void enqueue(Item item){
     if(isFull()){
       throw new RuntimeException("Queue overflow");
     }

     if (isEmpty()) {
       front = 0;
       last =0;
       
     } else {
       //wrap around
       last = (last +1) %qSize;
     }
     
   //add item to last of the the array
     queueArray[last] = item;
   }
   
   
   public Item dequeue() {  
     if(isEmpty()) throw new RuntimeException("Queue underflow");

     Item item = null;
     
     //remove from the front
     if (front == last) {
       item = queueArray[front];
       front = -1;
       last = -1;
     } else {
       item = queueArray[front];
       front = (front +1)%qSize;
     }
     
     return item;
   }
   
   
   public Item peek() {
     if (isEmpty()) throw new NoSuchElementException("Queue underflow");
     return queueArray[front];
 }
  
   
   public int size() {
     if (isEmpty()) throw new NoSuchElementException("Queue underflow");
     return last - front +1;
 }
   
   
  public static void main(String[] args) {
    QueueArray<Integer> queue = new QueueArray<Integer>(10);
    queue.enqueue(2);
    queue.enqueue(22);
    System.out.println(queue.size());
    queue.enqueue(3);
    queue.peek();
    queue.dequeue();
    System.out.println(queue.size());
    queue.enqueue(5);
    System.out.println(queue.size());


  }
}

