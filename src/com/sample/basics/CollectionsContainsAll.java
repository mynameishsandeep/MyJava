package com.sample.basics;

import java.util.ArrayList;
import java.util.List;

public class CollectionsContainsAll {

	public static void main(String[] args) {
		List<String> a1 = new ArrayList<>();
		a1.add("Test");
		a1.add("Test1");
		
		List<String> a2 = new ArrayList<>();
		a2.add("Test");
		
		System.out.println(a1.containsAll(a2));
		System.out.println(a2.containsAll(a1));
		
		//a1.removeAll(a2);
		a1.retainAll(a2);//removeAll and retainAll are inverse
		a1.stream().forEach(System.out::println);

	}

}
