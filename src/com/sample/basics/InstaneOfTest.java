package com.sample.basics;

import org.json.JSONArray;

public class InstaneOfTest {

	public static void main(String[] args) {
		
		String s = null;
		if (s instanceof String) {
			System.out.println("null is string");
		} else {
			System.out.println("null is not String");
		}
		JSONArray j = (JSONArray)((Object)s);
		if (j instanceof JSONArray) {
			System.out.println("null is JSONArray");
		} else {
			System.out.println("null is not JSONArray");
		}
	}

}
