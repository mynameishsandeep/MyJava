package com.sample.basics;

public class PatternExample {

	public static void main(String[] args) {
		
		String s = "124.123";
		//String s = "124";
		// Pattern for Integer and Float
		if(s.matches("(\\d+(\\.\\d+)?)")) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

	}
}
