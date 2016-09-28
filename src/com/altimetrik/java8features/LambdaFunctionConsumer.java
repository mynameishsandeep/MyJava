package com.altimetrik.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Here forEach is Consumer. It accepts argument and prints result and don’t return anything.
 *
 */
public class LambdaFunctionConsumer {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("1","2","3"));
		list.parallelStream().forEach(System.out::println);// result order is not guaranteed.
		list.forEach(System.out::println);
	}
}
