package com.sample.basics;

public class StringNullCheck {
	public static void main(String[] args) {
		String s = null;
		if ("test".equals(s)) {
			System.out.println("s not null");
		} else {
			System.out.println("s null");
		}
	}
}
