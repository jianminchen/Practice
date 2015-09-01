package string;

import java.util.HashMap;
import java.util.Scanner;

public class GameofThrones1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String key = input.nextLine();
		int length = key.length();
		HashMap<Character, Integer> resultMap = new HashMap<Character, Integer>();
		String ans = null;
		int count = 0;

		if (length == 1) {
			ans = "YES";
		} else {

			for (char temp : key.toCharArray()) {
				if (resultMap.containsKey(temp)) {

					int flag = resultMap.get(temp) + 1;
					resultMap.put(temp, flag);
				} else {
					resultMap.put(temp, 1);
				}
			}

			for (int value : resultMap.values()) {

				if (value % 2 == 0) {
					count++;
				}

			}

			if (length % 2 == 0 && count == resultMap.size()) {
				ans = "YES";
			} else if (length % 2 != 0 && count == resultMap.size() - 1) {
				ans = "YES";
			} else {
				ans = "NO";
			}

		}

		System.out.println(ans);
		input.close();
	}
}
