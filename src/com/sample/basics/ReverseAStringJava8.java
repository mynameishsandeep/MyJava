package com.sample.basics;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseAStringJava8 {

	/**
	 * Input : 2 45 32 Output : 32 45
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			int total = scan.nextInt();
			Stack<Integer> intList = new Stack<>();
			for (int i = 0; i < total; i++) {
				intList.add(scan.nextInt());
			}
			/*
			 * intList.stream().collect(Collectors.toCollection(ArrayDeque::new))
			 * // or LinkedList .descendingIterator()
			 * .forEachRemaining(System.out::println);
			 */

			Collections.reverse(intList);
			System.out.println(intList.stream().map(Object::toString)
					.collect(Collectors.joining(" ")));
		}

	}
}
