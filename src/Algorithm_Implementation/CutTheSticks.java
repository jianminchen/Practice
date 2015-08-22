package Algorithm_Implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author shalini
 * 
 */

public class CutTheSticks {
	
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		int[] sticks = new int[T];

		for(int i=0; i<T; i++) {
			sticks[i] = input.nextInt();
		}
		System.out.println(T);
		cutSticks(sticks);
	}

	private static void cutSticks(int[] sticks) {
		
			Arrays.sort(sticks);
			int curr_min = sticks[0];
			int i =0;
			int count =0;
			if(curr_min !=  Integer.MAX_VALUE) {
			while(i < sticks.length ) {
								
			if(sticks[i]!=  Integer.MAX_VALUE){	
				sticks[i] = sticks[i] - curr_min;
				
				if(sticks[i] == 0) {
					sticks[i]= Integer.MAX_VALUE;
				}
				
				
				if(sticks[i] > 0 && sticks[i]!= Integer.MAX_VALUE) {
					count++;
				}
			}
				
				i++;
			}
			
			if(count > 0) {
				System.out.println(count);
				cutSticks(sticks);
			}
			
			}
		}
	}


