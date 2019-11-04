package com.sample.basics;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetEmployeeTest {

	class Employee implements Comparable<Employee> {
		private String firstName;
		private String lastName;
		private int age;
		private int Salary;

		public Employee(String f, String l) {
			firstName = f;
			lastName = l;
		}

		@Override
		public int compareTo(Employee o) {
			return this.firstName.compareTo(o.firstName);
		}

	}

	public static void main(String[] args) {
		Employee e1 = new TreeSetEmployeeTest().new Employee("f1", "l1");
		Employee e2 = new TreeSetEmployeeTest().new Employee("Thanga", "Prabhu");
		Employee e3 = new TreeSetEmployeeTest().new Employee("Ravi", "Kumar");
		Employee e4 = new TreeSetEmployeeTest().new Employee("j1", "Kumar");
		Employee e5 = new TreeSetEmployeeTest().new Employee("i1", "Kumar");
		Employee e6 = new TreeSetEmployeeTest().new Employee("i1", "Ticket");
		Set<Employee> tSet = new TreeSet<Employee>();
		tSet.add(e1);
		tSet.add(e2);
		tSet.add(e3);
		tSet.add(e4);
		tSet.add(e5);
		tSet.add(e6);

		for(Employee emp : tSet) {
			System.out.println(emp.firstName + " " + emp.lastName);
		}
		Iterator<Employee> it = tSet.iterator();
		while (it.hasNext()) {
			Employee e = it.next();
			System.out.println(e.firstName + " " + e.lastName);
		}

	}

}
