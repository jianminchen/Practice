package bitManipulation;

public class ANDRange {

  public static void main(String[] args) {
    System.out.println(rangeBitwiseAnd(25,28));

  }

  public static int rangeBitwiseAnd(int m, int n) {
    int shift = 0;
   
  while (m != n) {
      shift++;
      m = m >> 1;
      n = n >> 1;
  }
return m << shift;
}
}
