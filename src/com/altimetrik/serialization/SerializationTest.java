package com.altimetrik.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTest {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setName("Reyan Ali");
		e.setAddress("Phokka Kuan, Ambehta Peer");
		e.setSSN(11122333);
		e.setNumber(101);
		try {
			FileOutputStream fileOut = new FileOutputStream(new File("c:\\tmp\\employee.ser"));
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in /tmp/employee.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
		
		deSerialize();
	}

	public static void deSerialize() {
		Employee e = null;
		try {
			FileInputStream fileIn = new FileInputStream("c:\\tmp\\employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e = (Employee) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Deserialized Employee...");
		System.out.println("Name: " + e.getName());
		System.out.println("Address: " + e.getAddress());
		System.out.println("SSN: " + e.getSSN());
		System.out.println("Number: " + e.getNumber());
		System.out.println("Number: " + e.getParent());
	}
}
