package arrays_and_strings;

public class Rotate2D {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(arr);
	}

	// Time complexity O(N^2)
	// Space complexity O(1)
	// Take transpose and then swap i,j with i, n-1-j for every row
	public static void rotate(int[][] arr) {
		int n = arr.length;
		transpose(arr, n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][n - 1 - j];
				arr[i][n - 1 - j] = temp;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void transpose(int[][] arr, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}

}
