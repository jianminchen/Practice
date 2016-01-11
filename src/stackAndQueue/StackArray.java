package stackAndQueue;

public class StackArray<Item> {

  private Item[] stackArray;
  private int N = 0 ;
  
  
  
  StackArray() {
    stackArray = (Item[]) new Object[2]; 
  }
  
  public boolean isEmpty() {
    return N==0;   
  }
  
  public int size() {
    return N;   
  }
  
  public void push(Item item) {
    
    if (stackArray.length == N) {
      resize(stackArray.length*2);  //double the array size
    } 
    stackArray[N++] = item;
  }
  
  
  public Item pop() {
    if(isEmpty()) throw new RuntimeException("Queue underflow");

    Item item = stackArray[N-1];
    stackArray[N-1] = null; //to avoid loitering
    N--;
    if(N >0 && stackArray.length/4 == N) {
      resize(N/2);   // shrink size of array 
    }
    
    return item;
  }
  
  //dynamically resized
  private void resize(int size) {
    
    Item[] temp = (Item[])new Object[size];
    
    for(int i =0; i<N; i++) {
      temp[i] = stackArray[i];
    }
    stackArray = temp;
    
  }

  public static void main(String[] args) {

  }

}
