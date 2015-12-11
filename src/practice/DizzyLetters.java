package practice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class DizzyLetters {
	public static void main(String[] args) throws IOException {
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		String line;
		ArrayList<String> lines = new ArrayList<String>();
		int max = 0;
		line = bi.readLine();
		while (line != null && line.length() != 0) {
			lines.add(line);
			line = bi.readLine();
			int len= line.length();
			max = Math.max(max, len);
		}
		processLine(lines, max);

	}

	static void processLine(ArrayList<String> lines, int max) {

		int m = lines.size() - 1;
		int n = lines.get(1).length();
		char[][] matrix = new char[m][n];
		int R = Integer.parseInt(lines.get(0));

		R = (R / 90) % 4;

		for (int i = 0; i < m; i++) {
			String temp = lines.get(i + 1);
			for (int j = 0; j < max; j++) {
				if (temp.length() < max && j == temp.length()) {
					matrix[i][j] = '\0';
				} else {
					matrix[i][j] = temp.charAt(j);

				}
			}
		}

		char[][] result = rotate(matrix, R);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(result[i][j]);
			}
		}
		
		for (int i = 0; i < m; i++) {
			String temp = lines.get(i+1);
			for (int j = 0; j < n; j++) {
				matrix[i][j] = temp.charAt(j);
			}
			System.out.println();
		}

	}

	private static char[][] rotate(char[][] matrix, int r) {

		char[][] output = null;
		int m = matrix.length;
		int n = matrix[0].length;
		char[][] result = rotate(matrix, m, n, r);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(result[i][j]);
				System.out.print(" ");

			}
			System.out.println();
		}
        return result;

}
	
	
	private static char[][] rotate(char[][] matrix, int m, int n, int r) {
		
		char[][] output = null;
		
		while (r > 0) {
			output = new char[n][m];

			for (int i = 0; i < m; i++) {

				for (int j = 0; j < n; j++) {

					output[j][m - 1 - i] = matrix[i][j];

				}

			}
			r--;
			matrix = output;
		}

		return output;

	}
}
