package com.threetier.dataStructure.sorting;

public class AdaptiveBubbleSort {

	public static void main(String[] args) {

		int[] arr = { 6, 1, 2, 3, 5, 4 };

		adaptiveBubbleSort(arr);

		printArray(arr);
	}

	private static void adaptiveBubbleSort(int[] arr) {
		boolean swapped = true;
		int j = 0;

		while (swapped) {
			swapped = false;
			j++;

			for (int i = 0; i < arr.length - j; i++) {
				int temp = 0;
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swapped = true;
				}
			}
		}
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
