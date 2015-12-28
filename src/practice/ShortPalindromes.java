package practice;

public class ShortPalindromes {

  public static void main(String[] args) {
    String input = "ACBA";
  //  String res = shortestRecursive(input);
    String res = shortestDP(input);
    System.out.println(res);


  }

  /*
   * naive approach = recursive exponential time 
   * shortest(base) 
   * if base is already a palindrome then
   *    return base 
   * if base has the form A...A 
   *     then return A + shortest(...) + A 
   * if base has the form A...B 
   *    then return min(A + shortest(...B) + A, B + shortest(A...) + B)
   */
  public static String shortestRecursive(String base) {

    int N = base.length();
    if (N == 0) {
      return "Empty String";
    } else if (N == 1) {
      return base;
    } else {
      StringBuilder tempString = new StringBuilder(base);
      if (base.equals(tempString.reverse())) {
        return base;
      } else {
        char start = base.charAt(0);
        char end = base.charAt(N - 1);
        if (start == end) {
          return start + shortestRecursive(base.substring(1, N - 1)) + start;
        } else {

          return minimum(start + shortestRecursive(base.substring(1)) + start,
              end + shortestRecursive(base.substring(0, N - 1)) + end);

        }
      }
    }
  }

  private static String minimum(String a, String b) {

    if (a.length() > b.length()) {
      return b;
    } else if (b.length() > a.length()) {
      return a;
    } else {
      if (a.compareTo(b) < 0) {
        return a;
      } else {
        return b;
      }

    }
  }
  
  //DP O(N^2)
  
  public static String shortestDP(String base) {
    
    int N = base.length();
    
    if (N == 0) {
      return "Empty String";
    } else if (N == 1) {
      return base;
    } else {
      StringBuilder tempString = new StringBuilder(base);
      if (base.equals(tempString.reverse())) {
        return base;
      } else {
        String[][] DP = new String[N][N];
        for (int i= 0; i <N; i++) {  
          DP[i][i] = base.charAt(i)+"";
        }
               
        for (int i = N; i>=0; i--) {
          
          for (int j = i+1; j <N; j++ ) {
            
            // A...A
            if (base.charAt(i) == base.charAt(j)) {
              DP[i][j] =  base.charAt(i) + DP[i+1][j-1] +base.charAt(j);             
            } 
            //A....B
            else {
              DP[i][j] =  minimum (base.charAt(i)+DP[i+1][j]+base.charAt(i) , base.charAt(j)+DP[i][j -1]+base.charAt(j));
            }
          }
          
        }
        return DP[0][N-1];

      }
    }
  }
}
