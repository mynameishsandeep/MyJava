package com.interview.leetcode.linkedin.medium;

import java.util.HashMap;
import java.util.Map;

public class InsertDeleteGetRandom1 {
	Map<Integer, Integer> valueMap;
	Map<Integer, Integer> indexMap;
	java.util.Random rand = new java.util.Random();

	public InsertDeleteGetRandom1() {
		valueMap = new HashMap<>();
		indexMap = new HashMap<>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if (valueMap.containsKey(val)) {
			return false;
		}
		int index = indexMap.size();
		valueMap.put(val, index);
		indexMap.put(index, val);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if (!valueMap.containsKey(val)) {
			return false;
		}
		int indexToDelete = valueMap.get(val);
		int size = indexMap.size() - 1;

		if (indexToDelete == size) {
			valueMap.remove(val);
			indexMap.remove(indexToDelete);
		} else {
			valueMap.put(indexMap.get(size), indexToDelete);
			valueMap.remove(val);
			
			indexMap.put(indexToDelete, indexMap.get(size));
			indexMap.remove(size);
		}
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		System.out.println(indexMap);
		return indexMap.get(rand.nextInt(indexMap.size()));
	}

	public static void main(String[] args) {
		InsertDeleteGetRandom1 i = new InsertDeleteGetRandom1();
		i.insert(1);
		i.remove(2);
		i.insert(2);
		System.out.println(i.getRandom());
		i.remove(1);
		i.insert(2);
		System.out.println(i.getRandom());
	}
}
