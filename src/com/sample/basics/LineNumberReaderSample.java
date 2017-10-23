package com.sample.basics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderSample {

	public static void main(String[] args) {
		readFromFile("resources/sampleFile.properties");
	}

	private static void readFromFile(String filename) {
		LineNumberReader lineNumberReader = null;
		try {
			// Construct the LineNumberReader object
			lineNumberReader = new LineNumberReader(new FileReader(filename));

			// Print initial line number
			System.out.println("Line " + lineNumberReader.getLineNumber());

			// Setting initial line number
			lineNumberReader.setLineNumber(5);

			// Get current line number
			System.out.println("Line " + lineNumberReader.getLineNumber());

			System.out.println(lineNumberReader.readLine());
			lineNumberReader.setLineNumber(7);
			System.out.println(lineNumberReader.readLine());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// Close the LineNumberReader
			try {
				if (lineNumberReader != null) {
					lineNumberReader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
