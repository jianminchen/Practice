package practice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CallMeMaybe {
	public static void main(String[] args) throws IOException {
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		String line;
		ArrayList<String> lines = new ArrayList<String>();
		line = bi.readLine();
		while (line != null && line.length() != 0) {
			lines.add(line);
			line = bi.readLine();
		}

		for (String l : lines) {

			System.out.println(processLine(l));
		}
	}

	static String processLine(String line) {
		// Process each line of input here

		char[] temp = line.toCharArray();
		char[] result = new char[temp.length];

		HashMap<Character, Integer> phoneMap = new HashMap<Character, Integer>();
		int count = 3;
		int i = 2;
		for (char c = 'A'; c <= 'Z'; c++) {
			if (c == 'P' || c == 'W') {
				count = 4;
			}

			if (count > 0) {

				phoneMap.put(c, i);
				count--;
			}

			if (count == 0) {
				count = 3;
				i = i + 1;
			}

		}

		for (int i1 = 0; i1 < temp.length; i1++) {

			if (Character.isLetter(temp[i1])) {

				result[i1] = (char) ('0' + phoneMap.get(Character
						.toUpperCase(temp[i1])));
			}

			else {
				result[i1] = temp[i1];
			}

		}

		return String.valueOf(result);
	}

}
