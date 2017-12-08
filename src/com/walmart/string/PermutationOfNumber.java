package com.walmart.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Based on Book... Elements of Programming Interviews
 * Tree Flow image is inside "US Problems" folder "Permutations.JPG"
 */
public class PermutationOfNumber {

	public static void main(String[] args) {
		List<List<Integer>> result = new ArrayList<>();
		permute(0, new ArrayList<>(Arrays.asList(1, 2, 3)), result);
		System.out.println(result.size());
		System.out.println(result);

	}

	public static void permute(Integer curIndex, List<Integer> input, List<List<Integer>> result) {

		if (input.size() - 1 == curIndex) {
			result.add(new ArrayList<>(input));
			return;
		}
		for (int i = curIndex; i < input.size(); i++) {
			Collections.swap(input, curIndex, i);
			permute(curIndex + 1, input, result);
			Collections.swap(input, curIndex, i);
		}
	}
}
