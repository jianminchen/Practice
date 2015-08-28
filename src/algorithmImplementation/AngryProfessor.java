package algorithmImplementation;

import java.util.Scanner;

/**
 * @author Shalini
 *
 */
public class AngryProfessor {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int T = Integer.parseInt(input.nextLine());
		
		
		for (int i = 0; i < T; i++) {
			
			String[] params = input.nextLine().split(" ");
			int N = Integer.parseInt(params[0]);
			int K = Integer.parseInt(params[1]);
			
			int count = 0;
			String[] stdnt_time = input.nextLine().split(" ");
			
			

			for (int j = 0; j < N; j++) {
				int val = Integer.parseInt(stdnt_time[j]);

				if (val <= 0) {
					count++;
				}

			}
            if (count >= K) {
					System.out.println("NO");
			
				}

			if (count < K) {
				System.out.println("YES");
			}
		}
		
		
	}
}
