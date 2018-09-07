package com.walmart.string;

import java.util.Arrays;

public class SortAString {
	public static void main(String[] args) {
		String s = "cab";
		char[] c = s.toCharArray();
		Arrays.sort(c);
		s = new String(c);
		System.out.println(s);
	}
}
