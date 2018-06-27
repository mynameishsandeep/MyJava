package com.sample.basics;

public class ReverseAStringRecursion {
	public static void main(String[] args) {

		System.out.println(recurse("123"));
	}

	public static String recurse(String input) {
		if (input.length() == 0) {
			return "";
		}
		return recurse(input.substring(1)) + input.charAt(0);
		// 23 + 1 = 321
		// 3 + 2 = 32
		// 3

	}
}
