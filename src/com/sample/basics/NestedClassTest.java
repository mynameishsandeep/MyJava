package com.sample.basics;


class Nested {
	static class Outer {
		void go() {
			System.out.println("hi");
		}
	}
}

public class NestedClassTest {

	public static void main(String[] args) {
		Nested.Outer n = new Nested.Outer(); // both class names
		n.go();

	}

}
