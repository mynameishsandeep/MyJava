package com.sample.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapWithMultipleValues {

	public static void main(String[] args) {
		Map<String, List<String>> map = new HashMap<>();
		
		map.put("1", map.getOrDefault("1", new ArrayList<>())).add("3");
		System.out.println(map);

	}

}
