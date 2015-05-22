package com.threetier.synchronizers.semaphores;

public class Task implements Runnable {

	Pool pool;

	Task(Pool pool) {
		this.pool = pool;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		try {
			while (true) {
				String item;
				System.out.printf("%s acquiring %s%n", name, item = pool.getItem());
				Thread.sleep(200 + (int) (Math.random() * 100));
				System.out.printf("%s putting back %s%n", name, item);
				pool.putItem(item);
			}
		} catch (InterruptedException ie) {
			System.out.printf("%s interrupted%n", name);
		}
	}
}
