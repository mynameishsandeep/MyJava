package com.sample.basics;

import java.util.Scanner;
import java.util.TreeSet;

public class HourGlass {

	private static final int x = 6;
	private static final int y = 6;

	public static void main(String[] args) {

		int arr[][] = new int[x][y];
		try (Scanner scan = new Scanner(System.in)) {
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					arr[i][j] = scan.nextInt();
				}
			}
		}

		TreeSet<Integer> outputTree = new TreeSet<>();
		for (int i = 0; i < x - 2; i++) {
			for (int j = 1; j < y-1; j++) {
				outputTree.add(arr[i][j - 1] + arr[i][j] + arr[i][j + 1] 
						+ arr[i + 1][j] + arr[i + 2][j -1] + arr[i + 2][j] + arr[i + 2][j + 1]);
			}
		}
		System.out.println(outputTree.last());

	}
}
