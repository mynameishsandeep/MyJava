package com.sample.datastructure.tree.dfs;

/**
 * https://www.youtube.com/watch?v=xouin83ebxE
 *
 */
public class NQueenProblem {
	static class Positions {
		int row;
		int col;

		public Positions(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) {
		Integer n = 4;
		Positions pos[] = new Positions[n];
		solveNQueen(n, 0, pos);

		for (int i = 0; i < pos.length; i++) {
			System.out.println(pos[i].row + " " + pos[i].col);
		}

	}

	public static Boolean solveNQueen(Integer n, Integer row, Positions[] pos) {
		if (n == 0) {
			return true;
		} else {
			for (int col = 0; col < n; col++) {
				if (isValid(pos, row, col)) {
					pos[row] = new Positions(row, col);
					if (solveNQueen(n, row + 1, pos)) {
						return true;
					}

				}
			}
		}
		return false;
	}

	public static Boolean isValid(Positions positions[], Integer row, Integer col) {
		for (int queen = 0; queen < row; queen++) {
			if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col
					|| positions[queen].row + positions[queen].col == row + col) {
				return false;
			}
		}
		return true;
	}
}
