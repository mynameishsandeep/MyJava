package com.interview.leetcode.google.hard;

import java.util.ArrayDeque;

/*
 * https://leetcode.com/problems/basic-calculator/description/
 * 
 * 2-1+3 = 4 
 * 
 * Key point is doing calculation from left to right.
 * If i put everything in stack and do calculation at end. Then result varies. Because of stack operation (LIFO)
 * Ex: 2-1+3--- (3+1) =4 --- 4-2=2 ---> which is wrong.
 * So calculate when a "operator(+,-) is found" or when ")" is found.   
 */
public class BasicCalculator {
	public int calculate(String str) {
		ArrayDeque<Character> operatorStack = new ArrayDeque<>();
		ArrayDeque<Integer> operandStack = new ArrayDeque<>();
		StringBuilder s = new StringBuilder();
		for (Character c : str.toCharArray()) {
			if (isOperator(c)) {
				if (s.length() > 0) {
					operandStack.push(Integer.valueOf(s.toString()));
					s = new StringBuilder();
				}
				if (operatorStack.size() > 0 && isOperator(operatorStack.peek())) {
					operandStack.push(doOperation(operandStack.pop(), operandStack.pop(), operatorStack.poll()));
				}
				operatorStack.push(c);
			} else if (c == '(') {
				operatorStack.push('(');
			} else if (c == ')') {
				if (s.length() > 0) {
					operandStack.push(Integer.valueOf(s.toString()));
					s = new StringBuilder();
				}
				while (!operatorStack.isEmpty()) {
					if (operatorStack.peek() == '(') {
						operatorStack.pop();
						break;
					}
					operandStack.push(doOperation(operandStack.pop(), operandStack.pop(), operatorStack.poll()));
				}
			} else {
				// accumulate numbers in builder
				if (c != ' ') {
					s.append(c);
				}
			}
		}
		// Push the last number
		if (s.length() > 0) {
			operandStack.push(Integer.valueOf(s.toString()));
		}
		if (!operatorStack.isEmpty()) {
			operandStack.push(doOperation(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
		}
		return operandStack.pop();

	}

	private boolean isOperator(final Character c) {
		return c == '+' || c == '-';
	}

	private int doOperation(final int data1, final int data2, final Character operator) {
		switch (operator) {
		case '+':
			return data2 + data1;
		case '-':
			return data2 - data1;
		}
		return 0;
	}
}
