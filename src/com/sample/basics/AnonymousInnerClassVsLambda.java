package com.sample.basics;


public class AnonymousInnerClassVsLambda {

	interface Employee {
		abstract void address();
	}

	public static void main(String[] args) {
		Employee anonymousPerson = new Employee() {
			public void address() {
				System.out.println("Anonymous Employee Address");
			}
		};
		anonymousPerson.address();

		Employee lambdaPerson = () -> {System.out.println("Lambda Employee Address");};
		lambdaPerson.address();
	}

}
