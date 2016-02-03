package simpleMath;

public class sqrt {

  /*
   * Compute and return the square root of x.
   */
  
  public static void main(String[] args) {
    System.out.println(sqrt(9));
  }

//O(logN)
public static int sqrt(int x) {
  long i = 0;
  long j = x / 2 + 1;
  while (i <= j) {
      long mid = (i + j) / 2;
      if (mid * mid == x)
          return (int)mid;
      if (mid * mid < x)
          i = mid + 1;
      else
          j = mid - 1;
  }
  return (int)j;
}
}