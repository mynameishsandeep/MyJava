package com.walmart.string;

import java.util.Arrays;

/**
 * https://en.wikipedia.org/wiki/Longest_common_substring_problem
 *
 *	Can be solved by bruteforce or suffix tree or DP. Below is DP approach
 *
 *==============BruteForce==============
 * 1) Take all combination(continuous only) of search string and put it in map. 
 * Ex: a b c --> combination would be--> a,b,c,ab,bc,abc 
 * 2) For every substring, verify it exists in input string Ex: a b d. 
 * 3) Keep track of the maximum length substring. 
 * 4) There will be O(m^2) substrings and 
 * we can find whether a string is substring on another string in O(n). 
 * 5) So overall time complexity of this method would be O(n * m^2)
 *============DP========================
 *		String X = "ABC";
		String Y = "ABD";

		  0 A B C
	      =======
	 0 || 0 0 0 0
	 A || 0
	 B || 0
	 D || 0

		  0 A B C
	      =======
	 0 || 0 0 0 0
	 A || 0 1 0 0 
	 B || 0 0 2 0
	 D || 0 0 0 0

 * 1) The first row and first column entries, says for 0 "search string" for "input string" output is 0.
 * 2) If character matches then pick value diagonally and add1. Else 0.
 * ====Logically if a column matches and next column don't matches. It should pick the value from previous. But we put 0 only, don't confuse.=======
 * ====But in Longest Common Sub Sequence we pick previous value. Still it contradicts for 1 element comparism=========
 * 
 * 				a || 
 * 				======
 * 				  || current
 * 
 * current = a+1 if matches, else 0

 */
public class LongestCommonSubString_dp {
	static int lcs(char x[], char y[], int m, int n) {
		int dp[][] = new int[m + 1][n + 1];
		int result = 0; // To store length of the longest common substring

		// Following steps build dp[m+1][n+1] in bottom up fashion
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) { // Fill 0th row and 0th column with 0.
					// nothing to do.
				} else if (x[i - 1] == y[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					result = Integer.max(result, dp[i][j]);
				} 
				for(int[] d: dp) {
					System.out.println(Arrays.toString(d) ); 
				}
				System.out.println("done"); 
			}
		}
		return result;
	}

	// Driver Program to test above function
	public static void main(String[] args) {
		String X = "ABCDAF";
		String Y = "ZBCDF";

		int m = X.length();
		int n = Y.length();

		System.out.println("Length of Longest Common Substring is " + lcs(X.toCharArray(), Y.toCharArray(), m, n));
	}

}
