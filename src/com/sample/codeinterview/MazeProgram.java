package com.sample.codeinterview;

import java.util.Stack;

public class MazeProgram {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int travelledAlready[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

	public static void main(String[] args) {
		int a[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 0, 1 } };

		System.out.println(findMinNumSteps(a, 2, 1));
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int findMinNumSteps(int[][] maze, int exitRow, int exitCol) {
		Stack<Node> stack = new Stack<>();
		Node n = new Node(0, 0);
		stack.push(n);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			int i = node.x;
			int j = node.y;
			if (travelledAlready[i][j] == 0) {
				if (movableLeftToRight(maze, i, j)) {
					Node node1 = new Node(i,++j);
					stack.push(node1);
				}
				if (movableRightToLeft(maze, i, j)) {
					Node node1 = new Node(i,--j);
					stack.push(node1);
				}

				if (movableTopToBottom(maze, i, j)) {
					Node node1 = new Node(++i,j);
					stack.push(node1);
				}
				if (movableBottomToTop(maze, i, j)) {
					Node node1 = new Node(--i,j);
					stack.push(node1);
				}
			}
			travelledAlready[i][j] = 1;
		}

		return -1;
	}

	public static boolean movableLeftToRight(int[][] maze, int i, int j) {
		return maze[i][++j] == 0;
	}

	public static boolean movableRightToLeft(int[][] maze, int i, int j) {
		return maze[i][--j] == 0;
	}

	public static boolean movableTopToBottom(int[][] maze, int i, int j) {
		return maze[++i][j] == 0;
	}

	public static boolean movableBottomToTop(int[][] maze, int i, int j) {
		return maze[--i][j] == 0;
	}

}