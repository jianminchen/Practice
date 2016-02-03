package string;

import java.util.Scanner;

public class BiggerIsGreater {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int T = Integer.parseInt(input.nextLine());

    String[] str = new String[T];
    for (int i = 0; i < T; i++) {
      str[i] = input.nextLine();
    }

    for (String s : str) {
      permutate(s);
    }
  }

  private static void permutate(String str1) {

    String result = "no answer";
    
    if(str1.length() > 1) {
    String temp1 = str1.substring(0, str1.length() / 2);
    String temp2 = str1.substring(str1.length() / 2, str1.length());
 
   

    if (!temp1.equals(temp2)) {

      if (temp1.compareTo(temp2) > 0) {
        
        
        /*char[] tempArray = temp2.toCharArray();
        char c = tempArray[tempArray.length - 2];
        tempArray[tempArray.length - 2] = tempArray[tempArray.length - 1];
        tempArray[tempArray.length - 1] = c;
        temp2 = String.valueOf(tempArray);*/
        
        result = temp1 + temp2;

      }

      else {
        String temp = temp2;
        temp2 = temp1;
        temp1 = temp;

        result = temp1 + temp2;
      }
    }
    }
    System.out.println(result);
  }

  /*private static String permutateSub(String str1) {

    String temp1 = str1.substring(0, str1.length() / 2);
    String temp2 = str1.substring(str1.length() / 2, str1.length());

    if (temp1.compareTo(temp2) > 0) {

      temp2 = permutateSub(temp2);

    }
    String temp = temp2;
    temp2 = temp1;
    temp1 = temp;

    return temp1 + temp2;

  }*/

}
