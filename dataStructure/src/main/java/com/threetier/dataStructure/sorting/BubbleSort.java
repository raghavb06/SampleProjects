package com.threetier.dataStructure.sorting;

public class BubbleSort {

	public static void main(String[] args) {

		int[] numbers = { 65, 32, 43, 22, 54, 21, 12, 87, 54, 14 };

		int length = numbers.length;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j <= length -1; j++) {
				int temp = 0;
				if (numbers[i] > numbers[j]) {
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}

		for (int i = 0; i < length; i++) {
			System.out.print(numbers[i] + ", ");
		}

	}
}
