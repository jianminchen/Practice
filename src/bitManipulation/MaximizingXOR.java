package bitManipulation;

/**
 * @author Shalini
 *
 */
public class MaximizingXOR {

  /*
   * Problem Statement
   * 
   * Given two integers, L and R, find the maximal result of A xor B, where A and B satisfy the
   * following condition:
   * 
   * L≤A≤B≤R
   * 
   * 
   */
  public static void main(String[] args) {

    int l = 3;
    int r = 10;
    
    
    int result = l ^ r;
    
    result |= result >> 1;
    result |= result >> 2;
    result |= result >> 4;
    result |= result >> 8;
    result |= result >> 16;

   
    
    System.out.println(result);
  }

}
