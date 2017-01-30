package com.home.codereview;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListOptional {
	public static void main(String[] args) {
	    Optional<List<String>> nullList = Optional.ofNullable(getNullList());
		System.out.println(nullList.isPresent());
		
	    Optional<List<String>> emptyList = Optional.ofNullable(getEmptyList());
		System.out.println(emptyList.isPresent());

	}
	
	public static List<String> getNullList() {
		return null;
	}
	
	public static List<String> getEmptyList() {
		return new ArrayList<String>();
	}

}
