/**
 * 
 */
package algorithmImplementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sravis0
 *
 */
public class LCSRevisited {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    
    for( int i=0;i <T; i++) {
      int N  = input.nextInt();
      int[] tempA = new int[N];
      int[] tempB = new int[N];
      int[] tempC = new int[N];
      int j =0, k=0, l=0;
      while (j < N) {
        tempA[j++]= input.nextInt();
      }
      while (k < N) {
        tempB[k++]= input.nextInt();
      }
      
      while (l < N) {
        tempC[l++]= input.nextInt();
      }
      
      compare(tempA, tempB, tempC);
    }
 
    
  }

  private static void compare(int[] tempA, int[] tempB, int[] tempC) {
    
    int count =0;
    int j =0, k=0;
    
    
    for(int i =0; i<tempA.length; i++) {
      
      if( tempA[i] == tempB[j] || tempA[i] == tempC[k]) {
        j++;
      }
    }
    
  }

}
