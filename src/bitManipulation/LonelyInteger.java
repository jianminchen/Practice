package bitManipulation;

public class LonelyInteger {


  /*
   * Problem Statement
   * 
   * There are N integers in an array A. All but one integer occur in pairs. Your task is to find
   * the number that occurs only once.
   * 
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    int[] a = {1, 2, 2, 1, 3};
    int result = 0;
    for (int i = 0; i < a.length; i++) {
      result ^= a[i];
    }
    System.out.println(result);
  }

}
