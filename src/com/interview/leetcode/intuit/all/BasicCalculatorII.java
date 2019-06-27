package com.interview.leetcode.intuit.all;

import java.util.ArrayDeque;

/*
 * https://leetcode.com/problems/basic-calculator-ii/description/
 * 
 * 1) Hold(Iterated from input) a operator in hand. 
 * 2) Look(peek) for previous operator in stack. 
 * 3a) If previous operator is "equal or higher precedence", evaluate data1, data2 with previous operator(poll).
 * 		Push the result data back to stack.
 * 		Goto step 2.
 * 3b) Else push the current operator to stack.  
 * 4) Goto step1.    
 */
public class BasicCalculatorII {
	public int calculate(String str) {
		ArrayDeque<Character> operatorStack = new ArrayDeque<>();
		ArrayDeque<Integer> operandStack = new ArrayDeque<>();
		StringBuilder s = new StringBuilder();
		for (Character c : str.toCharArray()) {
			if (isOperator(c)) {
				operandStack.push(Integer.valueOf(s.toString()));
				s = new StringBuilder();
				// Below while is very important. If an opertaion is evaluated. Then all previous needs to evaluated.
				// Ex: "1*2-3/4+5*6-7*8+9/10"
				while (!operatorStack.isEmpty()) {
					if (isPreviousEqualOrHigherPrecedence(operatorStack.peek(), c)) {
						int data1 = operandStack.pop();
						int data2 = operandStack.pop();
						operandStack.push(doOperation(data1, data2, operatorStack.poll()));
					} else {
						break;
					}
				}
				operatorStack.push(c);
			} else {
				// accumulate numbers in builder
				if (c != ' ') {
					s.append(c);
				}
			}
		}
		// Push the last number
		operandStack.push(Integer.valueOf(s.toString()));

		while (!operatorStack.isEmpty()) {
			operandStack.push(doOperation(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
		}
		return operandStack.pop();

	}

	private boolean isOperator(final Character c) {
		return c == '*' || c == '/' || c == '+' || c == '-';
	}

	private int doOperation(final int data1, final int data2, final Character operator) {
		switch (operator) {
		case '*':
			return data2 * data1;
		case '/':
			if (data1 == 0)
				return 0;
			return data2 / data1;
		case '+':
			return data2 + data1;
		case '-':
			return data2 - data1;
		}
		return 0;
	}

	private boolean isPreviousEqualOrHigherPrecedence(final Character c1, final Character c2) {
		int c1Precedence = c1 == '*' || c1 == '/' ? 1 : 0;
		int c2Precedence = c2 == '*' || c2 == '/' ? 1 : 0;
		return c1Precedence >= c2Precedence;
	}
}
