package algorithmWarmUp;

import java.util.Scanner;


public class SimpleArraySum {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
 
        int sum = 0;
        for(int i =0;i <n ;i++) {
           sum = sum + input.nextInt();
        }
        
        System.out.println(sum);
    }

}
