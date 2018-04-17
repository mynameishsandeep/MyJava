package com.interview.leetcode.amazon.easy;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 * 
 * Note: for a 30 char input. Repeat can occur in 15, 10 and 6... 
 * So start from 30/2. i.e 15. do a substring
 * Then do 10 char substring
 * Then do 6 char substring. 
 * If anyone matches true. Else False
 *
 */
public class RepeatedSubstringPattern {

	public boolean repeatedSubstringPattern(String str) {
		int l = str.length();
		for (int i = l / 2; i >= 1; i--) {
			if (l % i == 0) {
				int m = l / i;
				String subS = str.substring(0, i);
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < m; j++) {
					sb.append(subS);
				}
				if (sb.toString().equals(str))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		RepeatedSubstringPattern r = new RepeatedSubstringPattern();
		System.out.println(r.repeatedSubstringPattern("abcdefabcdefabcdefabcdefabcdef"));
	}
}
