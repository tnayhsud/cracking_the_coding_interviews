package arrays_and_strings;

import java.util.List;

public class PalindromePermutation {

	// Considering space as only allowed non-letter character
	private static boolean isPalindrome(String str) {
		int i = 0, j = str.length() - 1;
		while (i <= j) {
			char c1 = str.charAt(i);
			char c2 = str.charAt(j);
			if (c1 == ' ' || c2 == ' ') {
				if (c1 == ' ')
					i++;
				if (c2 == ' ')
					j--;
			} else if (c1 != c2) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}

	public static int countSetBits(int n) {
		int count = 0;
		while (n > 0) {
			n &= (n - 1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		String str = "Taco Coa";
		str = "never odd or even";
//		System.out.println(checkUsingBruteForce(str.toLowerCase()));
		System.out.println(checkUsingBitVector(str.toLowerCase()));
	}

	// Generate all the permutations and check if any one of them is palindrome
	// Time Complexity O(N*(N!)^2)
	// Space complexity O(N!)
	public static boolean checkUsingBruteForce(String s) {
		List<String> list = StringPermutation.permute(s);
		for (String str : list) {
			if (isPalindrome(str)) {
				return true;
			}
		}
		return false;
	}

	// Using bit vector to count set bits and return true if <=1
	// Time Complexity O(N)
	// Space Complexity O(1)
	public static boolean checkUsingBitVector(String s) {
		int checker = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 97 && c <= 122) {
				int bit = c - 'a';
				if ((checker & (1 << bit)) > 0) {
					checker &= ~(1 << bit);
				} else {
					checker |= (1 << bit);
				}
			}
		}
		// Alternate to directly check if only one bit is set 
		// n & (n-1) == 0
		if (countSetBits(checker) <= 1)
			return true;
		return false;
	}

}
