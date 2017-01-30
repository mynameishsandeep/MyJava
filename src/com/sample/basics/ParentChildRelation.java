package com.sample.basics;

public class ParentChildRelation {
	public static void main(String[] args) {
		AClass aa = new CClass();
		BClass bb = (BClass)aa;
		CClass cc = (CClass)bb;
		System.out.println(cc.getC());
	}
}

class AClass {
	private int a = 10;

	public int getA() {
		return a;
	}
}

class BClass extends AClass {
	private int b = 20;

	public int getB() {
		return b;
	}
}

class CClass extends BClass {
	private int c = 30;

	public int getC() {
		return c;
	}
}
