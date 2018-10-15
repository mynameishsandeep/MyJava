package com.interview.leetcode.google.medium;
/*
 * https://leetcode.com/problems/palindromic-substrings/discuss/105688/Very-Simple-Java-Solution-with-Detail-Explanation
 * 
 * 0,0 || 1,1 || 2,2 || 3,3 || 4,4 || 5,5
 * 0,1 || 1,2 || 2,3 || 3,4 || 4,5 
 * 
 * 
 *
 */

public class PalindromicSubstrings {

	int count = 1;

	public int countSubstrings(String s) {
		if (s.length() == 0)
			return 0;
		for (int i = 0; i < s.length() - 1; i++) {
			checkPalindrome(s, i, i); //To check the palindrome of odd length palindromic sub-string
			checkPalindrome(s, i, i + 1); //To check the palindrome of even length palindromic sub-string
		}
		return count;
	}

	private void checkPalindrome(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) { //Check for the palindrome string
			print(s, left, right);
			count++; //Increment the count if palindrome substring found
			left--; //To trace string in left direction
			right++; //To trace string in right direction
		}
	}

	public static void main(String[] args) {
		PalindromicSubstrings p = new PalindromicSubstrings();
		System.out.println(p.countSubstrings("caacac"));
		//System.out.println(p.countSubstrings("cacac"));
	}

	private void print(String s, int left, int right) {
		if (s.substring(left, right + 1).length() % 2 == 0) {
			System.out.println("Palindrome found in even length : " + s.substring(left, right + 1));
		} else {
			System.out.println("Palindrome found in odd length  : " + s.substring(left, right + 1));
		}
	}
}
