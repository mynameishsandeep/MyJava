package com.sample.designpattern;

class Person1 {
	private String name;
	private String age;
/*	private final String name;
	private final String age;
*/	public Person1 setName(String name) {
		this.name = name;
		return this;
	}

	public Person1 setAge(String age) {
		this.age = age;
		return this;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}
}

public class BuilderPatternTest1 {

	public static void main(String[] args) {
		Person1 p = new Person1().setName("Prabhu").setAge("32");
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}

}
