package Algorithm_Implementation;

import java.util.Scanner;

public class ACMICPCTeam {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String[] acmTeam = (input.nextLine()).split(" ");

		int N = Integer.parseInt(acmTeam[0]);
		int M = Integer.parseInt(acmTeam[1]);
		byte[][] teams = new byte[N][M];

		for (int i = 0; i < N; i++) {
			char[] temp = (input.nextLine()).toCharArray();
			for (int j = 0; j < M; j++) {
				teams[i][j] = (byte) (temp[j] - '0');
			}
		}

		int maxTeams = 0;
		int maxTopic = 0;

		for (int i = 0; i < N; i++) {

			for (int j = i + 1; j < N; j++) {
				int count = 0;

				for (int k = 0; k < M; k++) {

					count += teams[i][k] | teams[j][k];
				}

				if (maxTopic < count) {
					maxTopic = count;
					maxTeams = 1;
				}

				else if (count == maxTopic) {
					maxTeams++;
				}

			}
		}
		System.out.println(maxTopic);
		System.out.println(maxTeams);

	}
}
