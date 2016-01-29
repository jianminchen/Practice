package simpleMath;

import java.util.HashMap;
import java.util.Map;

public class ExcelColumn {

  /*
   * Given a column title as appears in an Excel sheet, return its corresponding column number.
   */
  public static void main(String[] args) {

    System.out.print(titleToNumber("AAA"));
  }
  
  
  public static int titleToNumber(String a) {
    
    Map<Character, Integer> map = new HashMap<Character,Integer>();
    
    int value = 1;
    for (char i = 'A'; i<= 'Z';i++) {
      map.put(i, value++);
    }
    
    int lenght = a.length();
    
    if (lenght == 1) {
      return map.get(a.charAt(0));
    }
    
 else {
   int sum =1;
   
      for (int i =0; i<lenght;i++) {
        
        if (i == lenght -1) {
          //Have to correct it
          sum = sum + map.get(a.charAt(i));
        } else {
          sum = sum * map.get(a.charAt(i))*26;
        }
      }
      return sum;
    }
   
  }

}
