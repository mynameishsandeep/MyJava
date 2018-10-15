package com.interview.leetcode.amazon.easy;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 * 
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending 
 * multiple copies of the substring together.
 * 
 * Ex1: abcabcabcabc -- true
 * Ex2: abcabcabc -- true
 * Ex: cacac -- false
 * 
The length of the repeating substring must be a divisor of the length of the input string
Search for all possible divisor of str.length, starting for length/2
If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
If the repeated substring is equals to the input str return true

 * EX: for a 30 char input. Repeat can occur in 15, 10 and 6-->30%15, 30%10, 30%6 
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
