package com.sample.basics;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Evaluate expression [{()}]-->success [(])-->failure.
public class EvaluateExpressionTest {

	public static void main(String[] args) {
		EvaluateExpressionTest e = new EvaluateExpressionTest();
		String input = "{{}}";
		System.out.println(e.evalExpression(input));
		input = "{{}{";
		System.out.println(e.evalExpression(input));
		input = "{[}]";
		System.out.println(e.evalExpression(input));

	}

	private Boolean evalExpression(String input) {
		Map<Character, Character> charMap = new HashMap<>();
		charMap.put('(', ')');
		charMap.put('{', '}');
		charMap.put('[', ']');

		Deque<Character> stack = new LinkedList<Character>();
		List<Character> closeOperand = Arrays.asList('}', ')', ']');

		for (Character currentChar : input.toCharArray()) {
			if (closeOperand.contains(currentChar)) {
				Character previousChar = stack.pop();
				if (charMap.get(previousChar) != currentChar) {
					return false;
				}
			} else {
				stack.push(currentChar);
			}
		}
		return stack.size() == 0;
	}
}
