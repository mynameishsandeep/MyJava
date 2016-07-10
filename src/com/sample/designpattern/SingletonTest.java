package com.sample.designpattern;

class ClassicSingleton {
	   private static ClassicSingleton instance = new ClassicSingleton();;
	   private ClassicSingleton() {	   }
	   public static ClassicSingleton getInstance() {
	      return instance;
	   }
	}

public class SingletonTest { //extends ClassicSingleton {// Cannot be extended because Singleton has private Constructor. 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
