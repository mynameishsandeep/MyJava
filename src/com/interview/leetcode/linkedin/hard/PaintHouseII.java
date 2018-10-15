package com.interview.leetcode.linkedin.hard;

/*
 * https://leetcode.com/problems/paint-house-ii/description/
 * 
 * In PaintHouse, number of row(color) is fixed and number of house is not fixed. Here m color and n houses both are not fixed. 

Read PaintHouse.java.

 The brute-force way of doing above logic is 
 For a single column, iterate all previous column (skipping current column) and get min.
 This will make nSquare operation for each column of row. To avoid that min1 and min2 is calculated by iterating once for each row. 

1) Only different logic from PaintHouse is, 
 Need to get minimum from previous row, skipping current column of previous row. 
 To do that Keeping min1 and min2 so that it covers minimum of all the column.
  Ex : 
  1 2 3
  4 5 6 -->  from previous row, min1 is 1 and min2 is 2
  
  So when doing calculation, 
  1 is skipped for 4 and 2 is used 
  2 is skipped for 5 and 1 is used
  1 is again used for 6 because index not matched. 
 

 *
 *
 */
public class PaintHouseII {
	class Min1Min2 {
		int min1;
		int min1Index;
		int min2;
		int min2Index;

		public Min1Min2(int min1, int min1Index, int min2, int min2Index) {
			this.min1 = min1;
			this.min1Index = min1Index;
			this.min2 = min2;
			this.min2Index = min2Index;
		}
	}

	/*
	 *  Min2 needs to be updated in 3 case.
	 *  1) When Min1 is updated
	 *  2) When Min2 lies between Min1 and Min2
	 *  3) In the beginning when min2 is -1 
	 */
	public Min1Min2 getMin1Min2FromPrevRow(int costs[][], int prevRow) {
		int min1 = costs[prevRow][0];
		int min1Index = 0;
		int min2 = -1;
		int min2Index = -1;
		for (int j = 1; j < costs[0].length; j++) {
			if (costs[prevRow][j] < min1) {
				min2 = min1;
				min2Index = min1Index;
				min1 = costs[prevRow][j];
				min1Index = j;
				continue;
			}
			//Update Min2, when min2 is -1 or when min2 lies between Min1 and Min2
			if (min2 == -1 || (min2 > costs[prevRow][j] && min1 != min2)) {
				min2 = costs[prevRow][j];
				min2Index = j;
			}
		}
		return new Min1Min2(min1, min1Index, min2, min2Index);
	}

	// Save Min1Min2 per row
	public int minCostII(int[][] costs) {

		if (costs == null || costs.length == 0) {
			return 0;
		}
		// Start from 1st row keeping 0th row as base.
		for (int i = 1; i < costs.length; i++) {
			Min1Min2 m = getMin1Min2FromPrevRow(costs, i - 1);
			for (int j = 0; j < costs[0].length; j++) {
				if (m.min1Index != j) {
					costs[i][j] = costs[i][j] + m.min1;
				} else {
					costs[i][j] = costs[i][j] + m.min2;
				}
			}
		}

		return getMinResultFromLastRow(costs);
	}

	public int getMinResultFromLastRow(int[][] costs) {
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < costs[0].length; j++) {
			if (min > costs[costs.length - 1][j]) {
				min = costs[costs.length - 1][j];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		PaintHouseII p = new PaintHouseII();
		//int costs[][] = { { 1, 5, 3 }, { 2, 9, 4 }, { 4, 2, 5 }, { 1, 4, 6 } };
		int costs[][] = { { 1, 5, 3 }, { 2, 9, 4 } };
		System.out.println(p.minCostII(costs));
	}
}
