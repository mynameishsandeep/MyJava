package com.sample.generics;

public class Employee<type1,type2> {
	private type1 name;
	private type2 age;
	

	public static void main(String[] args) {
		Employee<String, String> emp = new Employee<>();
		emp.name = "Prabhu";
		emp.age = "32";
		System.out.println(emp.name + emp.age);
	}
}
