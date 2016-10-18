package com.altimetrik.java8features;

import java.util.function.Supplier;

/**
 * Supplier sends a function f1 to another function f2. Inside f2, We call
 * supplier.get() calls f1() to retrieve its value
 * 
 * @author sisuser
 *
 */
public class LambdaFunctionSupplier {

	public static void main(String[] args) {
		LambdaFunctionSupplier l = new LambdaFunctionSupplier();
		l.myMethod();

	}

	public void myMethod() {
		Fun fun = new Fun();
		Supplier<?> s = (() -> fun.funString());
		System.out.println(callSupplier(s));

		Supplier<?> s1 = (() -> fun.funInteger());
		System.out.println(callSupplier(s1));

		System.out.println(callSupplier(() -> fun.funBoolean()));
		
		Supplier<?> s2 = (() -> fun.funObject());
		System.out.println(s2.get());

	}

	/**
	 * This method accepts a method or function through Lambda expression.
	 * Execute the function and get the result by calling get() method on the
	 * function.
	 * 
	 * @param input
	 * @return
	 */
	public Object callSupplier(Supplier<?> input) {
		return input.get();

	}

}

class Fun {

	public String funString() {
		return "Inside Fun String";
	}

	public Integer funInteger() {
		return 100;
	}

	public Boolean funBoolean() {
		return true;
	}
	
	public Object funObject() {
		return "Inside Fun Object";
	}
}
