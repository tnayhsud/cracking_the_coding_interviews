package dp;

public class GridPath {

	private static int[][] arr = { { 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 } };

	public static void main(String[] args) {
		ways();
	}

	public static void ways() {
		int dp[][] = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = 1;
				} else if (arr[i][j] == 1) {
					dp[i][j] = 0;
				} else {
					int x = i == 0 ? 0 : dp[i - 1][j];
					int y = j == 0 ? 0 : dp[i][j - 1];
					dp[i][j] = x + y;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(dp[arr.length - 1][arr[0].length - 1]);
	}

}
