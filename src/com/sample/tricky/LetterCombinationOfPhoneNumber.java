package com.sample.tricky;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

	private static String[] phone = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return res;

		String input[] = new String[digits.length()];
		int i = 0;
		for (Character ch : digits.toCharArray()) {
			input[i++] = phone[Integer.valueOf(ch+"")];
		}
		combine(res, "", input, 0);
		System.out.println(res.toString());
		return res;
	}

	private static void combine(List<String> res, String current, String input[], int depth) {
		if (depth == input.length) {
			res.add(current);
			return;
		}
		for (int i = 0; i < input[depth].length(); i++) {
			combine(res, current + input[depth].charAt(i), input, depth + 1);
		}
	}

	public static void main(String[] args) {
		letterCombinations("123").toString();
	}
}
