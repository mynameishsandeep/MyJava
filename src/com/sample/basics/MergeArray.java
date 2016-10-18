package com.sample.basics;

public class Dummy {

	public static void main(String args[]) throws Exception {
		String a ="logback.name.online-core";
		
		String projectName = a.split("logback.name.")[1];
		
			System.out.println(projectName);

	}

}
