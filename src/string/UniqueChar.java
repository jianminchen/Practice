package string;

public class UniqueChar {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
  
  // O(N) time
  public static boolean isUniqueChars(String str) {
    // short circuit - supposed to imply that
    // there are no more than 256 different characters.
    // this is broken, because in Java, char's are Unicode,
    // and 2-byte values so there are 32768 values
    // (or so - technically not all 32768 are valid chars)
    if (str.length() > 256) {
        return false;
    }
    // checker is used as a bitmap to indicate which characters
    // have been seen already
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
        // set val to be the difference between the char at i and 'a'
        // unicode 'a' is 97
        // if you have an upper-case letter e.g. 'A' you will get a
        // negative 'val' which is illegal
        int val = str.charAt(i) - 'a';
        // if this lowercase letter has been seen before, then
        // the corresponding bit in checker will have been set and
        // we can exit immediately.
        if ((checker & (1 << val)) > 0) return false;
        // set the bit to indicate we have now seen the letter.
        checker |= (1 << val);
    }
    // none of the characters has been seen more than once.
    return true;
}
  
  
//O(N) time and O(1) space
 public static boolean isUniqueChars2(String str) {
  
   if (str.length() > 256) {
       return false;
   }
 
   boolean[] charSet = new boolean[256];
   for (int i = 0; i < str.length(); i++) {

       int val = str.charAt(i);
       if(charSet[val]) {
         return false;
       }
       charSet[val] = true;
   }
   // none of the characters has been seen more than once.
   return true;
}
 
  
  

}
