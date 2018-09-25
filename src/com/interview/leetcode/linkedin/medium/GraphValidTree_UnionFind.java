package com.interview.leetcode.linkedin.medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/graph-valid-tree/discuss/69018/AC-Java-Union-Find-solution
 * 
 * 
 */
public class GraphValidTree_UnionFind {

	public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        if(edges.length != n-1){
            return false;
        }
        // perform union find
        for (int[] edge : edges) {
            int x = find(nums, edge[0]);
            int y = find(nums, edge[1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            nums[x] = y;
        }
        return true;
    }
    
    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }

	public static void main(String[] args) {
		GraphValidTree_UnionFind g = new GraphValidTree_UnionFind();
		int i[][]= new int[5][];
		i[0] = new int[]{0,1};
		i[1] = new int[]{0,2};
		i[2] = new int[]{0,3};
		i[3] = new int[]{1,4};
		
		g.validTree(5, i);
	}
}
