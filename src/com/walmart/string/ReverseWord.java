package com.walmart.string;

/**
 * =========== Approach 1=============
 * 1) Reverse each word. Use Approach ReverseAString
 * 2) Reverse the entire word
 * 3) Step1,Step2  or Step2, Step1 both will work
 *
 * Ex:
 * Input : "12 34"
 * Step1 : "21 34"
 * Step2 : "21 43"
 * Step3 : "34 12" 
 * =========== Approach 2======== Too many edge cases will fail in approach2, when input has spaces(" ") in start and end. So don't try
 * Reversing the 1st and last word. Similar to ReverseAString. 
 * This approach has issue when input has spaces(" ") in start and end.
 * Separate logic needs to be added for spaces(" ") in start and end.
 *
 */
public class ReverseWord {

	public static void reverseWords(char[] s) {
		int i = 0;
		for (int j = 0; j < s.length; j++) {
			if (s[j] == ' ') {
				reverse(s, i, j - 1);
				i = j + 1;
			}
		}
		// for the last word
		reverse(s, i, s.length - 1);
		// Reverse the entire word. This line can go in beginning too.
		reverse(s, 0, s.length - 1);
		System.out.println(s);
	}

	public static void reverse(char[] s, int i, int j) {
		while (i < j) {
			char temp = s[i];
			s[i++] = s[j];
			s[j--] = temp;
		}
		System.out.println(s);
	}

	public static void main(String[] args) {
		String s = " 12 34 ";
		reverseWords(s.toCharArray());
	}

}
