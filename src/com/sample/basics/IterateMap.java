package com.sample.basics;

import java.util.HashMap;
import java.util.Map;

public class IterateMap {

	public static void main(String[] args) {
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
