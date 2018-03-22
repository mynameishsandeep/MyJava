package com.interview.leetcode.google.easy;

/*
 * https://leetcode.com/problems/island-perimeter/description/
 */
public class FindIslandPerimeter {

	public static int islandPerimeter(int[][] grid) {
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					result = result + 4;
					if (i - 1 >= 0) {
						if (grid[i - 1][j] == 1) {
							result = result - 2;
						}
					}
					if (j - 1 >= 0) {
						if (grid[i][j - 1] == 1) {
							result = result - 2;
						}
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int input[][] = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(islandPerimeter(input));
	}
}
