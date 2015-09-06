package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MakeitAnagram {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String str1 = input.nextLine();
		String str2 = input.nextLine();

		char[] temp1 = str1.toCharArray();
		char[] temp2 = str2.toCharArray();

		if (temp1.length == temp2.length) {

			Arrays.sort(temp1);
			Arrays.sort(temp2);

			if (temp1.equals(temp2)) {
				System.out.println(0);
			} else {
				checkAnagram(temp1, temp2);
			}

		}

		else if (temp2.length < temp1.length) {

			checkAnagram(temp2, temp1);
		}

		else {

			checkAnagram(temp1, temp2);

		}
	}

	private static void checkAnagram(char[] temp1, char[] temp2) {


		int sumLength = temp1.length + temp2.length;

		HashMap<Character,Integer> temp1Map = new HashMap<Character,Integer>();

		HashMap<Character,Integer> temp2Map = new HashMap<Character,Integer>();

		for (int i = 0; i < temp1.length; i++) {

			if(temp1Map.containsKey(temp1[i])){

				temp1Map.put(temp1[i], temp1Map.get(temp1[i])+1);

			}
			else {
				temp1Map.put(temp1[i], 1);
			}

		}


		for (int i = 0; i < temp2.length; i++) {

			if(temp2Map.containsKey(temp2[i])){

				temp2Map.put(temp2[i], temp2Map.get(temp2[i])+1);

			}
			else {
				temp2Map.put(temp2[i], 1);
			}

		}

		int count = 0;

		for (char val : temp2Map.keySet()) {

			if(temp1Map.containsKey(val)){

				if(temp2Map.get(val) == temp1Map.get(val)) {

					count = count + temp1Map.get(val) * 2;
				}
				else {
					count = count +	Math.min(temp2Map.get(val) ,temp1Map.get(val))* 2;
				}	
			}
		}

		System.out.println(sumLength - count);


	}	

}


