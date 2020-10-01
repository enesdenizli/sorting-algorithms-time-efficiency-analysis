// Author: Enes Denizli
// This program performs calculations on most-known sorting algorithms and
// analyzes their time efficiencies depending on specific types and
// characteristics of inputs

package apackage;

import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {

	public static void main(String[] args) {

		// number will be changed depending on the array size
//		int[] arr = arrayCreater(10000000);

		int[] arr = {10,9,8,7,6,5,4,3,2,1};
		arrayDisplay(arr);
		mergeSort(arr, 0, arr.length-1);
		arrayDisplay(arr);
//		int[] arr = new int[3];
		
//		for(int x: arr) {
//			System.out.print(x + " ");
//		}

//		quickSort(arr, 4, arr.length - 1);
//		mergeSort(arr, -4, 10);
//		arrayDisplay(arr);

		// uncomment when you need sorted array
//		int[] arr = sortedArrayCreator(1000000);	

		// uncomment when you need almostsorted array
//		int[] arr = almostSortedArrayCreator(10);	 
//		insertionSort(arr);

//		// Function call timer starts
//		long startSelection = System.nanoTime();
//		selectionSort(arr);
//		// Function call timer stops
//		long endSelection = System.nanoTime() - startSelection;
//		System.out.println("Total time for selection sort: " +
//		endSelection + "ns");
//
//		// Function call timer starts
//		long startBubble = System.nanoTime();
//		bubbleSort(arr);
//		// Function call timer stops
//		long endBubble = System.nanoTime() - startBubble;
//		System.out.println("Total time for bubble sort: " +
//		endBubble + "ns");
//
//		// BSSC stands for bubble sort.
//		// Function call timer starts
//		long startBSSC = System.nanoTime();
//		bubbleSortSwapsCount(arr);
//		// Function call timer stops
//		long endBSSC = System.nanoTime() - startBSSC;
//		System.out.println("Total time for BSSC sort: " +
//		endBSSC + "ns");
//
//		// Function call timer starts
//		long startInsertion = System.nanoTime();
//		insertionSort(arr);
//		// Function call timer stops
//		long endInsertion = System.nanoTime() - startInsertion;
//		System.out.println("Total time for insertion sort: " +
//		endInsertion + "ns");

//		// Function call timer starts
//		long startQuick = System.nanoTime();
//		quickSort(arr, 0, arr.length - 1);
//		// Function call timer stops
//		long endQuick = System.nanoTime() - startQuick;
//		System.out.println("Total time for quick sort: " +
//		endQuick + "ns");

		// Function call timer starts
//		long startMerge = System.nanoTime();
//		mergeSort(arr, 0, arr.length - 1);
//		// Function call timer stops
//		long endMerge = System.nanoTime() - startMerge;
//		System.out.println("Total time for merge sort: " +
//		endMerge + "ns");

	}

	// This function creates random array of
	// integer objects between 0-"num" inclusive
	public static int[] arrayCreater(int number) {
		Random rd = new Random();

		int[] arr = new int[number];

		for (int i = 0; i < arr.length; i++) {

			// Functions' parameter is the range
			// of numbers
			arr[i] = rd.nextInt(10000);
		}
//		arrayDisplay(arr);
		return arr;
	}

	// This function creates sorted array but every tenth
	// element is a random number between 0-"num" inclusive
	public static int[] sortedArrayCreator(int num) {
		Random random = new Random();

		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = i + 1;
		}
		return arr;
	}

	// This function creates sorted array but every tenth
	// element is a random number between 0-314 inclusive
	public static int[] almostSortedArrayCreator(int num) {
		Random random = new Random();

		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = i + 1;
			if (arr[i] % 10 == 0) {
				arr[i] = random.nextInt(314);
			}
		}
		return arr;
	}

	// This function displays the array
	public static void arrayDisplay(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// Sorts array using selection sort algorithm
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min])
					min = j;
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}

	// Sorts array using bubble sort algorithm
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	// Sorts the array using bubble sort algorithm
	// and counts swaps
	public static void bubbleSortSwapsCount(int[] arr) {
		int swapCount = 0; // Swap counter
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapCount++; // If swap is made,
									// increment swap
				}
			}
		}
//		System.out.println("Swap count: " + swapCount);	
	}

	// Sorts the array using insertion sort algorithm
	public static void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int v = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > v) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = v;
		}
		arrayDisplay(arr);
	}

	// Author: Rajat Mishra
	// Cited from: https://www.geeksforgeeks.org/merge-sort/
	// Function has 3 parameters last two is the first and last
	// indexes and calls 'merge' function and itself recursively
	public static void mergeSort(int arr[], int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);
			merge(arr, left, middle, right);
		}
	}

	// Merges two temporarily made arrays into one array
	public static void merge(int arr[], int left, int middle, int right) {
		int leftArrLength = middle - left + 1;
		int rightArrLength = right - middle;

		int LeftArr[] = new int[leftArrLength];
		int RightArr[] = new int[rightArrLength];

		for (int i = 0; i < leftArrLength; ++i)
			LeftArr[i] = arr[left + i];
		for (int j = 0; j < rightArrLength; ++j)
			RightArr[j] = arr[middle + 1 + j];

		int i = 0;
		int j = 0;
		int k = left;
		while (i < leftArrLength && j < rightArrLength) {
			if (LeftArr[i] <= RightArr[j]) {
				arr[k] = LeftArr[i];
				i++;
			} else {
				arr[k] = RightArr[j];
				j++;
			}
			k++;
		}

		while (i < leftArrLength) {
			arr[k] = LeftArr[i];
			i++;
			k++;
		}

		while (j < rightArrLength) {
			arr[k] = RightArr[j];
			j++;
			k++;
		}
	}

//	// Function has 3 parameter where last two is array's first
//	// end last indexes and calls 'partitionHoare' function and
//	// itself recursively
//	// THIS CODE CAUSES STACKOVERFLOW, GO SEE THE TAB PINNED ON CHROME!!
//	public static void quickSort(int[] arr, int begin, int end) {
//		if (begin < end) {
//			// s is for pivot index
//			int s = partitionHoare(arr, begin, end);
//			quickSort(arr, begin, s);
//			quickSort(arr, s + 1, end);
//		}
//	}

	// Author: Matt Timmermans
	// Cited from: https://stackoverflow.com/a/33884601/11780836
	// Function has 3 parameter where last two is array's first
	// end last indexes and calls 'partitionHoare' function and
	// itself recursively
	public static void quickSort(int[] arr, int begin, int end) {
		while (begin < end) {
			int q = partitionHoare(arr, begin, end);
			if (q - begin <= end - (q + 1)) {
				quickSort(arr, begin, q);
				begin = q + 1;
			} else {
				quickSort(arr, q + 1, end);
				end = q;
			}
		}
	}

	// Hoare partition but slightly improved where one undo swap
	// is removed before the last swap
	public static int partitionHoare(int[] arr, int begin, int end) {
		int pivot = arr[begin];
		int i = begin - 1;
		int j = end + 1;

		while (true) {
			do {
				i++;
			} while (pivot > arr[i]);
			do {
				j--;
			} while (pivot < arr[j]);

			if (i >= j)
				return j;
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

}
