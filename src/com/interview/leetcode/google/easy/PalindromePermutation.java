package com.interview.leetcode.google.easy;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string, determine if a permutation of the string could form a palindrome.
For example,
"code" -> False, "aab" -> True, "carerac" -> True.
 */

public class PalindromePermutation {
	public static boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<>();
		for (Character c : s.toCharArray()) {
			if (set.contains(c)) {
				set.remove(c);
			} else {
				set.add(c);
			}
		}
		return set.size() <= 1;
	}
	
	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("as"));
	}
}
