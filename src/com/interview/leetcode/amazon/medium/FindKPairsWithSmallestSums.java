package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
* 1) Save index in minHeap.
* 2) 0th index represents nums1. 1st index represents nums2.
* 3)
*
*
   [1,1,2]
   [1,2,3]
   10
   [[1,1],[1,1],[2,1],[1,2],[1,2],[2,2],[1,3],[1,3],[2,3]]
*/
public class FindKPairsWithSmallestSums {

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

    List<List<Integer>> kPairs = new ArrayList<>();
    int len1 = nums1.length, len2 = nums2.length;
    if (len1 == 0 || len2 == 0) return kPairs;

    // Min heap of indices of u, v.
    PriorityQueue<int[]> minHeap =
        new PriorityQueue<>(
            (a, b) -> Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]]));
    minHeap.add(new int[] {0, 0});

    while (k-- > 0 && !minHeap.isEmpty()) {
      int[] pairIndex = minHeap.poll();
      int i = pairIndex[0]; // nums1Index
      int j = pairIndex[1]; // nums2Index
      kPairs.add(Arrays.asList(nums1[i], nums2[j]));
      if (i + 1 < len1) minHeap.add(new int[] {i + 1, j}); // element available in nums1
      if (i == 0 && j + 1 < len2) minHeap.add(new int[] {i, j + 1}); // element available in nums2
    }

    return kPairs;
  }
}
