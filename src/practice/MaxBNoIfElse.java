package practice;

public class MaxBNoIfElse {

  public static void main(String[] args) {

    System.out.println(findMax(13,5));
  }
  
  public static int findMax(int x, int y) {
    
    int z = x-y;
    //find the sign (MSB)
    int i = (z >> 31) & 1;
    int max = x -i * z;
    //min = y -i*z
    return max;
  }

}
