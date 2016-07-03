package com.sample.basics;

interface MyA {
}

public class ReflectionTest1 {
	public static void main(String a[]) throws ClassNotFoundException {
		Class c = Class.forName("com.sample.basics.MyA");
		System.out.println(c.isInterface());// false
		Class c1 = MyA.class;
		System.out.println(c1.isInterface());// true
	}
}