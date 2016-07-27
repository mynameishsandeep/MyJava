package com.sample.datastructure;

import java.util.Arrays;

public class QueueUsingArray<T> {

	int front, rear = 0;
	T[] data;

	QueueUsingArray(int size) {
		data = (T[])new Object [size];
	}
	
	public void insert(T data) {
		this.data[front] = data;
	}

	public static void main(String[] args) {
		QueueUsingArray<Integer> queue = new QueueUsingArray<>(10);
		Arrays.fill(queue.data, -1);
		
		
	}

}
