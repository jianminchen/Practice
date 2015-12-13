package practice;

/**
 * @author Shalini
 *
 */
/**
* Problem Statement The Fibonacci sequence is defined as follows: F[0] = 0 F[1] = 1 for each i >=
* 2: F[i] = F[i-1] + F[i-2] Thus, the Fibonacci sequence starts as follows: 0, 1, 1, 2, 3, 5, 8,
* 13, ... The elements of the Fibonacci sequence are called Fibonacci numbers.
* 
* 
* 
* You're given an int N. You want to change N into a Fibonacci number. This change will consist
* of zero or more steps. In each step, you can either increment or decrement the number you
* currently have. That is, in each step you can change your current number X either to X+1 or to
* X-1.
* 
* 
* 
* Return the smallest number of steps needed to change N into a Fibonacci number.
* 
*/
public class FibonacciDiv2 {

  public static void main(String args[]) {
     int res = find(13);
     System.out.println(res);
  }

  
  public static int find(int N) {
    int[] f = new int[32];
    f[0] = 0;
    f[1] = 1;
    for (int i = 2; i < 32; ++i) {
      f[i] = f[i - 2] + f[i - 1];
      if (f[i] == N) {
        return 0;
      } else {
        if (Math.abs(N - f[i]) > Math.abs(N - f[i - 1])) {
          return Math.abs(N - f[i - 1]);
        }
      }
    }
    return Math.abs(N - f[31]);

  }
}
