package com.sample.designpattern;

import lombok.Data;
import lombok.Getter;

@Data
// This annotation will provide getters alone and not setters.
@Getter 
class Person {
	private final String name;
	private final String age;
	static class PersonBuilder {
		private String name;
		private String age;

		public PersonBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public PersonBuilder setAge(String age) {
			this.age = age;
			return this;
		}
		
		public Person build() {
			return new Person(this);
		}
	}
	
	private Person(PersonBuilder builder) {
		this.name = builder.name;
		this.age =builder.age;
	}
	public static void main(String[] args) {
		Person p = new Person.PersonBuilder().setName("Prabhu").setAge("32").build();

	}
}


public class BuilderPatternTest {


	public static void main(String[] args) {
		Person p = new Person.PersonBuilder().setName("Prabhu").setAge("32").build();

	}

}
