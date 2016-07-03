package com.sample.basics;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put(null, null);
		
		for(Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		Map<String, String> map1 = new Hashtable<>();
		map1.put(null, null);// NullPointerException
		
		Map<String, String> map2 = new LinkedHashMap<>();
		
		
		for(Map.Entry<String, String> entry : map1.entrySet()) {
			System.out.println("Entering HashTable");
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
	}

}
