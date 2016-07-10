package com.walmart.string;

import java.util.HashMap;
import java.util.Map;

public class GetMaxCharInString {

	public static void main(String[] args) {
		Map<Character, Integer> map = new HashMap<>();
		String input = "aabbbccddeefffgggghhiijjjjkk";
		Integer value = null;
		Character resultChar = null;
		int resultCount = 0;
		for (int i=0; i<input.length(); i++) {
			value = map.put(input.charAt(i), 1);

			if(value!=null) {
				map.put(input.charAt(i), ++value);
			}
			if(null != value && resultCount<value) {
				resultCount = value;
				resultChar = input.charAt(i);
			}
		}
		
		System.out.println(resultChar);
		System.out.println(resultCount);
		
			

	}

}
