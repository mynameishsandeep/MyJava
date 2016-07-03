package com.sample.basics;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

//Evaluate expression [{()}]-->success [(])-->failure.
public class EvaluateExpressionTest {

	public static void main(String[] args) {

		Map<Character, Character> charMap = new HashMap<>();
		charMap.put('(', ')');
		charMap.put('{', '}');
		charMap.put('[', ']');

		Scanner in = new Scanner(System.in);

		Deque<Character> stack = new LinkedList<Character>();
		String currentString = "";
		String closeOperand = "})]";
		String openOperand = "{([";
		Scanner scan = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			in.nextLine();
			currentString = in.next();
			System.out.println(currentString);
			stack = new LinkedList<Character>();
			for (int j = 0; j < currentString.length(); j++) {
				char currentChar = currentString.charAt(j);
				if (closeOperand.indexOf(currentChar) == -1) {
					if (openOperand.indexOf(currentChar) > -1)
						stack.push(currentChar);
				} else {
					if (stack.size() == 0) {
						stack.push(currentChar);
						break;
					}
					char c = stack.pop();
					if (currentChar != charMap.get(c)) {
						stack.push(currentChar);
						break;
					}
				}
			}
			if (stack.size() > 0) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
