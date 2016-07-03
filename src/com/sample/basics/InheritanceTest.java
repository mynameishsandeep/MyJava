package com.sample.basics;

class Parent {
	int x = 100;
	int y = 300;
	protected int zz = 500;

	// public final void fun() {//Compile Error on Child Class. Cannot override
	// fun()
	protected Number fun() {
		System.out.println("inside Parent fun");
		return 1;
	}

	public void fun1() {
		System.out.println("inside Parent fun1");
	}
}

class Child extends Parent {
	int x = 200;
	int z = 400;

	public Integer fun() {

		System.out.println("inside Child fun");
		return 2;
	}

	public void fun2() {
		System.out.println("inside Child fun2");
		Parent p = new Parent();
		System.out.println(p.zz);
	}
}

public class InheritanceTest {

	public static void main(String[] args) {
		Parent p = new Child();
		p.fun();
		// p.fun2(); //Not visible. Compile Error
		// System.out.println(p.z); // Not Visible. Compile Error
		System.out.println(p.x);
	}

}
