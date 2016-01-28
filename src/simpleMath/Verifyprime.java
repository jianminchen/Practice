package simpleMath;

import java.util.ArrayList;

public class Verifyprime {

  /*
   * Given a number N, verify if N is prime or not.
   */
  public static void main(String[] args) {

    Verifyprime prime = new Verifyprime();
    int n = 6;
    boolean result = prime.isPrime(n);

    System.out.print(result);

  }

  public boolean isPrime(int a) {
    
    if (a <2) return false;
   
    for (int i =2; i<=Math.sqrt(a); i++) {
      if (a%i == 0) {
          return false;  
      }
      
  }
    return true;
  }
}
