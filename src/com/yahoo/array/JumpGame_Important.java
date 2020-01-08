package com.yahoo.array;

/*
 *
 * https://leetcode.com/problems/jump-game/

============Example 1:============
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
============Example 2:============
Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
==========================================================
 * 	Given an array of non-negative integers, you are initially positioned at the first index of the array.
	Each element in the array represents your maximum jump length at that position.
	Determine if you are able to reach the last index.

	Solution:
	0) current jump = current index + element value at current index.
	1) Iterate each element and make a note on how maximum it can jump.
	2) if max jump greater than current jump, don't do anything.
	3) if max jump less than current jump, update max jump with current jump.
	4) if max jump == current jump, return false, if current jump is zero. This is the exit condition.

	Solution Approach:
	1) initialize maxJumpIndex with 0. It represents the maximum index it can go.
	2) initialize currentJumpIndex with 0. It represents, for current index till where it can go.
	3) currentJumpIndex = currentIndex + value at currentIndex.
	4) For each element, compare currentJumpIndex with maxJumpIndex.
	5) if maxJumpIndex less than currentJumpIndex, then update maxJumpIndex with currentJumpIndex.
	6) if maxJumpIndex == currentJumpIndex. Then check for Exit Condition: if 0 on index then return false.

==========Note: Don't try to jump more than 1 element. Iterate element by element.==========
 */
public class JumpGame_Important {

  public static void main(String[] args) {
    System.out.println(canJump(new int[] {3, 3, 1, 0, 2, 0, 1}));
    System.out.println(canJump(new int[] {3, 3, 1, 0, 1, 0, 1}));
    System.out.println(canJump(new int[] {2, 3, 1, 1, 4}));
  }

  public static boolean canJump(int[] nums) {
    int maxJumpIndex = 0;
    int currentJumpIndex = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      currentJumpIndex = i + nums[i];
      if (maxJumpIndex < currentJumpIndex) {
        maxJumpIndex = currentJumpIndex;
      } else if (maxJumpIndex > currentJumpIndex) {
        // do nothing, already reached higher
      } else { // maxjumpIndex == currentJumpIndex
        // Exit Condition.. maxjumpIndex == currentJumpIndex and cannot go further
        if (0 == nums[i]) {
          return false;
        }
      }
      // Break at anypoint if end is reached or beyond end is reached
      if (maxJumpIndex >= nums.length - 1) {
        return true;
      }
    }
    return true;
  }
}
