package com.interview.leetcode.google.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/the-maze/description/

 * 1) Navigate from start position and traverse 4 direction
 * 2) Mark Visited node to true whenever navigation is finished for a position.
 * 3) Place traversed 4 direction in stack or queue and iterate till stack or queue is empty.
 * 4) Check destination reached before loop
 * 
 * Note: Queue gives the best result. 
 */
public class Maze {
	/*
	 * 1) Navigate from start position and traverse 4 position
	 * 2) Mark Visited node to true whenever navigation is finished for a position.
	 * 3) Place traversed 4 position in stack or queue and iterate till stack or queue is empty.
	 * 4) Check destination reached before loop
	 */
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		// Queue or Stack both will work 
		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(start);
		boolean visited[][] = new boolean[maze.length][maze[0].length];
		while (!stack.isEmpty()) {
			start = stack.pop();
			int row = start[0];
			int col = start[1];
			if (destination[0] == row && destination[1] == col) {
				return true;
			}
			if (!visited[row][col]) {
				while (movableLeftToRight(maze, row, col)) {
					++col;
				}
				stack.push(new int[] { row, col });

				col = start[1]; // column updated so assigning back
				while (movableRightToLeft(maze, row, col)) {
					--col;
				}
				stack.push(new int[] { row, col });

				col = start[1];// column updated so assigning back
				while (movableTopToBottom(maze, row, col)) {
					++row;
				}
				stack.push(new int[] { row, col });

				row = start[0];// row updated so assigning back
				while (movableBottomToTop(maze, row, col)) {
					--row;
				}
				stack.push(new int[] { row, col });

				row = start[0];// row updated so assigning back
			}
			visited[row][col] = true;
		}

		return false;
	}

	public static boolean movableLeftToRight(int[][] maze, int i, int j) {
		// Verify the Boundary on Left To Right
		if (j + 1 > (maze[0].length - 1)) {
			return false;
		}
		return maze[i][++j] == 0;
	}

	public static boolean movableRightToLeft(int[][] maze, int i, int j) {
		// Verify the Boundary on Right To Left
		if (j - 1 < 0) {
			return false;
		}
		return maze[i][--j] == 0;
	}

	public static boolean movableTopToBottom(int[][] maze, int i, int j) {
		// Verify the Boundary on Top To Bottom
		if (i + 1 > maze.length - 1) {
			return false;
		}
		return maze[++i][j] == 0;
	}

	public static boolean movableBottomToTop(int[][] maze, int i, int j) {
		// Verify the Boundary on Bottom To Top
		if (i - 1 < 0) {
			return false;
		}
		return maze[--i][j] == 0;
	}

	public static void main(String[] args) {
		Maze m = new Maze();
		int maze[][] = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		int start[] = { 0, 4 };
		int destination[] = { 4, 4 };

		System.out.println(m.hasPath(maze, start, destination));
	}
}
