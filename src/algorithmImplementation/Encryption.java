package algorithmImplementation;

import java.util.Scanner;

public class Encryption {
  public static void main(String args[]) {

    Scanner input = new Scanner(System.in);
    String message = input.nextLine();

    int length = message.length();

    int rows = (int) Math.floor(Math.sqrt(length));

    int column = (int) Math.ceil(Math.sqrt(length));


    if (rows * column <= length) {
      rows = rows + 1;

    }
    for (int i = 0; i < column; i++) {

      int k = i;
      for (int j = 0; j < rows; j++) {

        if (k >= length) {
          System.out.print("");

        }

        else {
          System.out.print(message.charAt(k));

        }
        k = k + column;
      }
      System.out.print(" ");

    }

  }

}
