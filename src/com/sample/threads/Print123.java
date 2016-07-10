package com.sample.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Print123 {

	Lock lock = new ReentrantLock(true);

	Condition con1 = lock.newCondition();
	Condition con2 = lock.newCondition();
	Condition con3 = lock.newCondition();

	Callable c1 = () -> {
		for (int i = 1; i < 10; i++) {
			lock.lock();
			System.out.println("1");
			con2.signal();
			con1.await();

		}
		System.out.println("T1 Exiting");
		con2.signal();
		con1.await();
		return "null";
	};

	Callable c2 = () -> {
		for (int i = 11; i < 20; i++) {
			lock.lock();
			System.out.println("2");
			con3.signal();
			con2.await();
		}
		System.out.println("T2 Exiting");
		con3.signal();
		con2.await();
		return null;
	};

	Callable c3 = () -> {
		for (int i = 21; i < 30; i++) {
			lock.lock();
			System.out.println("3");
			con1.signal();
			con3.await();
		}
		System.out.println("T3 Exiting");
		con2.signal();
		return null;
	};

	public static void main(String[] args) throws Exception {
		Print123 tp = new Print123();
		FutureTask<String> f1 = new FutureTask<>(tp.c1);
		Thread t1 = new Thread(f1);
		t1.start();

		Thread.currentThread().sleep(10);// To make sure 1 prints always first
		FutureTask<String> f2 = new FutureTask<>(tp.c2);
		Thread t2 = new Thread(f2);
		t2.start();

		Thread.currentThread().sleep(10);// To make sure 2 prints always second
		FutureTask<String> f3 = new FutureTask<>(tp.c3);
		Thread t3 = new Thread(f3);
		t3.start();
		System.out.println(f3.get());
		System.exit(1);
	}

}
