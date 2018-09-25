package com.sample.datastructure.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/friend-circles/description/
 * 
 * 1) Fill the AdjMatrix List
 * 2) If entry is not visited. DFS all the connected list and set visited True.
 * 
 * Note: Forming adjMatrix is list not needed as the matrix already has that. 
 * See solution FriendsCircles_Efficient, similar to island problem
 */
public class FriendCircles {
	public void fillAdjMatrix(Map<Integer, List<Integer>> map, int[][] M) {
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				// considering row as person
				if (1 == M[i][j]) {
					if (map.containsKey(i)) {
						map.get(i).add(j);
					} else {
						map.put(i, new ArrayList<>(Arrays.asList(j)));
					}
				}
			}
		}
	}

	public int findCircleNum(int[][] M) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		fillAdjMatrix(map, M);
		boolean isVisited[] = new boolean[M.length];
		int friendCircle = 0;
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			if (!isVisited[entry.getKey()]) {
				friendCircle++;
				dfs(isVisited, entry.getValue(), map);
			}
		}
		return friendCircle;
	}

	public void dfs(boolean isVisited[], List<Integer> friends, Map<Integer, List<Integer>> map) {
		for (Integer i : friends) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				dfs(isVisited, map.get(i), map);
			}
		}
	}
}
