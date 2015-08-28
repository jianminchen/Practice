package algorithmWarmUp;

import java.util.Scanner;

public class TimeConversion {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		String time = input.nextLine();
		String[] timeArray = time.split(":");
		int temp = Integer.parseInt(timeArray[0]);
		int temp1 = Integer.parseInt(timeArray[1]);
		int temp2 = Integer.parseInt(timeArray[2].substring(0, Math.min(timeArray[2].length(), 2)));

		if (temp < 1 || temp > 12 || temp1 < 0 || temp1 > 59 || temp2 < 0 || temp2 > 59) {

			System.exit(0);
		}

		else {

			String substring = time.substring(Math.max(time.length() - 2, 0));

			if (substring.equals("AM") && temp == 12) {
				System.out.println("00:"+ timeArray[1] + ":"
						+ timeArray[2].substring(0, Math.min(timeArray[2].length(), 2)));
			}

			if (substring.equals("PM")) {
				if (temp < 12) {
					temp = temp + 12;
				}
				System.out.println(temp + ":" + timeArray[1] + ":"
						+ timeArray[2].substring(0, Math.min(timeArray[2].length(), 2)));

			}

			if (substring.equals("AM")  && temp <12) {
				System.out.println(timeArray[0] + ":" + timeArray[1] + ":"
						+ timeArray[2].substring(0, Math.min(timeArray[2].length(), 2)));

			}

		}

	}
}
