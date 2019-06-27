package com.interview.leetcode.facebook.medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/is-graph-bipartite/description/
 * 
 * https://www.geeksforgeeks.org/bipartite-graph/
 * 
0: Haven't been colored yet.
1: Red.
-1: Blue.

1. Assign RED color to the source vertex(0th node) (putting into set U).
2. Color all the neighbors with BLUE color (putting into set V).
3. Color all neighbor’s neighbor with RED color (putting into set U).
4. This way, assign color to all vertices.
5. While assigning colors, if we find a neighbor which is colored with different color as current vertex,
then graph is not Bipartite.


 */
public class IsGraphBipartite {

	public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] colors = new int[n];

		for (int i = 0; i < n; i++) { //This graph might be a disconnected graph. So check each unvisited node.
			if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
				return false;
			}
		}
		System.out.println(Arrays.toString(colors));
		return true;
	}

	public boolean validColor(int[][] graph, int[] colors, int color, int node) {
		if (colors[node] != 0) {
			System.out.println("Node " + node + " Already Visited and color is " + colors[node]);
			return colors[node] == color;
		}
		System.out.println("Visiting UnVisited Node " + node + " and setting color to " + color);
		colors[node] = color;
		for (int next : graph[node]) {
			if (!validColor(graph, colors, -color, next)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsGraphBipartite i = new IsGraphBipartite();
		int input[][] = new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
		i.isBipartite(input);
	}
}
