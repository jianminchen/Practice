package dataStructures;

import java.util.LinkedList;
import java.util.Scanner;

public class SuperStack {

  public static void main(String[] args) {

    LinkedList<Integer> stack = new LinkedList<Integer>();

    Scanner in = new Scanner(System.in);
    int T = Integer.parseInt(in.nextLine());
    for (int i = 0; i < T; i++) {
      String tempLine = in.nextLine();
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
            stack.add(i1, current);
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
