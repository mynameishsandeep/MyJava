package com.yahoo.array;

public class Print2DArray {

	public static void main(String[] args) {
		int input[][] = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		
		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input[0].length; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println("");
		}

	}
}
