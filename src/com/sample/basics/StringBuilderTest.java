package com.sample.basics;

import java.util.HashMap;
import java.util.Map;

/*
	StringBuilder is mutable. So if lots of String concat operation is needed StringBuilder is good, because it overrides its value.

 */
public class StringBuilderTest {

	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("abc");
        StringBuilder sb2 = new StringBuilder("abc");
        
        Map<String, String> map = new HashMap<>();
        map.put(sb1.toString(), "1");
        map.put(sb2.toString(), "1");
        System.out.println(map.size());
        
        System.out.println(sb1.equals(sb2));
        
        System.out.println(sb1.delete(sb1.length()-1, sb1.length()));
	}

}
