package practice;

public class QuickSums {

  public static void main () {
    String input = "10";
    int total = 100;
    int res = minSums(input, total);
    System.out.println(res);
 }
  
  //With at most 10 digits, there are at most 2^9 ways to insert plus signs into the string. Therefore, there are at most 29 possibilities to consider. We can use recursion to go through all possibilities and keep track of the minimum number of additions required
public static int minSums(String numbers, int sum) {
  int N = numbers.length();
  
  //base cases
  if (N <= 3 && sum == Integer.parseInt(numbers)) {
    return 0;
  } 
  
  else if ( N == 2 && Integer.parseInt(numbers.substring(0,N-1)) + Integer.parseInt(numbers.substring(N-1))  == sum) {
     return 1;
  }
  else if ( N == 2 && Integer.parseInt(numbers.substring(0,N-1)) + Integer.parseInt(numbers.substring(N-1))  != sum) {
    return -1;
 } 
  
  //solution
  else {
  
    int possibleCombination = (int) Math.pow(2, N-1);
    
    // numbers will contain between 1 and 10 characters, inclusive.
    int min = 20;
    
    for (int i =0; i <possibleCombination; i++) {
      String plus = Integer.toBinaryString(i);
      System.out.println(plus);
    }
  
    
  }
  return sum;
  
}

}