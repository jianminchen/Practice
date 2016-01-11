package stackAndQueue;

import java.util.NoSuchElementException;

public class QueueArrayResize<Item> {
  private Item[] queueArray;            // queue elements
  private int N = 0;           // number of elements on queue
  private int front = 0;      
  private int last  = 0;       

  QueueArrayResize() {
    queueArray = (Item[]) new Object[2]; 
   }
   
   public boolean isEmpty() {
     return N==0;   
   }
   
   public int size() {
     return N;   
   }
   
   public void enqueue(Item item){
     if (queueArray.length == N) {
       resize(queueArray.length*2);  //double the array size
     }
   //add item to last of the the array
     queueArray[last++] = item;
     if (last == queueArray.length) {
       last = 0; //wrap around
     }
     N++;  

   }
   
   
   public Item dequeue() {  
     if(isEmpty()) throw new RuntimeException("Queue underflow");

     //remove from the front
     Item item = queueArray[front];
     queueArray[front] = null; //to avoid loitering
     N--;
     front++;
     
     if (front == queueArray.length) {
       front = 0;
     }
     
     if (N > 0 && queueArray.length/4 == N) {
       resize(queueArray.length/2);
     }
     
     return item;
   }
   
   
   public Item peek() {
     if (isEmpty()) throw new NoSuchElementException("Queue underflow");
     return queueArray[front];
 }
  
  private void resize(int size) {
      Item[] temp = (Item [])new Object[size];
      
      for (int i =0;i <N; i++) {
       temp[i] = queueArray[(front +i) %queueArray.length]; 
      }
      
      queueArray = temp;
      front =0;
      last = N;
    
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
