package arrays_and_strings;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] mat = { { 2, 4, 8 }, { 5, 6, 7 }, { 1, 5, 2 } };
		rotate(mat, 3);
	}

	private static void rotate(int[][] mat, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}
