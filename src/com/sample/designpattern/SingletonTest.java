package com.sample.designpattern;

class ClassicSingleton {
	private static ClassicSingleton instance = new ClassicSingleton();
	private static volatile ClassicSingleton instance2;

	/**
	 * • Through Reflection Load class • modify private constructor to public..
	 * • Create instance.
	 */
	private ClassicSingleton() {
		if (instance2 != null) {
			throw new IllegalStateException("Singleton" + " instance already created.");
		}
	}

	public static ClassicSingleton getInstance() {
		return instance;
	}

	public static ClassicSingleton getInstance2() {
		if (instance2 == null) {
			synchronized (instance2) {
				instance2 = new ClassicSingleton();
			}
		}
		return instance2;
	}
}

// Cannot be extended because Singleton has private Constructor.
public class SingletonTest { // extends ClassicSingleton {

	public static void main(String[] args) {

	}

}
