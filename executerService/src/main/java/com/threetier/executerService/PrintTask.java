package com.threetier.executerService;

public class PrintTask implements Runnable {

	private final String name;
	private final int delay;

	public PrintTask(String name, int delay) {
		super();
		this.name = name;
		this.delay = delay;
	}

	public void run() {

		System.out.println("Starting : " + name);
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
		}
		System.out.println("Done with : " + name);
	}

}
