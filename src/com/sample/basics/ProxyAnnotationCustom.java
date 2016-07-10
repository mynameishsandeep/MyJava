package com.sample.basics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Scanner;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface EmployeeEvent {
	String employeeRole() default "GUEST";
	int budgetLimit() default 0;
}

class Employee {
	String name;
	Employee(String name) {
		this.name = name;
	}
	@EmployeeEvent(employeeRole = "SENIOR", budgetLimit = 100)
	public void seniorEmployeeBenefits(int budget, int moneySpend) {
		System.out.println("Employee Name is " + name);
		System.out.println("He/She is a Senior Member");
		System.out.println("Has Spend: " + moneySpend);
		System.out.println("Remaining Budget Left are : " + (budget - moneySpend));
	}

	@EmployeeEvent(employeeRole = "JUNIOR", budgetLimit = 50)
	public void juniorEmployeeBenefits(int budget, int moneySpend) {
		System.out.println("Employee Name is " + name);
		System.out.println("He/She is a Junior Member");
		System.out.println("Has Spend: " + moneySpend);
		System.out.println("Remaining Budget Left are : " + (budget - moneySpend));
	}
}

class EmployeeProxy {
	public static void execute(Employee emp, String role, int spend) {
		try {
			Method[] methods = emp.getClass().getMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(EmployeeEvent.class)) {
					EmployeeEvent family = method
							.getAnnotation(EmployeeEvent.class);
					String userRole = family.employeeRole();
					int userBudget = family.budgetLimit();
					if (userRole.equals(role)) {
						if (userBudget > spend) {
							System.out
									.println("Employee Proxy is called before Employee invocation");
							method.invoke(emp,
									userBudget, spend);
						} else {
							System.out.println("Budget Limit Over");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out
					.println("Employee Proxy is called after Employee invocation");
		}

	}
}

public class ProxyAnnotationCustom {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			String name = in.next();
			String role = in.next();
			int spend = in.nextInt();
			Employee e = new Employee(name);
			EmployeeProxy.execute(e, role, spend);
			testCases--;
		}

		/*
		 * Employee e = new Employee(); e.juniorEmployee(100, 40);
		 */}
}
