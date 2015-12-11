package practice;
import java.util.HashMap;

public class FirstNonRepeated {

  public static void main(String[] args) {

    String input = "Total";
    
    findNonRepeat(input.toLowerCase());
    
  }

  //O(N)
  private static void findNonRepeat(String input) {
    
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    
    for (char c : input.toCharArray()) {
      
      if (map.containsKey(c)) {
        map.put(c, map.get(c)+1);
      }
      else {
        map.put(c, 1);
      }
    }
    
    for(char c : input.toCharArray()) {
      
      if(map.get(c) == 1) {
        System.out.println(c);
        break;
      }
    }
    
  }
  

}
