package com.interview.leetcode.linkedin.hard;

/*
 * 
 * https://leetcode.com/problems/edit-distance/description/
 * 
 * https://www.youtube.com/watch?v=We3YDTzNXEk
 * 
 * 1) Fill first row with 0,1,2,3 to n and first column with 0,1,2,3 to n.
 * 2) if match found pick diagonal
 * 3) else minimum of "left, top and diagonal" +1
 * 4) return bottom left most diagonal. 
 */
public class EditDistance_Dynamic {
	public int minDistance(String word1, String word2) {
		int dp[][] = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0) { // Fill Oth row
					dp[i][j] = j;
				} else if (j == 0) { // Fill 0th column
					dp[i][j] = i;
				} else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		return dp[word1.length()][word2.length()];
	}

	public static void main(String[] args) {
		EditDistance_Dynamic e = new EditDistance_Dynamic();
		System.out.println(e.minDistance("horse", "ros"));
	}
}
