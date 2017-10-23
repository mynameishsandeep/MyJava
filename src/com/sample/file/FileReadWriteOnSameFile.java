package com.sample.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileReadWriteOnSameFile {
	public static void main(String[] args) {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("out.txt"));
			BufferedReader fr = new BufferedReader(new FileReader("out.txt"));

			for (int i = 0; i < 10; i++) {
				fw.write("something " + i + "\n");
			}
			fw.close();

			String line = null;
			while ((line = fr.readLine()) != null) {
				System.out.println(line);
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
