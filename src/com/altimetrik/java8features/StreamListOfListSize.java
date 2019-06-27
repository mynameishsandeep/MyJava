package com.altimetrik.java8features;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Ex Scenario. Course has Id and Course has pre-requisite Courses. 
 */
public class StreamListOfListSize {
	public static void main(String[] args) {

		// Key is course id and value is pre-requisite course id.
		Map<Integer, List<Integer>> map = new HashMap<>();
		map.put(1, Arrays.asList(2, 3));
		map.put(2, Arrays.asList(4, 5));

		System.out.println(map.values().stream().mapToInt(List::size).sum());

	}
}
