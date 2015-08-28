package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlternatingCharacters {
	
	 public static void main(String[] args) throws IOException  {
	        
		    BufferedReader stdin = new BufferedReader(new InputStreamReader(
						System.in));
				int n;
				String first = stdin.readLine();
				n = Integer.parseInt(first);

				if (n > 0) {
					String[] inputString = new String[n];

					for (int i = 0; i < n; i++) {
						inputString[i] = stdin.readLine();

						// System.out.println(inputString[i]);
					}

					for (int j = 0; j < n; j++) {
						int flag = 0;

						int length = inputString[j].length();
						if (length == 0) {
							System.out.println(0);
						}

						char[] carray = inputString[j].toCharArray();

						char current = carray[0];

						for (int i = 1; i < length; i++) {
							if (carray[i] == current) {
								flag++;
							} else {
								current = carray[i];
							}
						}
						System.out.println(flag);

					}
				}
			}

}
