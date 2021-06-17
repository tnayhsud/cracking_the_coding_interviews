package dp;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

// Count of ways to reach from top left of grid to bottom right with obstacles on path
public class RobotMoves {

	static int[][] dp;

	public static void main(String[] args) {
//		int[][] arr = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int[][] arr = { { 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		dp = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		Instant begin = Instant.now();
		System.out.println(RobotMoves.countWaysUsingBottomUpDP(arr.length - 1, arr.length - 1, arr));
		Instant end = Instant.now();
		System.out.println(Duration.between(begin, end).toMillis());
	}

//	Using recursion
	public static int countWays(int r, int c, int[][] arr) {
		if (r < 0 || c < 0) {
			return 0;
		}
		if (arr[r][c] == 1) {
			return 0;
		}
		if (r == 0 && c == 0) {
			return 1;
		}
		return countWays(r - 1, c, arr) + countWays(r, c - 1, arr);
	}

//	Using top down memoization
	public static int countWaysUsingTopDownMemoization(int r, int c, int[][] arr) {
		if (r < 0 || c < 0) {
			return 0;
		}
		if (arr[r][c] == 1) {
			return 0;
		}
		if (r == 0 && c == 0) {
			return 1;
		}
		if (dp[r][c] != -1) {
			return dp[r][c];
		}
		dp[r][c] = countWays(r - 1, c, arr) + countWays(r, c - 1, arr);
		return dp[r][c];
	}

//	Using bottom up dynamic programming
	public static int countWaysUsingBottomUpDP(int r, int c, int[][] arr) {

		int[][] memo = new int[r + 1][c + 1];
		for (int i = 0; i < r + 1; i++) {
			for (int j = 0; j < c + 1; j++) {
				if (arr[i][j] != 1) {
					if (i == 0 && j == 0) {
						memo[i][j] = 1;
					} else if (i == 0 && j != 0) {
						memo[i][j] = memo[i][j - 1];
					} else if (i != 0 && j == 0) {
						memo[i][j] = memo[i - 1][j];
					} else {
						memo[i][j] = memo[i][j - 1] + memo[i - 1][j];
					}
				} else {
					memo[i][j] = 0;
				}
			}
		}
		return memo[r][c];
	}

}