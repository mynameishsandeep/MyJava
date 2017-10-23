package com.sample.tricky;

public class SumOfTwoLargeNumbers {

	/**
	 * 1) Get the min string and max string.
	 * 2) Get the number at string character by "s.charAt(i)-'0'"
	 * 
	 * Input : str1 = "3333311111111111", str2 = "44422222221111" Output :
	 * 3377733333332222
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Keep s1 small always
		String s1 =  "99999";
		String s2 = "999999";
		int max = 0, min = 0;
		if (s1.length() > s2.length()) {
			String temp = s1;
			s1 = s2;
			s2 = temp;
		}
		min = s1.length() - 1;
		max = s2.length() - 1;

		int carry = 0;
		StringBuilder result = new StringBuilder();
		int sum = 0;
		for (int i = min, j = max; j >= 0; i--, j--) {
			// Small string is ended
			if (i < 0) {
				sum = (s2.charAt(j) - '0') + carry;
			} else {
				sum = ((s1.charAt(i) - '0') + (s2.charAt(j) - '0') + carry);
			}
			carry = sum / 10;
			result.append(sum%10);
		}
		if (carry > 0) {
			result.append(carry);
		}
		System.out.println(result.reverse());
	}
}
