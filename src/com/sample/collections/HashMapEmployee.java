package com.sample.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashMapEmployee {

	static class Employee implements Comparable<Employee> {
		String firstName;
		String lastName;
		int age;

		public Employee(String f, String l, int a) {
			this.firstName = f;
			this.lastName = l;
			this.age = a;
		}

		@Override
		public int compareTo(Employee e) {
			if (e == null || e.firstName == null) {
				throw new NullPointerException("F is null");
			}
			return this.firstName.compareTo(e.firstName);
		}

		@Override
		public int hashCode() {
			return firstName.hashCode() * 7;
		}

		@Override
		public boolean equals(Object o) {
			if (o == null || o.getClass() != this.getClass()) {
				return false;
			}
			if (this == o) {
				return true;
			}
			return this.firstName.equals(((Employee) o).firstName);
		}
	}

	public static void main(String[] args) {
		Employee e1 = new Employee("f1", "l1", 20);
		Employee e2 = new Employee("f2", "l2", 30);
		Employee e3 = new Employee("f3", "l3", 25);
		Employee e4 = new Employee("f3", "l3", 25);
		Set<Employee> set = new TreeSet<>();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);

		Set<Employee> hSet = new HashSet<>();
		hSet.add(e1);
		hSet.add(e2);
		hSet.add(e3);
		hSet.add(e4);

		for (Employee emp : set) {
			System.out.print(emp.firstName);
			System.out.print(emp.lastName);
			System.out.print(emp.age);
			System.out.println();
		}

		for (Employee emp : hSet) {
			System.out.print(emp.firstName);
			System.out.print(emp.lastName);
			System.out.print(emp.age);
			System.out.println();
		}
	}

}
