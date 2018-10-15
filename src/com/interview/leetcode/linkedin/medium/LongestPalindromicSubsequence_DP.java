package com.interview.leetcode.linkedin.medium;

import java.util.Arrays;

/*
 *   For 5 letter character. Below is the "index" which will be compared 
 *   1) [0,0] [1,1] [2,2] [3,3] [4,4] ----> auto populate by comparing [i==j]--> meaning only 1 output when we have 1 character
 *   2) [0,1] [1,2] [2,3] [3,4]
 *   3) [0,2] [1,3] [2,4]
 *   4) [0,3] [1,4]
 *   5) [0,4]  
 *   
 * 				a || 1
 *            ========== 
 *          	x || b
 *     Value at 1 will be filled based on 1) Math.max(a,b)-->if not equal 
 *     									  2) x+2 --> if equal
 *   
 */
public class LongestPalindromicSubsequence_DP {

	public int longestPalindromeSubseq(String s) {
		
		int dp[][] = new int[s.length()][s.length()];
		for(int k=0; k<s.length(); k++) {
			for(int i=0; i<s.length()-k; ) {
				for(int j=k; j<s.length(); i++, j++) {
					System.out.println(k);
					if(i==j) {
						dp[i][j] = 1;
					} else if(s.charAt(i) == s.charAt(j)) {
						dp[i][j] = dp[i+1][j-1]+2;
					} else {
						dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
					}
				}
			}
		}
		
		for(int i[] : dp) {
			System.out.println(Arrays.toString(i));
		}
		return dp[0][s.length()-1];
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubsequence_DP l = new LongestPalindromicSubsequence_DP();
		//System.out.println(l.longestPalindromeSubseq("aaaba"));
		System.out.println(l.longestPalindromeSubseq("bccb"));
	}
}
