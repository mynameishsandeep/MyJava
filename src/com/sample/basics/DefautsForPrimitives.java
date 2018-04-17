package com.sample.basics;

public class DefautsForPrimitives {

	public static void main(String[] args) {
		DefautsForPrimitives d = new DefautsForPrimitives();
		d.booleanArray();
	}
	
	private void booleanArray() {
		boolean bo[] = new boolean[5];
		for(boolean b : bo ) {
			System.out.println(b);
		}
		
		boolean boo[][] = new boolean[2][3];
		for(boolean bb[] : boo) {
			for(boolean b : bb) {
				System.out.println(b);
			}
		}
	}
}
