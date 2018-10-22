package com.interview.leetcode.linkedin.hard;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/expression-add-operators/solution/
 * 
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators 
 * +, -, or * between the digits so they evaluate to the target value.
 * Solution: 
 * 1) We have multiple choices of what operators to use and what the operands can be and hence, 
 * we have to look at all the possibilities to find all valid expressions.
 * 2) recursion step will have an index and the original string of digits as input along with the expression built till now.
 * 3) At every step, we consider all possible operands starting from index 0 to n-1 i.e. 
 * all substrings digits[index : ]digits[index:] and once we fix an operand, 
 * we will have three recursive calls wherein we try 3 different operators after this operand.
 * 4) a little trick is that we should save the value that is to be multiplied in the next recursion.
 * 
 * Note: The result should include all input characters.
 * ===========Note:   Understand ExpressionAddOperatorsPlusMinusAlone.java before looking into this======
 * 
1
1+2
1+2+3
1+2-3
1+2*3
1-2
1-2+3
1-2-3
1-2*3
1*2
1*2+3
1*2-3
1*2*3
1+23
1-23
1*23
12
12+3
12-3
12*3
123

 * 
 */
public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> rst = new ArrayList<String>();
		if (num == null || num.length() == 0)
			return rst;
		helper(rst, "", num, target, 0, 0, 0);
		return rst;
	}

	public void helper(List<String> result, String prefix, String input, int target, int index, long eval,
			long multed) {
		
		if (index == input.length()) {
			if (target == eval) {
				result.add(prefix);
			}
			return;
		}
		for (int i = index; i < input.length(); i++) {
			long suffix = Long.parseLong(input.substring(index, i + 1));
			System.out.println("suffix" + suffix);
			System.out.println();
			if (index == 0) {
				helper(result, prefix + suffix, input, target, i + 1, suffix, suffix);
			} else {
				helper(result, prefix + "+" + suffix, input, target, i + 1, eval + suffix, suffix);

				helper(result, prefix + "-" + suffix, input, target, i + 1, eval - suffix, -suffix);

				System.out.println();
				System.out.println("eval " + eval);
				System.out.println("path " + prefix);
				System.out.println("num " + input);
				System.out.println("prefix " + eval);
				System.out.println("multed " + multed);
				helper(result, prefix + "*" + suffix, input, target, i + 1, eval - multed + multed * suffix,
						multed * suffix);
			}
		}
	}

	public static void main(String[] args) {
		ExpressionAddOperators e = new ExpressionAddOperators();
		e.addOperators("123", 6);
	}

}
