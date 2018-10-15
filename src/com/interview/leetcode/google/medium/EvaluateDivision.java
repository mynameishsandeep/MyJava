package com.interview.leetcode.google.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		Map<String, Map<String, Double>> equationsMap = new HashMap<>();
		for (int i = 0; i < equations.length; i++) {
			if (equationsMap.containsKey(equations[i][0])) {
				equationsMap.get(equations[i][0]).put(equations[i][1], values[i]);
			} else {
				Map<String, Double> m = new HashMap<>();
				m.put(equations[i][1], values[i]);
				equationsMap.put(equations[i][0], m);
			}

			if (equationsMap.containsKey(equations[i][1])) {
				equationsMap.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
			} else {
				Map<String, Double> m = new HashMap<>();
				m.put(equations[i][0], 1 / values[i]);
				equationsMap.put(equations[i][1], m);
			}
		}

		//		for (Map.Entry<String, Map<String, Double>> entry : map.entrySet()) {
		//			System.out.println(entry.getKey());
		//			System.out.println(entry.getValue());
		//		}
		double result[] = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
			result[i] = calc(equationsMap, queries[i][0], queries[i][1], new HashSet<>(), 1);
			System.out.println(result[i]);
		}
		return result;

	}

	public double calc(Map<String, Map<String, Double>> equationsMap, String numerator, String denominator,
			Set<String> visited, double currentResult) {

		if (equationsMap.containsKey(numerator)) {
			Map<String, Double> m = equationsMap.get(numerator);
			
			
		} else {
			return currentResult == 1 ? -1 : currentResult;
		}
		return 0.0;
		
	}

	public static void main(String[] args) {
		EvaluateDivision e = new EvaluateDivision();
		String equations[][] = { { "a", "b" }, { "b", "c" } };
		double values[] = { 2.0, 3.0 };
		String queries[][] = { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" } };
		System.out.println(Arrays.toString(e.calcEquation(equations, values, queries)));

	}

}
