package com.walmart.string;

/**
1) select first character from string1 and select first character from string2.
2) if match found then continue with second character from both string ,increment the count.
3) if not matched then 
		a) select next character from string1 and do match in string2 and store the match count
		b) select next character from string2 and do match in string1 and store the match count
		c) return max of above two steps.
		
Tree Image is present in the folder "US Problems" picture "LCS Tree.jpeg"

This problem is similar to GroupSum6 approach

 */
public class LongestCommonSubSequence_GroupSum6Approach {

	private int lcs(char[] string1, char[] string2, int string1Length, int string2Length) {
		if (string1Length == string1.length || string2Length == string2.length) {
			return 0;
		}
		if (string1[string1Length] == string2[string2Length]) {
			return 1 + lcs(string1, string2, string1Length + 1, string2Length + 1);
		} else {
			Integer left = lcs(string1, string2, string1Length, string2Length + 1);
			Integer right = lcs(string1, string2, string1Length + 1, string2Length);
			return Math.max(left, right);
		}

	}

	public static void main(String[] args) {
		LongestCommonSubSequence_GroupSum6Approach lcs = new LongestCommonSubSequence_GroupSum6Approach();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();

		System.out.println("Length of LCS is" + " " + lcs.lcs(X, Y, 0, 0));
	}

}
