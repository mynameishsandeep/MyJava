package com.interview.leetcode.uber.medium;

/*
 * https://leetcode.com/problems/solve-the-equation/description/

https://leetcode.com/problems/solve-the-equation/discuss/150021/Clear-Java-Code-with-Detailed-Example
Example
e.g. x+5-3+x=6+x-2

1) Firstly, we split the equation by "=":
leftPart is x+5-3+x;
rightPart is 6+x-2;
2) Secondly, we sum up coefficient and the rest numbers separately, i.e.
leftVals is 2x + 2, i.e., [2, 2];
rightVals is x + 4, i.e., [1, 4];
3) Thirdly, we solve the simplified equation by moving all elements to the left of "=",
cntX = leftVals[0] - rightVals[0];, i.e., 2 - 1 = 1,
cntNum = leftVals[1] - rightVals[1];, i.e., 2 - 4 = -2,
cntX * x + cntNum = 0, i.e., 1 * x + (-2) = 0,
x = (-cntNum) / cntX, i.e., x = 2
 */
public class SolveTheEquation {

	public String solveEquation(String equation) {

		String[] parts = equation.split("=");
		String leftPart = parts[0], rightPart = parts[1];
		int[] leftVals = evaluate(leftPart), rightVals = evaluate(rightPart);
		int cntX = leftVals[0] - rightVals[0];
		int cntNum = leftVals[1] - rightVals[1];
		if (cntX == 0) {
			if (cntNum != 0)
				return "No solution";
			return "Infinite solutions";
		}
		int valX = (-cntNum) / cntX;
		StringBuilder result = new StringBuilder();
		result.append("x=").append(valX);

		return result.toString();
	}

	private int[] evaluate(String exp) {

		int[] result = new int[2];
		String[] expElements = exp.split("(?=[-+])");

		for (String ele : expElements) {
			if (ele.equals("+x") || ele.equals("x")) {
				result[0]++;
			} else if (ele.equals("-x")) {
				result[0]--;
			} else if (ele.contains("x")) {
				result[0] += Integer.valueOf(ele.substring(0, ele.indexOf("x")));
			} else {
				result[1] += Integer.valueOf(ele);
			}
		}

		return result;
	}
}
