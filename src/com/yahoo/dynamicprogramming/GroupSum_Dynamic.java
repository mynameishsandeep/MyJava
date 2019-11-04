package com.yahoo.dynamicprogramming;

/*
 * https://www.youtube.com/watch?v=K20Tx8cdwYY
 *
 * 1) Form 2 dimensional array.
 * with target+1 number of columns. ex: for 6 (0 to 6)
 * and nums[].length + 1 of rows ex: for 1,2,3,4 (0,1,2,3,4)
 * 2) Set first row to false.. Meaning with 0 nothing can be formed.
 * 3) Set first column of all rows to true. Meaning 0 can be formed without any number.

				0	  1		 2		3	  4		  5		6
			================================================
{0}			||true, false, false, false, false, false, false
{0,1}		||true, true,  false, false, false, false, false
{0,1,2}		||true, true,  true,  true,  false, false, false
{0,1,2,3}	||true, true,  true,  true,  true,  true,  true
{0,1,2,3,4}	||true, true,  true,  true,  true,  true,  true

==============================
currentNumber = weight newly added to set
currentTarget = j value. Moving target
condition 1) currentNumber equals currentTarget --> set dp[i][j] to true.
condition 2) currentNumber greater than currentTarget -->  fill dp[i][j] from previous(Top).
condition 3) currentNumber less than currentTarget --> dp = previous(Top) || previousNegatedValue)
=================
 */
public class GroupSum_Dynamic {

  public boolean groupSum(int[] nums, int target) {
    boolean[][] dp = new boolean[nums.length + 1][target + 1];
    fill1stColumnsToTrue(dp);

    for (int i = 1; i <= nums.length; i++) {
      int currentNumber = nums[i - 1];
      for (int j = 1; j <= target; j++) { // j is the currentTarget now.
        if (currentNumber == j) dp[i][j] = true;
        else if (currentNumber > j)
          dp[i][j] = dp[i - 1][j]; // fill previous value from top and not from left
        else {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - currentNumber];
        }
      }
    }
    return dp[nums.length][target];
  }

  private void fill1stColumnsToTrue(boolean mm[][]) {
    for (int i = 0; i < mm.length; i++) {
      mm[i][0] = true;
    }
  }

  public static void main(String[] args) {
    GroupSum_Dynamic g = new GroupSum_Dynamic();
    int target = 6;
    int nums[] = {1, 2, 3, 4};

    System.out.println(g.groupSum(nums, target));
  }
}
