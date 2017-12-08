package com.walmart.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationOfString {

	public static void main(String args[]) {
		String permute = "abc";
		System.out.println("Total Combination is " + factorial(permute.length()));
		permuteStringDp(permute);
		char[] cInput = permute.toCharArray();
		List<Character> input = new ArrayList<>();
		for (int i = 0; i < cInput.length; i++) {
			input.add(cInput[i]);
		}
		List<List<Character>> result = new ArrayList<>();
		permutationNew(input, result, 0);
		System.out.println(result);
	}

	public static long factorial(long number) {
		if (number <= 1)
			return 1;
		else
			return number * factorial(number - 1);
	}


	private static void permutationNew(List<Character> input, List<List<Character>> result, Integer currentIndex) {
		if (currentIndex == input.size() - 1) {
			result.add(new ArrayList<>(input));
			return;
		}
		for (int i = currentIndex; i < input.size(); i++) {
			Collections.swap(input, currentIndex, i);
			permutationNew(input, result, currentIndex + 1);
			Collections.swap(input, currentIndex, i);
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