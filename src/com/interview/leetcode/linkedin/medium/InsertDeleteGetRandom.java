package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 * 
 * Note: The key point hashmap supports insert and delete at O(1). But to get random element, I need to have data structure that supports index.
 * Option1: I can use arrayList. But when a element is deleted from hashmap, it needs to be deleted from arrayList too. 
 * But if a  element im arraylist is anywhere other than end. Then shuffling needs to be done. To avoid that, we move the element from last index
 * to element to be deleted index and delete last index. Then map also has to updated with the new index.
 * Option 2: use another hashmap to store index. Refer(InsertDeleteGetRandom1.java)
 * 
 */
public class InsertDeleteGetRandom {
	Map<Integer, Integer> valueMap;
	List<Integer> value;
	java.util.Random rand = new java.util.Random();

	public InsertDeleteGetRandom() {
		valueMap = new HashMap<>();
		value = new ArrayList<>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if (valueMap.containsKey(val)) {
			return false;
		}
		valueMap.put(val, value.size());
		value.add(val);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if (!valueMap.containsKey(val)) {
			return false;
		}
		int index = valueMap.get(val);
		if (index == value.size() - 1) {
			valueMap.remove(val);
			value.remove(value.size() - 1);
		} else {
			int lastIndexValue = value.get(value.size() - 1);
			value.set(index, lastIndexValue);
			valueMap.put(lastIndexValue, index);
			valueMap.remove(val);
			value.remove(value.size() - 1);
		}
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return value.get(rand.nextInt(value.size()));
	}

	public static void main(String[] args) {
		InsertDeleteGetRandom i = new InsertDeleteGetRandom();
		i.insert(1);
		i.remove(2);
		i.insert(2);
		i.getRandom();
		i.remove(1);
		i.insert(2);
		i.getRandom();
	}
}
