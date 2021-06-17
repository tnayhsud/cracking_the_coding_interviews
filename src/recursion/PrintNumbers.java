package recursion;

public class PrintNumbers {

	public static void main(String[] args) {
		printDescending(10);
	}

	// 1 2 .... n-1 n
	public static void printAscending(int n) {
		// Base condition
		if (n == 0) {
			return;
		}
		// Hypothesis
		printAscending(n - 1);
		// Induction step
		System.out.print(n + " ");
	}

	// n n-1 n-2 ....... 1
	public static void printDescending(int n) {
		// Base condition
		if (n == 0) {
			return;
		}
		// Induction step
		System.out.print(n + " ");
		// Hypothesis
		printDescending(n - 1);
	}

}
