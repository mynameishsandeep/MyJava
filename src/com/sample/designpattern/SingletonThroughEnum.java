package com.sample.designpattern;

public class SingletonThroughEnum {
	public static void main(String[] args) {
		DbConnection dC = MySingleton.INSTANCE.getConnection();
	}
}

enum MySingleton {

	INSTANCE;
	private final DbConnection connection;

	MySingleton() {
		// Initialize the connection. By passing UserName, Password, Pool
		// details etc...
		connection = DbConnection.getConnection();
	}

	public DbConnection getConnection() {
		return connection;
	}
}

class DbConnection {
	public static DbConnection getConnection() {
		return new DbConnection();
	}
}