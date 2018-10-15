package com.interview.leetcode.linkedin.medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Set<String> operator = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
		Deque<String> stack = new LinkedList<>();
		for (String str : tokens) {
			if (operator.contains(str)) {
				int num1 = new Integer(stack.pop());
				int num2 = new Integer(stack.pop());
				stack.push("" + doOperation(str, num1, num2));
			} else {
				stack.push(str);
			}
		}
		return new Integer(stack.pop());
	}

	public int doOperation(String operation, int num2, int num1) {
		switch (operation) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			return num1 / num2;

		}
		return 0;
	}
}
