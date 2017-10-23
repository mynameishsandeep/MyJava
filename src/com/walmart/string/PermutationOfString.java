package com.walmart.string;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {

	public static void main(String args[]) {
		String permute = "abc";
		System.out.println("Total Combination is " + factorial(permute.length()));
		// permuteString("", permute);
		permuteStringDp(permute);
		permutation("", permute);

		// permute = "abcd";
		// System.out.println("Total Combination is " +
		// factorial(permute.length()));
		// // permuteString("", permute);
		// permuteStringDp(permute);
	}

	public static long factorial(long number) {
		if (number <= 1)
			return 1;
		else
			return number * factorial(number - 1);
	}

	private static void permutation(String prefix, String str) {
		if (0 == str.length())
			System.out.println(prefix);
		else {
			for (int i = 0; i < str.length(); i++) {
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()));
			}
		}
	}

	// https://www.codeproject.com/Tips/891811/Calculating-Permutation-Using-Dynamic-Programming
	public static void permuteStringDp(String input) {
		List<String> result = new ArrayList<>();
		result.add(input.charAt(0) + "");
		for (int i = 1; i < input.length(); i++) {
			List<String> temp = new ArrayList<>();
			for (int j = 0; j < result.size(); j++) {
				String data = result.get(j);
				for (int k = 0; k < data.length() + 1; k++) {
					temp.add(addCharAtPostion(data, input.charAt(i), k));
				}
			}
			result = temp;
		}
		System.out.println(result);
	}

	private static String addCharAtPostion(String x, Character c, Integer pos) {
		return x.substring(0, pos) + c + x.substring(pos, x.length());
	}

}