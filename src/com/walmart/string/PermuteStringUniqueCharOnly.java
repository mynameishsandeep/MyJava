package com.walmart.string;

/*
 * Input: "abc" Output: "a","b","c","ab","bc","abc"
 */
public class PermuteStringUniqueCharOnly {

	public static void main(String[] args) {
		String input = "abcdef";
		int n = input.length();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j + i < n;) {
				int start = 0;
				int end = i;
				int current = j;
				System.out.println("");
				while (start + (end - n - 1) < n) {
					System.out.print(input.charAt(current));
					if (start == end) {
						break;
					} else {
						start++;
						current++;
					}
				}
				j++;
			}
		}
	}

}
