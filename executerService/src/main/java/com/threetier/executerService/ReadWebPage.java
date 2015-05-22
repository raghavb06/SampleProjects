package com.threetier.executerService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ReadWebPage {

	public static void main(final String[] args) {

		if (args.length != 1) {
			System.err.println("Usage: java readWebPage url");
			return;
		}

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Callable<List<String>> pageTask = new Callable<List<String>>() {

			@Override
			public List<String> call() throws Exception {
				List<String> lines = new ArrayList<String>();

				URL url = new URL("http://kundansingh.com/interview/");

				HttpURLConnection connection = (HttpURLConnection) url.openConnection();

				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				String line = null;

				while ((line = bufferedReader.readLine()) != null) {
					lines.add(line);
				}
				return lines;
			}
		};

		Future<List<String>> future = executorService.submit(pageTask);

		try {
			List<String> lines = future.get(5, TimeUnit.SECONDS);

			for (String line : lines) {
				System.out.println(line);
			}
		} catch (ExecutionException ee) {

			System.err.println("Callable through exception: " + ee.getMessage());
		} catch (InterruptedException | TimeoutException exception) {
			System.err.println("URL not responding.");
		}
	}
}
