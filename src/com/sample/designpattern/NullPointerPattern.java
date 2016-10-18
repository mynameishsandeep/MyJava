package com.sample.designpattern;

import java.util.Optional;
import java.util.function.Supplier;

public class NullPointerPattern {

	/**
	 * 2 scenarios can happen now. 1) Supplier can be null 2) T can be null
	 * 
	 * @param supplier
	 * @return
	 */
	public static <T> Optional<T> safeGet(Supplier<T> supplier) {

		try {
			T result = supplier.get();
			return Optional.ofNullable(result);

		} catch (Exception e) {
			// System.out.println("Exception Thrown, because supplier is null");
			return Optional.empty();
		}
	}

	public static void main(String[] args) {
		negativeCase1();
		negativeCase2();
		positiveCase1();

	}

	public static void negativeCase1() {
		String s1 = null;
		Supplier<String> su1 = () -> s1;
		Optional<String> op1 = safeGet(su1);
		// System.out.println(op1.isPresent()); false
		System.out.println(op1.orElse("Default Value negativeCase1"));
	}

	public static void negativeCase2() {
		Optional<String> op2 = safeGet(null);
		// System.out.println(op2.isPresent());false
		System.out.println(op2.orElse("Default Value negativeCase2"));
	}

	public static void positiveCase1() {

		String s1 = "String1";
		Supplier<String> su1 = () -> s1;
		Optional<String> op1 = safeGet(su1);
		// System.out.println(op1.isPresent()); true
		System.out.println(op1.orElse("Default Value negativeCase2"));

	}
}
