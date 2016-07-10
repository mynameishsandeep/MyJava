package com.sample.basics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapSortByValue {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("aa", 75);
		map.put("a", 25);
		map.put("b", 50);
		
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println("=====================");
		TreeMap<String, Integer> tMap = new TreeMap<>(map);
		for(Map.Entry<String, Integer> entry : tMap.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println("=====================");
		TreeMap<String, Integer> tMap1 = new TreeMap<>(new StringComparator());
		tMap1.putAll(map);
		for(Map.Entry<String, Integer> entry : tMap1.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println("=====================");
		
		TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(new ValueComparator(map));
        sorted.putAll(map);
        //sorted.put("e", 10); put will fail
        System.out.println("Sorted Map: " + Arrays.toString(sorted.entrySet().toArray()));
	}
	
	
}


class ValueComparator implements Comparator<String> {

    private Map<String, Integer> map;

    public ValueComparator(Map<String, Integer> map) {
        this.map = map;
    }

    public int compare(String a, String b) {
    	System.out.println("input1 " + a + " input2 "+b);
        return map.get(a).compareTo(map.get(b));
    }
}
class StringComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	}


}