package com.sample.designpattern;

public class Prototype {

	private String name;
	
	public Prototype() {
		
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Prototype p1 = new Prototype();
		p1.setName("Prabhu");
		Prototype p2 = (Prototype)p1.clone();
		System.out.println(p2.name);
	}
}
