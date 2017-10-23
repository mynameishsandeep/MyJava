package com.sample.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteSample {
	public static void main(String[] args) throws IOException {
		BufferedWriter fw = new BufferedWriter(new FileWriter("out.txt"));

		for (int i = 0; i < 10; i++) {
			fw.write("something1\n");
		}

		fw.close();
	}
}
