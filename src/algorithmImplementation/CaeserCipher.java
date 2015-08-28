package algorithmImplementation;

import java.util.Scanner;

public class CaeserCipher {
	 public static void main(String[] args) {

			Scanner input = new Scanner(System.in);
			int length = input.nextInt();
			String str = input.next();
			int rotate = input.nextInt();



			for(int i =0; i<length; i++) {

				if(Character.isLetter(str.charAt(i))){

					if(Character.isUpperCase(str.charAt(i))){
						System.out.print((char)(((str.charAt(i) - 'A' + rotate )%26) + 'A'));		

					}
					if(Character.isLowerCase(str.charAt(i))){
						System.out.print((char)(((str.charAt(i) - 'a' + rotate )%26) + 'a'));		

					}
				}
				else {
					System.out.print(str.charAt(i));
				}


			}

		}
}
