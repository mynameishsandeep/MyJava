package com.yahoo.dynamicprogramming;

/*
 * https://www.youtube.com/watch?v=K20Tx8cdwYY
 * 
 * 1) Form 2 dimensional array.
 * with target+1 number of columns. ex: for 12 (0 to 12)
 * and nums[].length + 1 of rows ex: for 2,4,8 (0,2,4,8)
 * 2) Set first row to 0.. Meaning i cannot form anything with 0
 * 3) Set first column to 1. Meaning i can form the combination with same number.
 * 4) if row index>
 * 
 * 
 */
public class GroupSum_Dynamic {

	public static void main(String[] args) {
		GroupSum_Dynamic g = new GroupSum_Dynamic();
		int target = 12;
		int nums[] = { 2, 4, 8 };

		System.out.println(g.groupSum(nums, target));

		System.out.println(g.groupSum(nums, target));
	}

	/*
	 * There are 3 sets of data flowing here
	 * 1) row index.(0 to nums.length)
	 * 2) column index.(0 to target)
	 * 3) current subset value from nums[] array - row index  
	 */
	public boolean groupSum(int[] nums, int target) {
		// initialize memoization matrix 
		Boolean[][] mm = new Boolean[nums.length + 1][target + 1];
		fillFalseInFirstRow(mm);
		fillTrueInFirstColumn(mm);
		int n = nums.length;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= target; j++) {
				mm[i][j] = mm[i - 1][j];
				Integer currentSubSetValue = nums[i - 1];
				if (j >= currentSubSetValue) {
					mm[i][j] = (mm[i][j] || mm[i - 1][j - currentSubSetValue]);
				}
			}
		}
		return mm[nums.length][target];

	}

	private void fillFalseInFirstRow(Boolean mm[][]) {
		for (int i = 0; i < mm[0].length; i++) {
			mm[0][i] = false;
		}
	}

	private void fillTrueInFirstColumn(Boolean mm[][]) {
		for (int i = 0; i < mm.length; i++) {
			mm[i][0] = true;
		}

	}
}
