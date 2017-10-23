package com.walmart.string;

public class PalindromeWithSpecialChar {

	public static void main(String[] args) {
		System.out.println(new PalindromeWithSpecialChar().isPalindrome(
				"'''"));

	}

	public boolean isPalindrome(String s) {
		Character leftToRight = null;
		Character rightToLeft = null;
		int len = s.trim().length();
		for (Integer i = 0, j = len - 1; i < len / 2; i++, j--) {
			if (i == j) {
				return true;
			}
			i = skipUnknownCharLeftToRight(s, i, j-1);
			leftToRight = i!=null?Character.toLowerCase(s.charAt(i)):null;
			j = (i!=null&&j!=null)?skipUnknownCharRightToLeft(s, j, i+1):null;
			rightToLeft = j!=null?Character.toLowerCase(s.charAt(j)):null;
			if (leftToRight == null || rightToLeft == null) {
				return true;
			}
			if (leftToRight != rightToLeft) {
				return false;
			}
		}
		return true;
	}

	public Integer skipUnknownCharLeftToRight(String s, int i, int max) {
		for (; i < max; i++) {
			//System.out.println("I value " + i);
			if (Character.isLetterOrDigit(s.charAt(i))) {
				return i;
			}
		}
		return null;
	}

	public Integer skipUnknownCharRightToLeft(String s, int j, int min) {
		for (; j >= min; j--) {
			if (Character.isLetterOrDigit(s.charAt(j))) {
				return j;
			}
		}
		return null;
	}
}
