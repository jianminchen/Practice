package algorithmWarmUp;

import java.util.Scanner;

public class LibraryFine {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
  		String return_date = input.nextLine();
		String actual_date = input.nextLine();

		if (actual_date.equals(return_date)) {
			System.out.println(0);
		}

		else {
			String[] actualArray = actual_date.split(" ");
			String[] returnArray = return_date.split(" ");

			int actualYear = Integer.parseInt(actualArray[2]);
			int returnYear = Integer.parseInt(returnArray[2]);

			if (actualYear < returnYear) {

				System.out.println(10000);
			}

			else if (actualYear == returnYear) {

				int actualMonth = Integer.parseInt(actualArray[1]);
				int returnMonth = Integer.parseInt(returnArray[1]);

				if (actualMonth < returnMonth) {

					int diff = (returnMonth - actualMonth) * 500;
					System.out.println(diff);
				}
				

				if (actualMonth > returnMonth) {

					System.out.println(0);
				}

				else if (actualMonth == returnMonth) {

					int actualDay = Integer.parseInt(actualArray[0]);
					int returnDay = Integer.parseInt(returnArray[0]);
				

					if (actualDay < returnDay) {
						int d_diff = (returnDay - actualDay) * 15;
						System.out.println(d_diff);
					}
					
					if (actualDay > returnDay) {
						System.out.println(0);
					}

				}
				

			}
			else 
			{
				System.out.println(0);
			}
		}

	}
}
