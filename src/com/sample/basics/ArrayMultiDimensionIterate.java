package com.sample.basics;

public class ArrayMultiDimensionIterate {
	public static void main(String[] args) {

		int a[][] = { { 1, 2 }, { 3, 4 } };

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.println(a[i][j]);
			}
		}
	}
}
