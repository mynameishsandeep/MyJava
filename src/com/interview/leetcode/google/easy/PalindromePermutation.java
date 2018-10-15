package com.interview.leetcode.google.easy;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string, determine if re-arranging characters of the string could form a palindrome.

Solution is simple: 
1) For even number of character....To be a palindrome, every character should occur even. 
2) For odd number of character....To be a palindrome, every character should occur even and one character can occur once.


For example:
"code" -> False, 
"aab" -> True, 
"carerac" -> True. (carerac)


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
		return set.size() <= 1;// For Odd character palindrome
	}

	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("as"));
	}
}
