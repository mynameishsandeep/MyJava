package com.altimetrik.java8features;

import java.util.Arrays;
import java.util.List;

public class MethodReferences {
	static class Person {
		String name;
		public Person(String name) {
			this.name = name;
		}
	}
	public static void main(String[] args) {
		// ----- Prior to Java 1.8 -----
		List<Person> persons = Arrays.asList(new Person("Joe"), new Person("Jim"), new Person("John"));
		for(Person person : persons) {
		  doSomething(person);
		}
		
		// ----- Java 1.8 Expressions  ----- Method References using Scope Resolution Operator 
		persons.forEach(MethodReferences::doSomething);
	}
	public static void doSomething(Person person) {
		System.out.println(person.name);
	}
}
