package com.sample.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringParsing {

		 public static void main(String[] args) {
		        Scanner scan = new Scanner(System.in);
		        String input = scan.next();
		        System.out.println(input.length());
		        int size = scan.nextInt();
		        List<String> comboList = constructCombo(input, size);
		        Collections.sort(comboList);
		        System.out.println(comboList.get(0));
		        System.out.println(comboList.get(comboList.size()-1));
		    }
		    
		    public static List<String> constructCombo(final String input, final int size) {
		        List<String> comboList = new ArrayList<>();
		        for(int i=0; i<input.length(); i++) {
		            if(i+size <= input.length()) {
		                comboList.add(input.substring(i, i+size));
		            } else {
		            	break;
		            }
		        }
		        return comboList;
		    }
}
