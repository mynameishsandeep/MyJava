package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
* https://leetcode.com/problems/subsets-ii
*
* https://www.educative.io/collection/page/5668639101419520/5671464854355968/5654100301578240
*
* ======
* Same Logic as subset problem.
*
* If found a duplicate (i.e., when the current and the previous numbers are same), instead of
* adding the current number (which is a duplicate) to all the existing subsets,
* only add it to the subsets which were created in the previous step.
* ======
* Input: [5,5,5,5,5]
  Output: [[],[5],[5,5],[5,5,5],[5,5,5,5],[5,5,5,5,5]]

  ======Solution to prevent duplicate=======
  Cache the previous size and change the startindex to previous  "size"
  =============
  
*/
public class SubsetsII {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    // sort the numbers to handle duplicates
    Arrays.sort(nums);
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());
    int startIndex = 0;
    int size = 0;
    for (int i = 0; i < nums.length; i++) {
      startIndex = 0;
      // if current and the previous elements are same, create new subsets only from the subsets
      // added in the previous step
      if (i > 0 && nums[i] == nums[i - 1]) startIndex = size;
      size = subsets.size();
      for (int j = startIndex; j < size; j++) {
        // create a new subset from the existing subset and add the current element to it
        List<Integer> set = new ArrayList<>(subsets.get(j));
        set.add(nums[i]);
        subsets.add(set);
      }
    }
    return subsets;
  }
}
