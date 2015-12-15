package practice;

public class Fibonacci {
 private static int N = 10;
 private static int[] fib = new int[N +1];



  public static void main(String[] args) {
    
    for(int i =0; i <= N; i++) {  
      System.out.println(fibDp(i));
    }
  }
  
  //O(2^N)
 private static int fibR(int i) {
    
    if (i <= 1 ) return i;  
   return fibR(i -1) + fibR(i -2) ;
   
  }
  
  // Dp Top down
  private static int fib(int i) {
    
    if (i <= 1 ) return i;
    if(fib[i]!= 0) return fib[i]; //return cache result
    fib[i] = fib(i -1) + fib(i -2) ; //cache result
    return fib[i];
  }
  

  // Dp Bottom up 
  private static int fibDp(int N) {
    
    //O(N) time and space
    fib[0] = 0;
    fib[1] = 1;
    for( int i =2; i<=N;i++) {
    fib[i] = fib[i-1] + fib[i-2] ; //cache result
    }
    return fib[N];
  }

  //O(N) time and O(1)space
 private static int fibSpace(int N) {
  
   int a =0 ,b =1, sum =0; 
   if( N == 0) return a; 
   if( N == 1) return b; 
    for( int i =2; i<=N;i++) {
      sum = a + b;
      a = b;
      b = sum;

    }
    return sum;
  }

 
 
}
