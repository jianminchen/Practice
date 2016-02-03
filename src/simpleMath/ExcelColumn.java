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
   int result = 0;
   int i = a.length()-1;
   int t = 0;
   while(i >= 0){
       char curr = a.charAt(i);
       result = result + (int) Math.pow(26, t) * map.get(curr);
       t++;
       i--;
   }

   return result;
    }
   
  }
  
  public String convertToTitle(int n) {
    if(n <= 0){
        throw new IllegalArgumentException("Input is not valid!");
    }
 
    StringBuilder sb = new StringBuilder();
 
    while(n > 0){
        n--;
        char ch = (char) (n % 26 + 'A');
        n /= 26;
        sb.append(ch);
    }
 
    sb.reverse();
    return sb.toString();
}

}
