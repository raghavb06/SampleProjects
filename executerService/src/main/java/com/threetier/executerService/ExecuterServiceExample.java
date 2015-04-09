package com.threetier.executerService;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecuterServiceExample {

	public static void main(String[] args) {

		Random random = new Random();

		// create an executer of thred pool size 3
		ExecutorService executor = Executors.newFixedThreadPool(3);

		// setup wait time to know when to shutdown
		int waitTime = 600;

		for (int i = 0; i < 10; i++) {
			String printer = "Printer Name " + i;
			int time = random.nextInt(500);
			waitTime += time;

			Runnable runner = new PrintTask(printer, time);
			System.out.println("Adding: " + printer + "/" + time);
			executor.execute(runner);
		}
		try {
			Thread.sleep(waitTime);
			executor.shutdown();
			executor.awaitTermination(waitTime, TimeUnit.MILLISECONDS);
		} catch (InterruptedException ignored) {
		}
		System.exit(0);
	}

}
