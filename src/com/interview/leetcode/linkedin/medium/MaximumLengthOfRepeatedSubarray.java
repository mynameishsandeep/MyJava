package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 * 
 * 1) Fill the 0th row and 0th column with 0.
 * 2) if matches for a character 1 + diagonal result.
 * 
 * Tricky would be visualizing array matrix against array
 */
public class MaximumLengthOfRepeatedSubarray {

	/*
	  1  2   3   2   1
	=================    
	0  0  0   0   0   0    
	3||0  0  0   1   0   0
	2||0  0  1   0   2   0
	1||0  1  0   0   0   3
	4||0  
	7||0
	*/
	public int findLength(int[] A, int[] B) {
		int dp[][] = new int[A.length + 1][B.length + 1];
		int max = 0;
		for (int i = 0; i < A.length + 1; i++) {
			for (int j = 0; j < B.length + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (A[i - 1] == B[j - 1]) {
					//System.out.println(A[i-1]);
					dp[i][j] = 1 + dp[i - 1][j - 1];
					max = dp[i][j] > max ? dp[i][j] : max;
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return max;
	}

}
