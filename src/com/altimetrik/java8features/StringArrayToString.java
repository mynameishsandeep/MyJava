package com.altimetrik.java8features;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringArrayToString {
	public static void main(String[] args) {
		String fileLocation = "a/b/c/d";
		String splitUrl[] = fileLocation.split("/");
		splitUrl[splitUrl.length - 1] = "variant_" + splitUrl[splitUrl.length - 1];
		System.out.println(Stream.of(splitUrl).collect(Collectors.joining("/")));
	}
}
