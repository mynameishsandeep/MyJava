package com.sample.generics;

import java.util.ArrayList;
import java.util.List;

class Fruit {
	@Override
	public String toString() {
		return "I am a Fruit !!";
	}
}

class Apple extends Fruit {
	@Override
	public String toString() {
		return "I am an Apple !!";
	}
}

class AsianApple extends Apple {
	   @Override
	   public String toString() {
	      return "I am an AsianApple !!";
	   }
	}
	 
public class GenericsExample {
	public static void main(String[] args) {
		List<Fruit> fruits = new ArrayList<Fruit>();
		List<Apple> apples = new ArrayList<Apple>();
		List<AsianApple> asianApples = new ArrayList<AsianApple>();

		add1(fruits);
		add1(apples);
		add1(asianApples);
		
		add2(fruits);
		add2(apples);
		add2(asianApples);

		add3(fruits);
		add3(apples);
		add3(asianApples);
	
		add4(fruits);
		add4(apples);
		add4(asianApples);

		add5(fruits);
		add5(apples);
		add5(asianApples);

	}

	private static void add1(List<? extends Apple> apples) {
		//apples.add(new Fruit());
		//apples.add(new Apple());
		//apples.add(new AsianApple());
		apples.add(null);
		
		Apple a = apples.get(0);
		Object a1 = apples.get(0);
	}

	private static void add2(List<Apple> apples) {
		apples.add(new Fruit());
		apples.add(new Apple());
		apples.add(new AsianApple());
	}

	private static void add3(List<? super Apple> apples) {
		apples.add(new Fruit());
		apples.add(new Apple());
		apples.add(new AsianApple());
		
		Apple a = apples.get(0);
		Object a1 = apples.get(0);
		
	}

	private static void add4(List<?> apples) {
		//apples.add(new Fruit());
		//apples.add(new Apple());
		//apples.add(new AsianApple());
		apples.add(null);
	}

	private static void add5(List apples) {
		apples.add(new Fruit());
		apples.add(new Apple());
		apples.add(new AsianApple());
		apples.add(null);
	}

}