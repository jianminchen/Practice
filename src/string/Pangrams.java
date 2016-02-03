package string;

import java.util.HashMap;
import java.util.Scanner;

public class Pangrams {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    HashMap<Character, Boolean> resultMap = new HashMap<Character, Boolean>();
    String text = input.nextLine();

    String newText = text.replaceAll("\\s","").toLowerCase();
    
    int length = newText.length();
    int count =0;
    
    for(char i = 'a'; i <= 'z' ; i++){
      resultMap.put(i, false); 
    }
    
    
     for(int i=0; i<length; i++) {
      
      char temp = newText.charAt(i);
      if(resultMap.containsKey(temp) && resultMap.get(temp) == false){
        resultMap.put(temp, true);
        count++;
      }
      
    }
    
    if(count != 26) {
      System.out.println("not pangram");
    }
    else {
      System.out.println("pangram");
    }
    
    
  }

}
