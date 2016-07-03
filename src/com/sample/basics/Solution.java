package com.sample.basics;

import java.util.Scanner;

public class Solution {

private static final int  B;
private static final int  H;
private static boolean  flag;

static {
    Scanner scan = new Scanner(System.in);
    B = scan.nextInt();
    H = scan.nextInt();
if(B<0 || H<0)    {
    try {
		throw new Exception("Breadth and height must be positive");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getClass()+ ": " +e.getMessage());
	}
} else {
	flag = true;
}
}


public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class

