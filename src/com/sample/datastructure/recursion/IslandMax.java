package com.sample.datastructure.recursion;

/*
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * 
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class IslandMax {

	public int maxAreaOfIsland(int[][] grid) {

		int isProcessed[][] = new int[grid.length][grid[0].length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1 && !isProcessed(isProcessed, i, j)) {
					int result = permute(grid, isProcessed, i, j, grid.length - 1, grid[0].length - 1, 0);
					if (max < result) {
						max = result;
					}
				}
			}
		}
		return max;
	}

	public boolean isProcessed(int isProcessed[][], int row, int col) {
		return 1 == isProcessed[row][col];
	}

	public boolean isSafe(int row, int col, int rowMax, int colMax) {
		if (row > rowMax || col > colMax || row < 0 || col < 0) {
			return false;
		}
		return true;
	}

	public int permute(int[][] grid, int[][] isProcessed, int row, int col, int rowMax, int colMax, int islandSize) {
		if (!isSafe(row, col, rowMax, colMax)) {
			return islandSize;
		}
		if (isProcessed(isProcessed, row, col)) {
			return islandSize;
		}
		isProcessed[row][col] = 1;
		if (grid[row][col] == 1) {
			islandSize++;
		}

		if (grid[row][col] == 0) {
			return islandSize;
		}
		islandSize = permute(grid, isProcessed, row, col + 1, rowMax, colMax, islandSize);
		islandSize = permute(grid, isProcessed, row, col - 1, rowMax, colMax, islandSize);
		islandSize = permute(grid, isProcessed, row + 1, col, rowMax, colMax, islandSize);
		islandSize = permute(grid, isProcessed, row - 1, col, rowMax, colMax, islandSize);
		return islandSize;
	}

	public static void main(String[] args) {
		int[][] input = { 
				{ 1, 1, 0, 0, 0 }, 
				{ 1, 1, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 0 }, 
				{ 0, 0, 0, 1, 1 }, };
		IslandMax i = new IslandMax();
		System.out.println(i.maxAreaOfIsland(input));
	}
}