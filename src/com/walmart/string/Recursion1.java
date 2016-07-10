package com.walmart.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion1 {

	public static void main(String[] args) {
		List<String> arr = new ArrayList<>(
			    Arrays.asList("a1","a2","a3","a4", "b1","b2","b3","b4"));
		swap(arr,arr.size()-1,arr.size()-1);
		arr.forEach(System.out::println);
		
	}
	
	public static void swap(List<String> a, int min, int max) {
		if(min==-1) {
			return;
		}
		// Remove element and keep it in temp
		String data = a.remove(max);
		swap(a,min=min-2, --max);
		min= min+2;
		a.add(min,data);

	}

}
