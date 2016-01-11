package stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class SuperStack {

  public static void main(String[] args) throws NumberFormatException, IOException {

    LinkedList<Integer> stack = new LinkedList<Integer>();

    BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(bi.readLine());
    for (int i = 0; i < T; i++) {
      String tempLine = bi.readLine();
      if (tempLine.startsWith("PUSH")) {
        String[] params = tempLine.split(" ");
        int val = Integer.parseInt(params[1]);
        stack.addFirst(val);
        peek(stack);
      } else if (tempLine.startsWith("POP")) {

        if (stack.isEmpty()) {
          System.out.println("Empty");

        } else {
          stack.removeFirst();
          peek(stack);

        }
      }

      else if (tempLine.startsWith("INC")) {
        if (stack.isEmpty()) {
          System.out.println("Empty");

        } else {
          String[] params = tempLine.split(" ");
          int count = Integer.parseInt(params[1]);
          int d = Integer.parseInt(params[2]);
          count = Math.min(stack.size(), count);
          int i1 = stack.size() - 1;

          while (count > 0) {
            int current = stack.get(i1);
            current = current + d;
            stack.set(i1, current);
            i1 = i1 - 1;
            count--;
          }
          peek(stack);
        }
      } else {
        System.out.println("Sorry Wrong input");
      }
    }

  }

  
 
  public static void peek(LinkedList<Integer> stack) {

    if (stack.isEmpty()) {
      System.out.println("Empty");

    } else {
      System.out.println(stack.getFirst());
    }
  }


}
