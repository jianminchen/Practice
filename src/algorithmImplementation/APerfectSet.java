package algorithmImplementation;

import java.util.Random;
import java.util.Scanner;

public class APerfectSet {


  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String[] inputStr =(input.nextLine()).split(" ");
    int N = Integer.parseInt(inputStr[0]);
    Random random = new Random();
    int xA ;
    int xB ;
    int max = 8;
    int min = 1;
    int d = Integer.parseInt(inputStr[1]);
    int count =0;
    for (int i =1 ; i <= N; i++) {

      
      xA  = random.nextInt(max - min + 1) + min;
      xB = random.nextInt(max - min + 1) + min;
      while (xA == 0 || xA == xB) {
        xA  = random.nextInt(max - min + 1) + min;
      }
      while (xB == 0 || xA == xB) {
        xB  =random.nextInt(max - min + 1) + min;
      }

      if (xA + xB  == N+1)  {
        count = count +1 ;

      }

      if( count == d) {
        System.out.println(i);
        break;
      }

    }
  } 

}
