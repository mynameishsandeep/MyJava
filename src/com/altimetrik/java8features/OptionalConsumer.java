package com.altimetrik.java8features;

import java.util.Optional;

/*
 * Consumer accepts a argument and return nothing
 */
public class OptionalConsumer {
	public static void main(String[] args) {
		Optional<String> op = Optional.of("TestData");
		op.ifPresent(val->System.out.println(val));
	}
}
