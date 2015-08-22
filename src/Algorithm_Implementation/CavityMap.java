package Algorithm_Implementation;

import java.util.Scanner;


public class CavityMap {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		int n = Integer.parseInt(input.nextLine());
		char[][] matrix = new char[n][n];
		
		for(int i = 0; i<n; i++) {
			char[] tempArray = (input.nextLine()).toCharArray();
			
			for(int j =0; j <n;j++) {
				matrix[i][j] = tempArray[j];
			}
		}
		
		
		for(int i =1; i<n-1; i++) {
			for(int j = 1; j <n-1; j++) {
			
				int Curent = Character.getNumericValue(matrix[i][j]);
	
				int a = Character.getNumericValue(matrix[i-1][j]);
				int b = Character.getNumericValue(matrix[i+1][j]);
				int c = Character.getNumericValue(matrix[i][j-1]);
				int d = Character.getNumericValue(matrix[i][j+1]);

				
				if(Curent > a && Curent > b && Curent > c && Curent > d ) {
					matrix[i][j] = 'X';
				}
			}
		}
	
		for(int i =0; i<n;i++) {
			for(int j=0;j<n;j++) {
			System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	
	

}
