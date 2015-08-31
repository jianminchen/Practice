package algorithmImplementation;

import java.util.Scanner;

public class ModifiedKaprekarNumbers {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    int M = input.nextInt();
    int N = input.nextInt();
    String substring1;
    String substring2;
    int lresult;
    int lrange;

    int count = 0;
    for (int i = M; i <= N; i++) {

      long temp = (long) Math.pow(i, 2);

      String range = String.valueOf(i);
      String result = String.valueOf(temp);


      lresult = result.length();
      lrange = range.length();

      substring1 = result.substring(lresult / 2, lresult);
      substring2 = result.substring(0, lresult / 2);



      int res1 = Integer.parseInt(substring1);


      if (substring2.length() == 0) {
        substring2 = "0";
      }
      int res2 = Integer.parseInt(substring2);


      if (res1 + res2 == i) {
        System.out.print(i);
        System.out.print(" ");
        count++;
      }

    }

    if (count == 0) {
      System.out.println("INVALID RANGE");
    }

  }

}
