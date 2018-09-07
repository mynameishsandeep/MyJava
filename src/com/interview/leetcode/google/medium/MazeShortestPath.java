package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/the-maze/description/

 * 1) Navigate from start position and traverse 4 direction
 * 2) Mark Visited node to true whenever navigation is finished for a position.
 * 3) Place traversed 4 direction in stack or queue and iterate till stack or queue is empty.
 * 4) Check destination reached before loop
 */
public class MazeShortestPath {
	/*
	 * 1) Navigate from start position and traverse 4 position
	 * 2) Mark Visited node to true whenever navigation is finished for a position.
	 * 3) Place traversed 4 position in stack or queue and iterate till stack or queue is empty.
	 * 4) Check destination reached before loop
	 * 
	 * Note: 
	 */
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
		// Queue or Stack both will work 
		Queue<int[]> queue = new LinkedList<>();
		boolean visited[][] = new boolean[maze.length][maze[0].length];
		List<Integer> result = new ArrayList<>();
		int newStart[] = { start[0], start[1], 0 };
		queue.offer(newStart);
		while (!queue.isEmpty()) {
			newStart = queue.poll();
			int i = newStart[0];
			int j = newStart[1];
			int k = newStart[2];
			if (destination[0] == i && destination[1] == j) {
				result.add(k);
			}
			if (!visited[i][j]) {
				while (movableLeftToRight(maze, i, j)) {
					++j;
					k++;
				}
				queue.offer(new int[] { i, j, k });

				j = newStart[1]; // j updated so assigning back
				k = newStart[2];
				while (movableRightToLeft(maze, i, j)) {
					--j;
					k++;
				}
				queue.offer(new int[] { i, j, k });

				j = newStart[1];// j updated so assigning back
				k = newStart[2];

				while (movableTopToBottom(maze, i, j)) {
					++i;
					k++;
				}
				queue.offer(new int[] { i, j, k });

				i = newStart[0];// i updated so assigning back
				k = newStart[2];

				while (movableBottomToTop(maze, i, j)) {
					--i;
					k++;
				}
				queue.offer(new int[] { i, j, k });

				i = newStart[0];// i updated so assigning back
			}
			visited[i][j] = true;
		}

		return Collections.min(result);
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
		MazeShortestPath m = new MazeShortestPath();
		int maze[][] = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		int start[] = { 0, 4 };
		int destination[] = { 4, 4 };

		System.out.println(m.shortestDistance(maze, start, destination));
	}
}
