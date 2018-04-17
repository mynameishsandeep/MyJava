package com.interview.leetcode.google.medium;

public class NumberOfIslands {
	public static void main(String[] args) {

		NumberOfIslands n = new NumberOfIslands();
		char input[][] = new char[][] { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1' } };

		System.out.println(n.numIslands(input));

	}

	public int numIslands(char[][] grid) {
		int numOfIslands = 0;
		if (grid.length == 0) {
			return 0;
		}
		boolean[][] isVisited = new boolean[grid.length][grid[0].length];
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				// Verify it is not visited
				if (!isVisited[row][col]) {
					// Verify it is land 
					if (grid[row][col] == '1') {
						numOfIslands++;
						// recursively fill isVisited
						fillIsVisited(row, col, grid, isVisited);

					}
				}
			}
		}
		return numOfIslands;
	}

	private void fillIsVisited(int row, int col, char[][] grid, boolean[][] isVisited) {
		if (!isValid(row, col, grid)) {
			return;
		}
		if (isVisited[row][col]) {
			return;
		}
		isVisited[row][col] = true;
		fillIsVisited(row, col + 1, grid, isVisited);
		fillIsVisited(row, col - 1, grid, isVisited);
		fillIsVisited(row - 1, col, grid, isVisited);
		fillIsVisited(row + 1, col, grid, isVisited);
	}

	private boolean isValid(int row, int col, char[][] grid) {
		return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] != '0';
	}
}
