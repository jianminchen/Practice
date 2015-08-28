package string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FunnyString {

	public static void main(String args[]) throws IOException {

		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));

		int n;

		String first = stdin.readLine();

		n = Integer.parseInt(first);

		if (n == 0) {
			System.out.println("Sorry");
		}

		else {
			String[] inputString = new String[n];
			for (int i = 0; i < n; i++) {
				inputString[i] = stdin.readLine();
			}

			for (int j = 0; j < n; j++) {

				int length = inputString[j].length();
				boolean flag = true;

				char[] stringArray = inputString[j].toCharArray();

				for (int i = 1; i < length; i++) {
					int temp = (int) stringArray[i] - (int) stringArray[i - 1];
					int temp1 = (int) stringArray[length - (i + 1)]
							- (int) stringArray[length - i];
					if (Math.abs(temp) != Math.abs(temp1)) {
						flag = false;
						System.out.println("Not Funny");
						break;
					}
				}

				if (flag == true) {
					System.out.println("Funny");

				}

			}

		}
	}
}
