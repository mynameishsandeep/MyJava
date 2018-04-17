package com.sample.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListContains {

	public static void main(String[] args) {
		List<List<String>> current = new ArrayList<>();
		List<String> c1 = new ArrayList<>();
		c1.add("Red");
		c1.add("8");
		c1.add("v1");
		current.add(c1);
		
		c1 = new ArrayList<>();
		c1.add("Red");
		c1.add("9");
		c1.add("v1");
		current.add(c1);

		List<List<String>> existing = new ArrayList<>();
		List<String> e1 = new ArrayList<>();
		e1.add("Red");
		e1.add("8");
		existing.add(e1);

		for (ListIterator<List<String>> iterator = current.listIterator(); iterator.hasNext();) {
			List<String> cItem = iterator.next();
			Boolean delete = true;
			existing: for (List<String> eItem : existing) {
				for (String item : eItem) {
					if (!cItem.contains(item)) {
						delete = false;
						break existing;
					}
				}

			}
			if (delete) {
				iterator.remove();
			}

		}
		for (List<String> cItem : current) {
			System.out.println(cItem);
		}

	}
}
