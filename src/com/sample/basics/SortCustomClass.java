package com.sample.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

abstract class Pet implements Comparable {
	String name;
	@Override
	public int compareTo(Object o) {
		if (null != o && Dog.class == o.getClass()) {
			Dog d = (Dog) o;
			return this.name.compareTo(d.name);
		}
		return 0;
	}
}
class Cat {
	String sound;
}

class Dog extends Pet implements Comparable {

	String sound;
	
	@Override
	public int compareTo(Object o) {
		if (null != o && Dog.class == o.getClass()) {
			Dog d = (Dog) o;
			return d.name.compareTo(this.name);
		}
		return 0;
	}
}

class DogComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stubif (null != o && Dog.class == o.getClass()) {
		Dog d1 = (Dog) o1;
		Dog d2 = (Dog) o2;
		return d1.sound.compareTo(d2.sound);
	}
	
}
public class SortCustomClass {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.name = "c";
		d.sound = "s";
		Dog d1 = new Dog();
		d1.name = "a";
		d.sound = "t";
		Dog d2 = new Dog();
		d2.name = "d";
		d.sound = "r";
		List<Dog> dogList = new ArrayList<>();
		dogList.add(d);dogList.add(d1);dogList.add(d2);
		
		Collections.sort(dogList, new DogComparator());
		
		for(Dog dog : dogList) {
			System.out.println(dog.name);
			System.out.println(dog.sound);
		}
	}

}
