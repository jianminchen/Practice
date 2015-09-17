package string;

import java.util.Scanner;

public class TwoStrings {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int T = Integer.parseInt(input.nextLine());
    
    for(int i =0 ;i< T; i++) {
      String str1 = input.nextLine();
      String str2 = input.nextLine();
      
      if (str1.length() <  str2.length()) {
       String temp = str1;
       str1 = str2;
       str2 = temp;
      }
      findTwoStrings(str1,str2);
      
    }
  }

  private static void findTwoStrings(String str1, String str2) {
  
    String flag = "NO";
    
    for(char c : "abcdefghijklmnopqrstuvwxyz".toCharArray())
    {
            if(str1.indexOf(c) > -1 && str2.indexOf(c) > -1)
            flag = "YES";
        }

    System.out.println(flag);
    
    
  }

}
