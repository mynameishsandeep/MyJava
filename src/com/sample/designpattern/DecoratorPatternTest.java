package com.sample.designpattern;

interface Calculator {
	int add(int n1, int n2);
}

class BasicCalculator implements Calculator {
	@Override
	public int add(int n1, int n2) {
		return n1+n2;
	}
}

abstract class DecoratorCalculator implements Calculator {
	Calculator calc;
	public DecoratorCalculator(Calculator calc) {
		this.calc = calc;
	}
	
	@Override
	public int add(int n1, int n2) {
		return calc.add(n1, n2);
	}
	
}

class ScientificCalculator extends DecoratorCalculator {
	
	public ScientificCalculator(Calculator calc) {
		super(calc);
	}

	public int square(int n1, int n2) {
		return n1*n2;
	}
	
}
public class DecoratorPatternTest {

	public static void main(String[] args) {

		ScientificCalculator c = new ScientificCalculator(new BasicCalculator());
		System.out.println(c.add(10, 20));
		System.out.println(c.square(10, 20));
	}

}
