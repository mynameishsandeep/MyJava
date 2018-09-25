package com.sample.basics;

public class ReverseAString {

	/**
	 * 1) Convert String to Character Array
	 * 2) Swap 1st and n th character, then
	 * 3) 2nd and n-1 character... So half traversal is enough
	 * 
	 * Note: This saves a lot of object creation in memory. instead of using string concat operation with stringbuilder
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
