package com.sample.basics;

import java.util.concurrent.CountDownLatch;

public class CountDownPlayerlatch {

	

	CountDownLatch cdl = new CountDownLatch(12);
	public static void main(String[] args) {
		for (int i=0 i<12; i++) {
			Thread cacheService = new Thread(new PlayerService("fName" + 1, 1000, latch));
		}
		
		// Initialize shceduler when 12 players are ready.
		// Initialize Deck Lock
		// Start the game.
	}
	

}

class PlayerService implements Runnable {
	private Integer amount;
	private String fName;
	private String lName;
	private final int timeToStart;
	private final CountDownLatch latch;

	public PlayerService(final String fName, final String lName, final Integer amount, final int timeToStart,
			final CountDownLatch latch) {
		this.fName = fName;
		this.lName = lName;
		this.amount = amount;
		this.timeToStart = timeToStart;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeToStart);
		} catch (InterruptedException ex) {
			
		}
		System.out.println(fName + " is Up");
		latch.countDown(); // reduce count of CountDownLatch by 1
	}

}
