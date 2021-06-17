package recursion;

import general_util.Arrays;

public class ArraySortUsingRecursion {

	public static void main(String[] args) {
		int[] arr = { 5, 2, 9, 7, 6 };
		sort(arr, arr.length - 1);
		Arrays.print(arr);
	}

	public static void sort(int[] arr, int n) {
		if (n == 0) {
			return;
		}
		sort(arr, n - 1);
		push(arr, n);
	}

	private static void push(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			if (arr[i] > arr[n]) {
				int temp = arr[i];
				arr[i] = arr[n];
				arr[n] = temp;
			}
		}
	}

}
