package com.walmart.string;

//Java implementation of finding length of longest 
//Common substring using Dynamic Programming

/**
 * https://en.wikipedia.org/wiki/Longest_common_substring_problem
 *
 *	Can be solved by bruteforce or suffix tree or DP. Below is DP approach
 *
 *==============BruteForce==============
 * 1) Find all combination substrings of search string 
 * 2) For every substring verify it exists in input string. 
 * 3) Keep track of the maximum length substring. 
 * 4) There will be O(m^2) substrings and 
 * we can find whether a string is substring on another string in O(n). 
 * 5) So overall time complexity of this method would be O(n * m^2)
 */
public class LongestCommonSubString {
	/* 
	   Returns length of longest common substring  
	   of X[0..m-1] and Y[0..n-1] 
	*/
	static int LCSubStr(char X[], char Y[], int m, int n) {
		// Create a table to store lengths of longest common suffixes of
		// substrings. Note that LCSuff[i][j] contains length of longest
		// common suffix of X[0..i-1] and Y[0..j-1]. The first row and
		// first column entries have no logical meaning, they are used only
		// for simplicity of program
		int LCStuff[][] = new int[m + 1][n + 1];
		int result = 0; // To store length of the longest common substring

		// Following steps build LCSuff[m+1][n+1] in bottom up fashion
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) { // Fill 0th row and 0th column with 0.
					LCStuff[i][j] = 0;
				} else if (X[i - 1] == Y[j - 1]) {
					LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
					result = Integer.max(result, LCStuff[i][j]);
				} else
					LCStuff[i][j] = 0;
			}
		}
		return result;
	}

	// Driver Program to test above function
	public static void main(String[] args) {
		String X = "ABCDGH";
		String Y = "AEDFHR";

		int m = X.length();
		int n = Y.length();

		System.out.println("Length of Longest Common Substring is " + LCSubStr(X.toCharArray(), Y.toCharArray(), m, n));
	}

}
