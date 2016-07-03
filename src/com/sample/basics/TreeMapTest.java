package com.sample.basics;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

	static class Employee implements Comparable<Employee> {
		private String name;
		private int age;
		private int salary;

		public Employee(String name, int age, int salary) {
			this.name = name;
			this.age = age;
			this.salary = salary;
		}

		@Override
		public int compareTo(Employee o) {
			int i = name.compareTo(o.name);
			if (i == 0) {
				return this.age - o.age;
			}
			return i;
		}
	}

	public static void main(String[] args) {
		Map<Employee, Integer> tMap = new TreeMap<>();
		Employee e1 = new Employee("Prabhu", 33, 50000);
		Employee e2 = new Employee("Prabhu", 34, 50000);
		Employee e3 = new Employee("Prabhu1", 35, 50000);
		tMap.put(e1, 1);
		tMap.put(e2, 1);
		tMap.put(e3, 1);
		for (Map.Entry<Employee, Integer> entry : tMap.entrySet()) {
			System.out.print(entry.getKey().name + " ");
			System.out.println(entry.getValue());
		}

	}

}
