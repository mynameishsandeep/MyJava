package com.yahoo.dynamicprogramming;

/*
 * https://www.youtube.com/watch?v=K20Tx8cdwYY
 */
public class GroupSum {

	public static void main(String[] args) {
		GroupSum g = new GroupSum();
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
		for(int i=1; i<=nums.length; i++) {
			for(int j=1; j<=target; i++) {
				mm[i][j] = mm[i-1][j];
				int currentSubSetValue = nums[i-1];
				if(j>currentSubSetValue) {
					mm[i][j] = mm[i-1][j] || mm[i-1][currentSubSetValue]; 
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
