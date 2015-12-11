package practice;

public class TrailingZerosFact {
  
  
  private int countZeros(int num) {
    int count = 0;
    
    for (int i =2; i<=num; i++) {
      count += factorsofFive(i);
    }
    return count;
  }

  private int factorsofFive(int i) {
    
    int count = 0;
    
    while(i%5 == 0) {
      count ++;
      i = i/5;
    }
    
    return count;
  }
  
  
  // first count number of multiples of 5 , then 25, 125....
private int optimized(int num) {
    
    int count = 0;
    
    if(num < 0) {
      return -1;
    }
    
    for( int i =5; num/i > 0; i*=5 ) {
      count += num/i;
    }
    
    return count;
  }
  public static void main(String args[]) {
    
    TrailingZerosFact tz = new TrailingZerosFact();
    System.out.println(tz.countZeros(10));
    System.out.println(tz.optimized(10));
    
  }

}
