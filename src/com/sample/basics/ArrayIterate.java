package com.sample.basics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ArrayIterate {

	public static void main(String[] args) throws IOException{
		
		String a[] = {"{]]{()}{])"};
		System.out.println(braces(a)[0]);
		
    }
	
	 public static String[] braces(String[] values) {
	        String open ="{[(";
	        String close = "}])";
	        String result[] = new String[values.length];
	        Stack<Character> stack = new Stack<>();
	        int count = 0;
	        for(String value : values) {
	            char c[] = value.toCharArray();
	            for(int i=0; i<c.length; i++) {
	                if(open.indexOf(c[i])!=-1) {
	                    stack.push(c[i]);
	                }
	                if(close.indexOf(c[i])!=-1) {
	                    char cc = stack.pop();
	                    if(cc != c[i]) {
	                    	stack.push(c[i]);
	                        break;
	                    }
	                }
	                
	            }
	            if(0==stack.size()) {
	                result[count++] = "YES";       
	            } else {
	                result[count++] = "NO";       
	            }
	        }
	        return result;
	    }

}
