package com.sample.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Design a class such that, input will be a file. Find the first largest 2 line on
 * the file
 * 
 * @author Thangaprabhu
 *
 */
public class TreeMapScenario {

	public static void main(String[] args) {
		String lines[] = { "abcde", "jklmn", "abc", "abcd" };

		Map<Integer, List<String>> result = new TreeMap<>(Collections.reverseOrder());

		for (String line : lines) {
			if (result.containsKey(line.length())) {
				List<String> existingLine = result.get(line.length());
				existingLine.add(line);
				result.put(line.length(), existingLine);
			} else {
				List<String> listValue = new ArrayList<String>();
				listValue.add(line);
				result.put(line.length(), listValue);
			}
		}
		Set<Integer> keys = result.keySet(); 
		for(Integer key : keys) {
			System.out.println(key);
			System.out.println(result.get(key));
		}
	}

}
