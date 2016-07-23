package com.sample.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashMapEmployee {

	static class Employee implements Comparable<Employee> {
		String f;
		String l;
		int a;
		public Employee(String f, String l, int a) {
			this.f = f;this.l=l; this.a=a;
		}
		@Override
		public int compareTo(Employee e) {
			if(e == null || e.f== null) {
				throw new NullPointerException("F is null");
			}
			return this.f.compareTo(e.f);
		}
		
		@Override
		public int hashCode() {
			return f.hashCode()*7;
		}
		@Override
		public boolean equals(Object o) {
			if (o == null || o.getClass() != this.getClass()) {
				return false;
			}
			if(this == o) {
				return true;
			}
			return this.f.equals(((Employee)o).f);
		}
	}
	
	public static void main(String[] args) {
		Employee e1 = new Employee("f1","l1",20);
		Employee e2 = new Employee("f2","l2",30);
		Employee e3 = new Employee("f3","l3",25);
		Employee e4 = new Employee("f3","l3",25);
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
		
		for(Employee emp : set) {
			System.out.print(emp.f);
			System.out.print(emp.l);
			System.out.print(emp.a);
			System.out.println();
		}
		
		for(Employee emp : hSet) {
			System.out.print(emp.f);
			System.out.print(emp.l);
			System.out.print(emp.a);
			System.out.println();
		}
	}

}
