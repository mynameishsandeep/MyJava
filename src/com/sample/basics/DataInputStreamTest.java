package com.sample.basics;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class DataInputStreamTest {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("c:\\tmp\\data.data");
		DataOutputStream dout = new DataOutputStream(fos);
		int i =1000;
		dout.writeInt(i);
		dout.close();
		//fos.close();
		
		Scanner in = new Scanner(System.in);
		
		DataInputStream dinp = new DataInputStream(new FileInputStream("c:\\tmp\\data.data"));
		System.out.println(dinp.readInt());
		dinp.close();
		

	}

}
