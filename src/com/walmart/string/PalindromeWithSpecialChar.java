package com.walmart.string;

/*
 * https://www.geeksforgeeks.org/sentence-palindrome-palindrome-removing-spaces-dots-etc/
 * 
 * Write a program to check if a sentence is palindrome or not. 
 * You can ignore white spaces and other special characters to consider sentence as a palindrome.
 */
public class PalindromeWithSpecialChar {

	public static void main(String[] args) {
		System.out.println(new PalindromeWithSpecialChar().isPalindrome("Too hot to hoot."));

	}

	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		Integer left = 0;
		Integer right = s.length() - 1;
		while (left < right) {
			if (Character.isLetter(s.charAt(left))) {
				if (Character.isLetter(s.charAt(right))) {
					if (s.charAt(left++) != s.charAt(right--)) {
						return false;
					}
				} else {
					right--;
				}
			} else {
				left++;
			}
		}
		return true;
	}

}
