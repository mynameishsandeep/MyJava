package com.sample.designpattern.abstractfactory;

public class AbstractFactoryTest {
	public static void main(String[] args) {
		AbstractFactory as = FactoryProducer.getFactory("SHAPE");
		Circle c = (Circle) as.getShape("CIRCLE");
		c.draw();
	}
}

abstract class AbstractFactory {
	public abstract Color getColor(String color);
	public abstract Shape getShape(String shape);
}

class FactoryProducer {
	public static AbstractFactory getFactory(String factory) {
		if ("SHAPE".equals(factory)) {
			return new ShapeFactory();
		} else {
			return new ColorFactory();
		}
	}
}

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

interface Color {
	public void fill();
}

class Red implements Color {
	public void fill() {
		System.out.println("Inside Red Fill");
	}
}

class Yellow implements Color {
	public void fill() {
		System.out.println("Inside Yellow Fill");
	}
}

class ShapeFactory extends AbstractFactory {
	public Shape getShape(String shape) {
		if ("CIRCLE".equals(shape)) {
			return new Circle();
		}
		return new Square();
	}

	@Override
	public Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}
}

class ColorFactory extends AbstractFactory {
	public Color getColor(String color) {
		if ("RED".equals(color)) {
			return new Red();
		}
		return new Yellow();
	}

	@Override
	public Shape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}
}
