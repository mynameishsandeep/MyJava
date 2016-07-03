package com.sample.designpattern;

interface Shape {
	public void draw();
}

class Circle implements Shape {
	public void draw() {
		System.out.println("Inside Circle Draw");
	}
}

class Square implements Shape {
	public void draw() {
		System.out.println("Inside Square Draw");
	}
}

class ShapeFactory {
	public static Shape getShape(Class<? extends Shape> c) {
		
		if (c.getName().equals(Circle.class.getName())) {
			return new Circle();
		}
		return new Square();
	}
}

public class FactoryMethodClient {
	public static void main(String[] args) {
		Shape s = ShapeFactory.getShape(Circle.class);
		s.draw();
		
		Shape s1 = ShapeFactory.getShape(Square.class);
		s1.draw();

	}

}
