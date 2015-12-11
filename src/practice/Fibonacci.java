package practice;

public class Fibonacci {
 private static int N = 10;
 private static int[] fib = new int[N +1];



  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    //O(2^N)
    for(int i =1; i <= N; i++) {  
      System.out.println(fibDp(i));
    }

  }

  private static int fibDp(int i) {
    
    //O(N)
    if (i <= 1 ) return i;
    if(fib[i]!= 0) return fib[i]; //return cache result
    fib[i] = fibDp(i -1) + fibDp(i -2) ; //cache result
    return fib[i];
  }

 private static int fibR(int i) {
    
    if (i <= 1 ) return i;
    
   return fibR(i -1) + fibR(i -2) ;
   
  }
}
