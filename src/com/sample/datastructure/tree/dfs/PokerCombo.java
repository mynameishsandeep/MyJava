package com.sample.datastructure.tree.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * This sum is answered based on GroupSum approach. 
 * In GroupSum approach, combination is formed for all lengths of input and 
 * from that approach we take the specific size of Poker Hand (2) needed.  
 */
public class PokerCombo {

	private static Integer comboLength = 2;

	public static void main(String[] args) {
		Integer input[] = { 1, 2, 3, 4 };
		permute(input, 0, new ArrayList<Integer>());
	}

	public static void permute(Integer arr[], Integer start, List<Integer> combo) {
		// Base Condition
		if (start == arr.length) {
			//System.out.println(combo);//All Combination result
			if (combo.size() == comboLength) {
				System.out.println(combo);
			}
			return;
		}

		permute(arr, start + 1, copy(combo, arr[start]));
		permute(arr, start + 1, combo);
	}

	public static List<Integer> copy(List<Integer> input, Integer data) {
		List<Integer> result = new ArrayList<>();
		result.addAll(input);
		result.add(data);
		return result;
	}
}
