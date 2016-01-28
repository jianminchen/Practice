package simpleMath;

import java.util.ArrayList;

public class Factors {
  /*
   * Factor of a number N is a number d such that d divides N. 
   */

  public static void main(String[] args) {

    Factors findFact = new Factors();
    int n = 6;
    ArrayList<Integer> result = findFact.allFactors(n);
    for (int i : result) {
      System.out.print(i+" ");
      
    }
  }
  
  public ArrayList<Integer> allFactors(int a) {
    
    ArrayList<Integer> result = new ArrayList<Integer>();
       
  for (int i =1; i<=Math.sqrt(a); i++) {
        if (a%i == 0) {
            result.add(i);
            if (i != Math.sqrt(a)) {
                result.add(a/i);
            }
        }
    }
    
   /* result.add(1);
     if (a ==1) {
        return result;
    }
    for (int i =2; i<=a/2; i++) {
        if (a%i == 0) {
            result.add(i);
        }  
        }
        
        result.add(a);
   */
    
    return result;
}

}
