package com.yahoo.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString_Dynamic {

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

	public static void main(String args[]) {
		String permute = "abc";
		System.out.println("Total Combination is " + factorial(permute.length()));
		permuteStringDp(permute);
	}
	
	public static long factorial(long number) {
		if (number <= 1)
			return 1;
		else
			return number * factorial(number - 1);
	}
	
	private static String addCharAtPostion(String x, Character c, Integer pos) {
		return x.substring(0, pos) + c + x.substring(pos, x.length());
	}


}
