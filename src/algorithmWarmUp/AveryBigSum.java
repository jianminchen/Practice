package algorithmWarmUp;

import java.util.Scanner;

public class AveryBigSum {
	public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long sum =0;
        for (int i=0; i<n; i++){
            
            sum =  sum + input.nextLong();
        }
        System.out.println(sum);
    }
}
