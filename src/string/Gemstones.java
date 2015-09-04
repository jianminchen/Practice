package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Gemstones {

	public static void main(String[] args) {

		Set<Character> resultMap = new HashSet<Character>();

		Scanner input = new Scanner(System.in);
		int T = Integer.parseInt(input.nextLine());

		String text = input.nextLine();

		for (int i = 0; i < text.length(); i++) {

			if (!resultMap.contains(text.charAt(i))) {
				resultMap.add(text.charAt(i));
			}
		}

		for (int i = 0; i < T - 1; i++) {

			String temp = input.nextLine();
			Set<Character> tempMap = new HashSet<Character>();

			for (int j = 0; j < temp.length(); j++) {

				if (!tempMap.contains(temp.charAt(j)))
					tempMap.add(temp.charAt(j));
			}

			resultMap.retainAll(tempMap);

		}

		System.out.println(resultMap.size());

	}

}
