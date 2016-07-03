package com.sample.generics;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("A");

		  // The following statement should fail since addAll expects
		  // Collection<? extends String>

		list.addAll(new ArrayList<>());
	}
}
