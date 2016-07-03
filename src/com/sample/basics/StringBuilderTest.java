package com.sample.basics;

import java.util.HashMap;
import java.util.Map;

public class StringBuilderTest {

	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("abc");
        StringBuilder sb2 = new StringBuilder("abc");
        
        Map<String, String> map = new HashMap<>();
        map.put(sb1.toString(), "1");
        map.put(sb2.toString(), "1");
        System.out.println(map.size());
        
        System.out.println(sb1.equals(sb2));
	}

}
