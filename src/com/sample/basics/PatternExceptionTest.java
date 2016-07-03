package com.sample.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PatternExceptionTest {

public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int testCases = Integer.parseInt(in.nextLine());
			List<String> outputList = new ArrayList<>();
			for (Byte i = 0; i < testCases; i++) {
				String input = in.next();
				System.out.println(input);
				try {
					Pattern.compile(input);
					outputList.add("Valid");
				} catch (PatternSyntaxException e) {
					outputList.add("Invalid");
				}
			}
			outputList.stream().forEach(System.out::println);
		}

	}
	
	/*public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String pattern = in.nextLine();
            testCases--;
            try{
                Pattern.compile(pattern);
                System.out.println("Valid");
            }catch(PatternSyntaxException ex){
                System.out.println("Invalid");
            }
        }
    }*/
}
