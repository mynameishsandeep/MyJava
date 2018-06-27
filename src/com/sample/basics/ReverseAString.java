package com.sample.basics;

public class ReverseAString {

	/**
	 * Swap 1st and n th character, then
	 * 2nd and n-1 character... So half traversal is enough
	 */
	public static String reverse(String s) {
		char[] array = s.toCharArray();
		int i = 0, j = array.length - 1;
		while (i < j) {
			char tmp = array[i];
			array[i++] = array[j];
			array[j--] = tmp;
		}
		return new String(array);
	}

	public static void main(String[] args) {
		System.out.println(reverse("Test"));

	}

}
