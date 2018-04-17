package com.sample.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Collections_Add_Substract_2ListSet {

	public static void main(String[] args) {
		List<String> existingColor = new ArrayList<>();
		existingColor.add("Red");
		existingColor.add("Green");
		existingColor.add("Blue");
		
		List<String> currentColor = new ArrayList<>();
		currentColor.add("Red");
		currentColor.add("Green");
		
		// subtract operation
		existingColor.removeAll(currentColor);
		System.out.println(existingColor);
		
		// add operation
		existingColor.addAll(currentColor);
		currentColor.add("Blue");

		System.out.println(existingColor);
		System.out.println(currentColor);

		// equals operation
		System.out.println(existingColor.equals(currentColor));
		System.out.println(listEqualsIgnoreOrder(existingColor,currentColor));
	}
	
	public static <T> boolean listEqualsIgnoreOrder(List<T> list1, List<T> list2) {
	    return new HashSet<>(list1).equals(new HashSet<>(list2));
	}
}
