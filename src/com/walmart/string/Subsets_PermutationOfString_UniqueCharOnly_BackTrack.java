package com.walmart.string;

import java.util.ArrayList;
import java.util.List;

/*
 * Input: "abc" Output: "", "a","b","c","ab", "ac", "bc","abc"
 * https://leetcode.com/problems/subsets/discuss/136415/A-Clean-Solution-with-Explanation-Accepted
 *
 * 1) Add Empty to result.
 * 2) Read a data. For the size of result. Append the data.
 * 3) Do Step2. Till all datas are read.
 *
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
public class Subsets_PermutationOfString_UniqueCharOnly_BackTrack {

  public static void main(String[] args) {
    Subsets_PermutationOfString_UniqueCharOnly_BackTrack p =
        new Subsets_PermutationOfString_UniqueCharOnly_BackTrack();
    int[] input = {1, 2, 3};
    System.out.println(p.subsets(input));
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    // Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
  }

  /*
   * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)?page=2
   */
  private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
    list.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
      tempList.add(nums[i]);
      backtrack(list, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }
}
