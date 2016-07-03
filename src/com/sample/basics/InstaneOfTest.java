package com.sample.basics;

public class InstaneOfTest {

	public static void main(String[] args) {
		
		String s = null;
		if (s instanceof String) {
			System.out.println("null is string");
		} else {
			System.out.println("null is not String");
		}

	}

}
