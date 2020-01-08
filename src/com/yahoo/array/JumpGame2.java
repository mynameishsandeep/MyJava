package com.yahoo.array;

/*
 * https://leetcode.com/problems/jump-game-ii/
 *

2, 3, 1, 5, 1, 1, 1, 1, 1
Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
=========Solution Approach==============
1) At any-point there can be only one solution i.e 1minJump 
 */
public class JumpGame2 {
  public static void main(String[] args) {
    //System.out.println(jump(new int[] {3, 3, 1, 0, 2, 0, 1}));
    //System.out.println(jump(new int[] {2, 3, 1, 1, 4}));
    System.out.println(jump(new int[] {2, 3, 1, 5, 1, 1, 1, 1, 1}));
  }

  public static int jump(int[] nums) {
    int minJumpCount = 0;
    int prevJumpIndex = 0;
    int maxGoJumpIndex = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      maxGoJumpIndex = Math.max(maxGoJumpIndex, i + nums[i]);
      if (i == prevJumpIndex) {
        minJumpCount++;
        prevJumpIndex = maxGoJumpIndex;
      }
    }
    return minJumpCount;
  }
}
