package com.sample.tricky;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfProductCategories {

	public static List<List<String>> productAttributeCombinations(List<List<String>> productsAttributes) {
		List<List<String>> res = new ArrayList<>();

		combine(res, new ArrayList<>(), productsAttributes, 0);
		System.out.println("Total Combination is " + res.size());
		System.out.println(res.toString());
		return res;
	}

	private static void combine(List<List<String>> res, List<String> current, List<List<String>> input, int depth) {
		if (depth == input.size()) {
			res.add(current);
			return;
		}
		for (int i = 0; i < input.get(depth).size(); i++) {
			List<String> newCurrent = new ArrayList<>();
			newCurrent.addAll(current);
			newCurrent.add(input.get(depth).get(i));
			combine(res, newCurrent, input, depth + 1);
		}
	}

	public static void main(String[] args) {
		List<List<String>> options = new ArrayList<>();
		List<String> colorValues = new ArrayList<>();
		colorValues.add("Red");
		colorValues.add("Green");
		colorValues.add("Blue");
		options.add(colorValues);

		List<String> sizeValues = new ArrayList<>();
		sizeValues.add("XL");

		options.add(sizeValues);

		List<String> patternValues = new ArrayList<>();
		patternValues.add("p1");
		patternValues.add("p2");
		patternValues.add("p3");
		options.add(patternValues);

		productAttributeCombinations(options).toString();
	}
}
