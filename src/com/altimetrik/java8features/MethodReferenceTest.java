package com.altimetrik.java8features;

import java.time.LocalDate;

class Person {

	public enum Sex {
		MALE, FEMALE
	}

	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;

	public int getAge() {
		return 20;
	}

	public static int getAge1() {
		return 20;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}
}

public class MethodReferenceTest {

	public static void main(String[] args) {
		//Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
		int x=Person::getAge1;

	}

}
