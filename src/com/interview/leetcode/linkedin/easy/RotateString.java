package com.interview.leetcode.linkedin.easy;

public class RotateString {
	public static void main(String[] args) {

	}

	public boolean rotateString(String A, String B) {
		if (A.length() > B.length()) {
			return false;
		}
		String big = A + A;
		String bigger = big + A;
		if (bigger.contains(B)) {
			return true;
		}
		return false;
	}

}
