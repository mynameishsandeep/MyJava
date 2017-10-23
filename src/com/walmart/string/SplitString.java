package com.walmart.string;

public class SplitString {

	public static void main(String[] args) {
		String input = "contentLanguage + targetCountry";
		String output[] = input.split("\\+");
		for(String print: output) {
			System.out.println(print.trim());
		}
		
		input = "https://s3.amazonaws.com/store-catalog-import.qa.lumcs.com/storeId/fileName";
		output = input.split("/");
		for(String print: output) {
			System.out.println(print.trim());
		}
		System.out.println(output[output.length-1]);

	}

}
