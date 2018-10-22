package com.walmart.string;

/*
https://www.hackerrank.com/challenges/alternating-characters/problem

You are given a string containing characters A and B only. 
Your task is to change it into a string such that there are no matching adjacent characters. 
To do this, you are allowed to delete zero or more characters in the string.
Your task is to find the "count of minimum number of required deletions".


AAAA - 3
BBBBB - 4
ABABABAB - 0
BABABA - 0
AAABBB -4


 */
public class AlternatingCharacters {
	public int alternatingCharacters(String s) {
		int count = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1))
				count++;
		}
		return count;

	}
}
