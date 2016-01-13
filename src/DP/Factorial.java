package DP;
import java.math.BigInteger;

public class Factorial {

  private static int N =5;
  private static long[] fib = new long[N +1];
  

  public static void main(String[] args) {
    System.out.println(factDPTopDown(N));
    System.out.println(factDP(N));

  }

  private static int fact(int n) { 
    if (n <= 1) return 1;
    return n*fact(n-1);
  }
  
  //larger factorial
  private static BigInteger factorial(int number) {
    
    BigInteger factorial = BigInteger.ONE;

    for (int i = number; i > 0; i--) {
        factorial = factorial.multiply(BigInteger.valueOf(i));
    }

    return factorial;
}
  

//Dp Top down
 private static long factDPTopDown(int i) {
   
   if (i <= 1 ) return 1;
   if(fib[i]!= 0) return fib[i]; //return cache result
   fib[i] = i *factDPTopDown(i -1); //cache result
   return fib[i];
 }
 

 // Dp Bottom up 
 private static long factDP(int N) {
   
   //O(N) time and space
   fib[0] = 1;
   fib[1] = 1;
   for( int i =2; i<=N;i++) {
   fib[i] = i* fib[i-1] ; //cache result
   }
   return fib[N];
 }

}
