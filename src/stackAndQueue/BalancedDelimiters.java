package stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class BalancedDelimiters {

  private static final char L_PAREN = '(';
  private static final char R_PAREN = ')';
  private static final char L_BRACE = '{';
  private static final char R_BRACE = '}';
  private static final char L_BRACKET = '[';
  private static final char R_BRACKET = ']';

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    String str = input.nextLine();
    boolean flag = checkParanthesis(str);
    String res = "";
    if (flag) {
      res = res + "True";
    } else {
      res = res + "False";
    }
    System.out.println(res);
  }

  private static boolean checkParanthesis(String str) {
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < str.length(); i++) {

      if (str.charAt(i) == L_PAREN || str.charAt(i) == L_BRACKET || str.charAt(i) == L_BRACE) {
        stack.push(str.charAt(i));
      } else if (str.charAt(i) == R_BRACE) {

        if (stack.isEmpty())
          return false;
        if (stack.pop() != L_BRACE)
          return false;
      } else if (str.charAt(i) == R_BRACKET) {

        if (stack.isEmpty())
          return false;
        if (stack.pop() != L_BRACKET)
          return false;
      } else if (str.charAt(i) == R_PAREN) {

        if (stack.isEmpty())
          return false;
        if (stack.pop() != L_PAREN)
          return false;
      }
    }

    return stack.isEmpty();
  }

}
