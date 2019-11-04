package com.walmart.string;

import java.util.ArrayList;
import java.util.List;

/*
 * Breadth First Search (BFS) approach
 *
 * Input: "abc" Output: "", "a","b","c","ab", "ac", "bc","abc"
 * https://leetcode.com/problems/subsets/discuss/136415/A-Clean-Solution-with-Explanation-Accepted
 *
 * 1) Add Empty to result.
 * 2) Read a data. For the size of result. Append the data.
 * 3) Do Step2. Till all datas are read.
=================Points To Note=============================================
For subsets queue logic will not work. Because it has to create new one and keep existing one.
Queue poll take off the existing one, which is wrong
===========================================

input nums = [1, 2, 3]
Initial powerSet:
[
	[]
]

When i == 0: Data = 1
[
	[],
	[1]
]
When i == 1: Data = 2
[
	[],
	[1],
	[2],
	[1, 2]
]
When i == 2: Data = 3
[
	[],
	[1],
	[2],
	[1, 2],
	[3],
	[1, 3]
	[2, 3],
	[1, 2, 3]
]
 *
 */
public class Subsets_PermutationOfString_UniqueCharOnly_Queue {

  /*
   *  O(2^N)--> 2 power N--> Ex: if n=3, then 8 is complexity
   */
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());
    for (int i = 0; i < nums.length; i++) {
      int size = subsets.size();
      for (int j = 0; j < size; j++) {
        List<Integer> updated = new ArrayList<>(subsets.get(j));
        updated.add(nums[i]);
        subsets.add(updated);
      }
    }
    return subsets;
  }
}
