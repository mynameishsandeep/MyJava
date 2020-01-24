package com.interview.leetcode.apple.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Constraints
1) No negative number
2) Number will be assembled from 1 to n.
3) There can be 1 or more missing number
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

========================Solution Approach1 - Two pass with Negate Approach.==================================
1) Negate the value of index at each iteration

[4, 3, 2, 7, 8, 2, 3, 1]
[4, 3, 2, -7, 8, 2, 3, 1]     --> i=0, value at index 3 negated.
[4, 3, -2, -7, 8, 2, 3, 1]    --> i=1, value at index 2 negated.
[4, -3, -2, -7, 8, 2, 3, 1]   --> i=2, value at index 1 negated.
[4, -3, -2, -7, 8, 2, -3, 1]  --> i=3, value at index 6 negated.
[4, -3, -2, -7, 8, 2, -3, -1] --> i=4, value at index 7 negated.
[4, -3, -2, -7, 8, 2, -3, -1] --> i=5, value at index 2 negated 2nd time.
[4, -3, -2, -7, 8, 2, -3, -1] --> i=6, value at index 3 negated 2nd time.
[-4, -3, -2, -7, 8, 2, -3, -1]--> i=7, value at index 0 negated.

2) In the second pass value > 0 will be the solution.

========================Solution Approach2 - Two Pass with in-place sort===========
1) In first pass swap, Move the data to their corresponding index by in-place sort.
2) In Second pass, if a number and index not matches, then it goes in result.
			[4,3,2,7,8,2,3,1]
			[7,3,2,4,8,2,3,1]
			[3,3,2,4,8,2,7,1]
			[2,3,3,4,8,2,7,1]
			[3,2,3,4,8,2,7,1]
			[3,2,3,4,1,2,7,8]
			[1,2,3,4,3,2,7,8]
This sorting code is also good, for a given requirement of data 1 to n to sort.
 			========2 loops are needed. But still time complexity is O(n)===========
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/93007/Simple-Java-In-place-sort-solution

=========================
*/
public class FindAllNumbersDisappearedInAnArray {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> ret = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]) - 1;
      if (nums[val] > 0) {
        nums[val] = -nums[val];
      }
    }
    System.out.println(Arrays.toString(nums));
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        ret.add(i + 1);
      }
    }
    return ret;
  }

  public List<Integer> findDisappearedNumbersModifiedToUnderStandWhileCondition(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int swapNumber1 = nums[i];
      int swapNumber2 = nums[nums[i] - 1];
      /*
       * 1st condition: if number is already in right position, then no swap needed
       * 2nd condition: check that the number with which we are going to swap is not the same as we already have (avoid infinite loop)
       */
      while (nums[i] - 1 != i && swapNumber1 != swapNumber2) {
        // swap number
        nums[i] = swapNumber2;
        nums[swapNumber1 - 1] = swapNumber1;
        // replace new values
        swapNumber1 = nums[i];
        swapNumber2 = nums[nums[i] - 1];
      }
    }
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        res.add(i + 1);
      }
    }
    return res;
  }
}
