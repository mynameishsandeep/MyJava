package com.sample.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Requirements: Generate 100 random numbers between 1-1000.
//	Put the numbers into a Map.  Then move them to a Set.
//  Then move the numbers into a List.  Then sort the numbers.
//	Finally output the numbers, with one number on every row

public class CollectionsFun {

	public static void main(String[] args) {

		int a[] = new int[100];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 1000 +1);
			
		}
		
		

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], i);
		}

		Set<Integer> set = map.keySet();

		List<Integer> list = new ArrayList<>();
		list.addAll(set);
		
		Collections.sort(list);
		System.out.println("Total Size = " + list.size());
		list.stream().forEach(System.out::println);

	}

}
