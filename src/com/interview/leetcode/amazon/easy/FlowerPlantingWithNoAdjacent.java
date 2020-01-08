package com.interview.leetcode.amazon.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
 *

https://leetcode.com/problems/flower-planting-with-no-adjacent/

1) There are total of 4 flowers.
2) Plant flower "A" in garden "1".
3) If "1" is connected to "2", then "A" cannot be planted in garden "2".

So for below input.
Input: N = 4, paths = [[1,2],[3,4]]
Output: [1,2,1,2]
Output: [1,2,3,4]
Output: [1,2,3,1] and many more valid combinations are possible.
===BruteForce when N<=4.==Sending 1 2 3 4 back to result================
			int[] result = new int[N];
            for(int i=0; i<N; i++) result[i] = (i%4)+1;
            return result;
=====================See Diagram FlowerPlantingWithNoAdjacent.png=================

5
[[4,1],[4,2],[4,3],[2,5],[1,2],[1,5]]
Output: [1,2,1,3,3]

=====================================

6
[[6,4],[6,1],[3,1],[4,5],[2,1],[5,6],[5,2]]

Output:[1,2,2,1,3,2]
======================================

=======Solution Approach====Graph Coloring Approach=========================
1) For each garden save connected garden in Set as a Map(adjMatrix Map).
2) For Each Garden. Get the connected garden.
======3) Coloring Logic. There can be 4 flowers can be planted in any garden.=====
So create a set with 4 flowers named availableFlowers.
4) If a garden's dependency garden has any of 4 flower remove that flower from the available flower.
5) Now any of remaining flower can be planted on that garden.
===========================================
Coloring logic is about creating that set with all the possible options.
Then removing the invalid.
=========================

 */
public class FlowerPlantingWithNoAdjacent {
  public int[] gardenNoAdj(int N, int[][] paths) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 1; i <= N; i++) map.put(i, new HashSet<>());

    for (int[] edge : paths) {
      map.get(edge[0]).add(edge[1]);
      map.get(edge[1]).add(edge[0]);
    }

    int[] ans = new int[N];
    for (int i = 1; i <= N; i++) {
      Set<Integer> availableFlowers =
          Arrays.asList(1, 2, 3, 4).parallelStream().collect(Collectors.toSet());
      Set<Integer> connectedGardens = map.get(i);
      for (int connectedGarden : connectedGardens) {
        Integer connectedGardenFlower = ans[connectedGarden - 1];
        if (availableFlowers.contains(connectedGardenFlower))
          availableFlowers.remove(connectedGardenFlower);
      }
      ans[i - 1] = availableFlowers.iterator().next();
    }

    return ans;
  }
}
