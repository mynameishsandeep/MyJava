package com.interview.leetcode.amazon.medium;

/*
 * https://leetcode.com/problems/find-the-duplicate-number/

https://leetcode.com/problems/find-the-duplicate-number/discuss/191309/Fast-slow-pointers-w-explanation-of-why-there-must-be-one-cycle

1) You must not modify the array (assume the array is read only).
2) You must use only constant, O(1) extra space.
3) Your runtime complexity should be less than O(n2).
4) There is only one duplicate number in the array, but it could be repeated more than once.
=====================Problem Understanding==============
1) If I sort the data, input data will be from "1 to N" for index "0 to N-1".
2) So one of the index is having wrong data.
Ex: input [ 2, 3, 3, 1 ]. Sorted data will be [1,2,3,3].  Index 3 should be having data 4.
3) One solution should be to sort data and check previous and current data.
4) But sorting takes O(n^2).
5) Now it is a graph problem with a cycle. See the diagram "FindDuplicateNumber.png"
====================Solution Approach - Graph View====================
1) Each index points to a node which is a graph link.
2) Use slow and fast pointer approach.
3) As per graph moving 1 step means taking the value at index which is pointing to another node.
4) Moving 2 time means doing step 3 twice.
5) When slow and fast meets it is a loop point.
6) Move fast to head.
7) Traverse slow and fast again. The meeting point is cycle point or duplicate data.


[ 2, 3, 3, 1 ]
Output:3
[2,1,3,4,1,6,7,8,9,1] ==> More than 1 duplicate example
Output:1
 */
public class FindTheDuplicateNumber {
  public int findDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int slow = nums[0], fast = nums[0];
    while (true) {
      slow = nums[slow];
      fast = nums[fast]; // fast = nums[nums[fast]]; 2 step can be avoided by this
      fast = nums[fast];
      if (slow == fast) {
        fast = nums[0];
        while (fast != slow) {
          slow = nums[slow];
          fast = nums[fast];
        }
        return fast;
      }
    }
  }
}
