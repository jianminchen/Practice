package algorithmImplementation;

import java.util.Scanner;

/**
 * @author shalini
 * 
 */

public class Service_Lane {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String[] constraints = (input.nextLine()).split(" ");

		int N = Integer.parseInt(constraints[0]);
		int T = Integer.parseInt(constraints[1]);
		String[] width_str = (input.nextLine()).split(" ");

		int[] width = new int[width_str.length];

		for (int i = 0; i < width_str.length; i++) {
			// System.out.println(width_str[i]);
			width[i] = Integer.parseInt(width_str[i]);
		}

		for (int i = 0; i < T; i++) {
			String[] serviceLane = (input.nextLine()).split(" ");

			int entry = Integer.parseInt(serviceLane[0]);
			int exit = Integer.parseInt(serviceLane[1]);
			if (entry <= exit) {

				int minwidth = width[entry], currentWidth = 0;
				for (int j = entry; j <= exit; j++) {
					currentWidth = width[j];

					if (currentWidth < minwidth) {
						minwidth = currentWidth;
					}

				}
				System.out.println(minwidth);

			}

			else {
				System.out.println(0);
			}

		}
	}

}
