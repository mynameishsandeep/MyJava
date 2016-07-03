package com.sample.basics;

import com.sample.basics.Inner.Outer;

class Inner {
	class Outer {
		void go() {
			System.out.println("hi");
		}
	}
}

public class InnerClassTest {

	public static void main(String[] args) {
		Outer n = new Inner().new Outer(); // both class names
		n.go();

	}

}
