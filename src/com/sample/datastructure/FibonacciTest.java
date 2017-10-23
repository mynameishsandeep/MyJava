package com.sample.datastructure;

import org.junit.Rule;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

@PrepareForTest({ Fibonacci.class })
public class FibonacciTest {
	@Rule
	public PowerMockRule rule = new PowerMockRule();

	int totalNumber = 5;

	@Test
	public void testCheckFibonacciRecursion() {
		Fibonacci.fibRecursive(totalNumber);
	}

	@Test
	public void testCheckFibonacciLoop() {
		Fibonacci.fibRecursive(totalNumber);
	}
}