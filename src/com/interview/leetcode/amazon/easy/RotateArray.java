package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/rotate-array/
 *===========================================
 * Rotate in-memory
 * 1) nums = [1,2,3,4,5,6,7] and k = 3,
 * 2) first we reverse 0 to n-k data i.e.....[1,2,3,4], it becomes[4,3,2,1];
 * 3) then we reverse n-k to n i.e.....[5,6,7], it becomes[7,6,5],
 * 4) finally we reverse the array as a whole, it becomes [5,6,7,1,2,3,4].
 */
public class RotateArray {

  public void rotate(int[] nums, int k) {
    if (nums == null || nums.length < 2) {
      return;
    }
    // If the number of rotation is more than n. Then rotation = rotation%size of data.
    k = k % nums.length;

    reverse(nums, 0, nums.length - k - 1);
    reverse(nums, nums.length - k, nums.length - 1);
    reverse(nums, 0, nums.length - 1);
  }

  private void reverse(int[] nums, int start, int end) {
    for (; start < end; start++, end--) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
    }
  }

  /*
   * Below is a simple recursion logic similar to "ReverseAString"
   * 1) During forward recursion save element of array in variable.
   * 2) When it comes back replace it in kth index.
   * ===Note: I cannot keep the same array. because if it is not a swap.
   * ie. if i place 0th to 4th. 4th is gone. 1st to 5th. 5th is gone. 2nd to 6th. 6th is gone.
   * Ex: nums = [1,2,3,4,5,6,7] and k = 3,
   * result : [5,6,7,1,2,3,4].
   * Recursion stack how it works
   * 		e=7		||  		↑↑			nums[2]=7
   * 		e=6		||  		||			nums[1]=6
   * 		e=5		Top  		Bottom		nums[0]=5
   * 		e=4		To 			To          nums[6]=4
   * 		e=3		Bottom  	Top	    	nums[5]=3
   * 		e=2		||  		||			nums[4]=2
   * 		e=1		↓↓  		||			nums[3]=1 --> Base Condition met
   */
  public void rotateRecur(int[] nums, int k) {
    recur(nums, k, nums.length - 1, nums[nums.length - 1]);
  }

  public void recur(int[] nums, int k, int n, int e) {
    if (n == 0) {
      nums[(n + k) % nums.length] = e;
      return;
    }
    recur(nums, k, n - 1, nums[n - 1]);
    nums[(n + k) % nums.length] = e;
  }
}
