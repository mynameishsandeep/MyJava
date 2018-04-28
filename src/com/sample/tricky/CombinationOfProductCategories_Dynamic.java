package com.sample.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class CombinationOfProductCategories_Dynamic {

	public static List<List<String>> productAttributeCombinations(List<List<String>> productsAttributes) {
		LinkedList<List<String>> queue = new LinkedList<>();

		combine(queue, productsAttributes);
		System.out.println("Total Combination is " + queue.size());
		System.out.println(queue.toString());
		return queue;
	}

	private static void combine(LinkedList<List<String>> queue, List<List<String>> input) {
		queue.offer(Arrays.asList(""));
		for (int i = 0; i < input.size(); i++) {
			List<String> currentItem = input.get(i);
			int currentQueueSize = queue.size();

			for (int j = 0; j < currentQueueSize; j++) {
				List<String> queueItem = queue.poll();
				for (String c : currentItem) {
					List<String> currentCombo = new ArrayList<>();
					currentCombo.add(c);
					for (String qValue : queueItem) {
						if (StringUtils.isNotBlank(qValue)) {
							currentCombo.add(qValue);
						}
					}
					queue.add(currentCombo);
				}
			}

		}

	}

	public static void main(String[] args) {
		List<String> colorValues = new ArrayList<>();
		colorValues.add("Red");
		colorValues.add("Green");
		colorValues.add("Blue");

		List<String> sizeValues = new ArrayList<>();
		sizeValues.add("XL");

		List<String> patternValues = new ArrayList<>();
		patternValues.add("p1");
		patternValues.add("p2");
		patternValues.add("p3");

		List<List<String>> currentProductsCategoriesValueList = new ArrayList<>();
		currentProductsCategoriesValueList.add(colorValues);
		currentProductsCategoriesValueList.add(sizeValues);
		currentProductsCategoriesValueList.add(patternValues);

		productAttributeCombinations(currentProductsCategoriesValueList).toString();
	}
}
