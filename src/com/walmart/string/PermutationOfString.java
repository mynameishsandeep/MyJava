package com.walmart.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationOfString {

	public static void main(String args[]) {
		String permute = "abc";
		System.out.println("Total Combination is " + factorial(permute.length()));
		char[] cInput = permute.toCharArray();
		List<Character> input = new ArrayList<>();
		for (int i = 0; i < cInput.length; i++) {
			input.add(cInput[i]);
		}
		List<List<Character>> result = new ArrayList<>();
		permutationNew(input, result, 0);
		System.out.println(result);
		
		List<String> result1 = new ArrayList<>();
		permute(0, permute, result1);
		System.out.println(result1);

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

	public static void permute(Integer curIndex, String input, List<String> result) {

		if (input.length() - 1 == curIndex) {
			result.add(input);
			return;
		}
		for (int i = curIndex; i < input.length(); i++) {
			input = swapCharUsingStringBuilder(input, curIndex, i);
			permute(curIndex + 1, input, result);
			input = swapCharUsingStringBuilder(input, curIndex, i);
		}
	}

	private static String swapCharUsingStringBuilder(String input, Integer i1, Integer i2) {
		StringBuilder s = new StringBuilder(input);
		s.setCharAt(i1, input.charAt(i2));
		s.setCharAt(i2, input.charAt(i1));
		return s.toString();

	}




}