package com.interview.leetcode.linkedin.medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/77655/Clean-Java-Code-Union-Find
 * 
 * 
If the graph is already in memory in adjacency list format, then DFS is slightly simpler and faster. 
 * 
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {

	public int countComponents(int n, int[][] edges) {
		int[] roots = new int[n];
		Arrays.fill(edges, -1);

		for (int[] edge : edges) {
			int root1 = find(roots, edge[0]);
			int root2 = find(roots, edge[1]);
			if (root1 != root2) {
				roots[root1] = root2; // union
				n--;
			}
		}
		return n;
	}

	public int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}
