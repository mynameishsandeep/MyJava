package com.interview.leetcode.google.easy;

/*
 *
 * https://leetcode.com/problems/repeated-string-match/description/
 * 
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. 
 * If no such solution, return -1.
 * 
 * The idea is to keep string builder and appending until the length A is greater or equal to B.
 * 
 * Ex: a , aa -->2
 * Ex: abc, bca --> 2 
 */
public class RepeatedStringMatch {
	public int repeatedStringMatch(String A, String B) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		while (sb.length() < B.length()) { // Ex: a , aa 
			sb.append(A);
			count++;
		}
		if (sb.toString().contains(B))
			return count;
		if (sb.append(A).toString().contains(B)) {// Ex: abc, bca
			return ++count;
		}
		return -1;
	}
}
