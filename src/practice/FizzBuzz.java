package practice;
import java.util.Scanner;

public class FizzBuzz {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int x = input.nextInt();

    int y = input.nextInt();
    int z = input.nextInt();
    
    for (int i =1 ; i <=x; i++ ) {
      if (i % y == 0 && i %z == 0) {
        System.out.println("FizzBuzz");
      }
      else if (i %y ==0) {
        System.out.println("Fizz");

      }
      else if (i %z ==0 ){
        System.out.println("Buzz");

      }
      else {
        System.out.println(i);
      }
    }
  }

}
