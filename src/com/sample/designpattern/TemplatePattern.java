package com.sample.designpattern;

interface WorkflowManager {
	public default void doTask1() {
		System.out.println("Doing Task1...");
	}

	public void doTask2();

	public default void doTask3() {
		System.out.println("Doing Task3...");
	}

	public default void doTask4() {
		doTask2();
		doTask3();
		System.out.println("Doing Task4...");
	}
}


public class TemplatePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
