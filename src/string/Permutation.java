package string;

public class Permutation {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    permutate("", "abc");
  }
  
  private static void permutate(String prefix, String reminder) {
    
    if (reminder.length() == 0){
      System.out.println(prefix);
    }
    
    int len = reminder.length();
    
    for (int i=0; i<len;i++){

      String before = reminder.substring(0,i);

      String after = reminder.substring(i+1,len);

      char c = reminder.charAt(i);
     
      permutate(prefix+c, before+after);
    }
  }

}
