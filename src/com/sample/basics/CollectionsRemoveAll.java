package com.sample.basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsRemoveAll {

	public static void main(String[] args) {
		final List<String> a1 = List.of("Test");
		List<String> a2 = new ArrayList<>(a1);
		
		Map<String, String> map = new HashMap<>();
		map.put("Test", "Test");
		
		
		a2.removeAll(map.keySet());
		//a1.retainAll(a2);//removeAll and retainAll are inverse
		a1.stream().forEach(System.out::println);
		System.out.println("Done" ); 

	}

}
