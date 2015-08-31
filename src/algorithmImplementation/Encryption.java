package algorithmImplementation;

import java.util.Scanner;

public class Encryption {
	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);
		String message = input.nextLine();

		int lenght = message.length();

		int rows = (int) Math.floor(Math.sqrt(lenght));

		int column = (int) Math.ceil(Math.sqrt(lenght));

		for (int i = 0; i < column; i++) {

			int k = i;
			for (int j = 0; j < rows; j++) {

				System.out.print(message.charAt(k));

				k = k + column;
			}
			System.out.print(" ");

		}

	}

}
