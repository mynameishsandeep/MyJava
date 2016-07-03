package com.sample.basics;

public class NullTest {
	public static void main(String[] args) {
		Object o1 = null;
		Object o2 = null;
		if (o1 == o2) {
			System.out.println("o1 and o2 are equal");
		}

		String s = null;
		if (s == o1) {
			System.out.println("s and o1 are equal");
		}
	}
}
