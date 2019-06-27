package com.sample.basics;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put(null, null);

		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}

		Map<String, String> map1 = new Hashtable<>();
		map1.put(null, null);// NullPointerException

		Map<String, String> map2 = new LinkedHashMap<>();

		for (Map.Entry<String, String> entry : map1.entrySet()) {
			System.out.println("Entering HashTable");
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}

	}

	public void map(char[] tasks, int n) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : tasks) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		// Dont write below code. Above is best.
		//		Map<Character, Integer> map = new HashMap<>();
		//        for(char c : tasks) {
		//            if(map.containsKey(c)) {
		//                map.put(c,map.get(c)+1);
		//            } else {
		//                map.put(c,1);
		//            }
		//        }
	}

	private void IterateMap() {
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "1");
		System.out.println("ToString content is "+map.toString());
		for(Map.Entry<String, String> currentMap: map.entrySet()) {
			System.out.println(currentMap.getKey());
			System.out.println(currentMap.getValue());
		}
		
		for(String currentKey: map.keySet()) {
			System.out.println(currentKey);
			System.out.println(map.get(currentKey));
			
		}
	}
}
