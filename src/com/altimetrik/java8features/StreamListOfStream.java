package com.altimetrik.java8features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamListOfStream {

	public static void main(String[] args) {
		   List<String> list = new ArrayList<>();
		   list.add("1");
		   list.add("2");
		   list.add("3");
		   System.out.println(list.stream().collect(Collectors.joining(",")));
	}
}
