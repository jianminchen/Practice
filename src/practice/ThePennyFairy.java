package practice;
import java.util.Scanner;

public class ThePennyFairy {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int x = Integer.parseInt(input.nextLine());
    int y = Integer.parseInt(input.nextLine());
    int z = Integer.parseInt(input.nextLine());
    int count = 0;
    int k = 0;
    int sum = 0;

    if (y % x == 0) {
      k = y / x;
    }


    else {
      k = y - x;


    }


    sum = y;
    count = 0;
    while (sum < z) {
      sum = sum * k;
      count++;
    }


    System.out.println(count);
  }

}
