package bitManipulation;

public class ReverseBits {

  public static void main(String[] args) {
    System.out.println(reverseBits(25));

  }
  
public static int reverseBits(int num) {
    
    int reverse_num = 0;
    for (int i= 0; i<32 ;i++) {
      
      if((num & (1 << i)) != 0) {
        reverse_num |= 1 << ((31) - i);  
    }
    }
    return reverse_num;
    }

}
