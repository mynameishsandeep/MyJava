package com.sample.tricky;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Note: 
 * 1) Flag accessOrder rearranges the data ones get() is called. 
 * So all the time recently visited or inserted will be at head or top. 
 * 
 * 2) If size goes more than specified then Bottom or tail is removed.     
 */
public class LRUCache1 {
	private int size;

	public static void main(String[] args) {
		// Setting accessOrder flag to true
		LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>(10 , .75F, true) {
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > 10;
			}
		};
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(5, 5);
		cache.put(6, 6);
		cache.get(5);
		cache.put(7, 7);
		cache.put(8, 8);
		cache.put(9, 9);
		cache.put(10, 10);

		System.out.println(cache);

		cache.get(5);
		System.out.println(cache);
		cache.put(11, 11);
		System.out.println(cache);
	}

}