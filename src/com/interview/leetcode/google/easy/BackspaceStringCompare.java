package com.interview.leetcode.google.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/backspace-string-compare/description/
 */
public class BackspaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
		Deque<Character> stack1 = new ArrayDeque<>();
		for (Character c : S.toCharArray()) {
			if (c == '#') {
				if (stack1.size() > 0) {
					stack1.pop();
				}
			} else {
				stack1.push(c);
			}
		}
		Deque<Character> stack2 = new ArrayDeque<>();
		for (Character c : T.toCharArray()) {
			if (c == '#') {
				if (stack2.size() > 0) {
					stack2.pop();
				}
			} else {
				stack2.push(c);
			}
		}
		if (stack1.size() != stack2.size()) {
			return false;
		}
		while (stack1.size() > 0) {
			if (stack1.pop() != stack2.pop()) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		BackspaceStringCompare b = new BackspaceStringCompare();
		b.backspaceCompare("y#fo##f", "y#f#o##f");

	}
}
