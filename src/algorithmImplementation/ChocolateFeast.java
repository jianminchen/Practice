package algorithmImplementation;

import java.util.Scanner;

/**
 * @author shalini
 * 
 */

public class ChocolateFeast {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int T = input.nextInt();

		for (int i = 0; i < T; i++) {
			int N = input.nextInt();
			int C = input.nextInt();
			int M = input.nextInt();
			int chocalte = N / C;
			int currentWrappers = chocalte;

			while (currentWrappers >= M) {
				int unusedWrappers = currentWrappers/M;
				chocalte = chocalte + unusedWrappers;
				currentWrappers = unusedWrappers + (currentWrappers % M);
			
			}
			
			System.out.println(chocalte);

		}
	}
}

	
