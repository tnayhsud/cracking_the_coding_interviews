package dp;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

// A child can hop either 1, 2 or 3 steps. Count total ways to reach top
public class Nsteps {

	static int[] memo;

	public static void main(String[] args) {
		int n = 25;
		memo = new int[n + 1];
		Arrays.fill(memo, -1);
		Instant begin = Instant.now();
		System.out.println(Nsteps.countWaysUsingRecursion(n));
		Instant end = Instant.now();
		System.out.println(Duration.between(begin, end).toMillis());
	}

	public static int countWaysUsingRecursion(int n) {
//		Recursive approach
//		Time complexity O(3^N)
//		if (n < 0) {
//			return 0;
//		}
//		else if (n == 0) {
//			return 1;
//		}
//		return countWaysUsingRecursion(n - 1) + countWaysUsingRecursion(n - 2) + countWaysUsingRecursion(n - 3);

//		Top down memoization
//		Time complexity O(N)
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		}
		if (memo[n] != -1) {
			return memo[n];
		}
		memo[n] = countWaysUsingRecursion(n - 1) + countWaysUsingRecursion(n - 2) + countWaysUsingRecursion(n - 3);
		return memo[n];

	}

	// Using Bottom up dynamic programming
	// Time complexity O(N)
	// Space complexity O(N)
	public static int countWaysUsingBottomUpDP(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n];
	}

}
