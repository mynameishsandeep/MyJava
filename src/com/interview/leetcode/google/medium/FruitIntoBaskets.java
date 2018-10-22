package com.interview.leetcode.google.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/fruit-into-baskets/description/
 * 
 * Problem Understanding: At any-time I can have only 2 basket and I can fill only one type of fruit in each basket.
 * So fill fruits in each specific basket and count max of fruit.
 * When encountering a new fruit. Throw away fruit of minimum count and start fill next fruit.
 * Ex: [banana, banana, banana, apple, apple, cherry, cherry]...
 * fill basket1 with banana,banana,banana.
 * fill basket2 with apple, apple.
 * Throw away apple.. fill cherry cherry
 * 
 * 
 * Logic:sliding window: When the window size is exceeded, remove the value of lowest index.
 * =======================
 * Ex1: [3, 3, 3, 1, 1, 2]  
 * [3,0] [3,1] [3,2] ---
 * [1,3] [1,4] ---
 * [2,5] --> Exceeded window... Remove Lowest window [3,2]...
 * =======================
 * Ex2:[1, 1, 2, 1, 1, 2, 3, 3, 4]
 * [1,0] [1,1] [1,3] [1,4] --- 
 * [2,2] [2,5] ---
 * [3,6] --> Exceeded window. Remove Lowest Window [1,4]
 * =======================
 */
public class FruitIntoBaskets {

	public int totalFruit(int[] tree) {
		int maxFruit = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int currentIndex = 0;
		int newIndexAfterThrowing = 0;
		for (int fruit : tree) {
			map.put(fruit, currentIndex);
			if (map.size() > 2) { // 2 Baskets are full. Throw away fruit from minimum fruit bucket
				int minFruitBasketIndexToDelete = Collections.min(map.values());
				newIndexAfterThrowing = map.remove(tree[minFruitBasketIndexToDelete]) + 1;
			}
			//System.out.println(map); // Below update need to be done each time. Putting this inside if will fail in many cases.
			maxFruit = Math.max(maxFruit, currentIndex - newIndexAfterThrowing + 1);
			currentIndex++;
		}
		return maxFruit;
	}

	public static void main(String[] args) {
		FruitIntoBaskets f = new FruitIntoBaskets();
		System.out.println(f.totalFruit(new int[] { 3, 3, 3, 1, 1, 2, 1, 1, 2, 3, 3, 4 }));
	}
}
