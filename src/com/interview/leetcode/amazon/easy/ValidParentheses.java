package com.interview.leetcode.amazon.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {
	/*
	 * Push the close element instead of open element and compare.
	 * So no need for HashMap
	 */
	public boolean isValid_Efficient(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for (Character c : s.toCharArray()) {
			switch (c) {
			case '(':
				stack.push(')');
				break;
			case '{':
				stack.push('}');
				break;
			case '[':
				stack.push(']');
				break;
			default:
				if (stack.isEmpty() || c != stack.pop()) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public boolean isValid(String s) {
		Map<Character, Character> oc = new HashMap<>();
		oc.put('(', ')');
		oc.put('{', '}');
		oc.put('[', ']');

		Deque<Character> stack = new ArrayDeque<>();
		for (Character c : s.toCharArray()) {
			if (oc.get(c) != null) {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				if (oc.get(stack.pop()) != c) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
