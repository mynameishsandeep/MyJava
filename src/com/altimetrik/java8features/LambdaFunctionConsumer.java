package com.altimetrik.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer sends a function f1 to another function f2. Inside f2, we call
 * consumer.apply(data), which calls f1(data). f1(data) consumes data (Ex:
 * Print) and does not return any value
 * 
 * Here forEach is Consumer. It accepts argument and prints result and don’t
 * return anything.
 *
 */
public class LambdaFunctionConsumer {

	public static void main(String[] args) {
		Consumer<String> c = (x)->{print(x);}; // x->print(x);
		funPrint(c);
		
		c.accept("Four");
		
		funPrint(x->print1(x));
		
	}

	public static void print(String data) {
		System.out.println("print " + data);
	}

	public static void print1(String data) {
		System.out.println("print1 " + data);
	}

	public static void funPrint(Consumer<String> data) {
		data.accept("One");
		data.accept("Two");
		data.accept("Three");
	}
	
	public static void consumerInJava() {
		List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3"));
		list.parallelStream().forEach(System.out::println);// result order is
															// not guaranteed.
		list.forEach(System.out::println);
	}
}
