package arrays_and_strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {

	public static void main(String[] args) {
		System.out.println(isUniqueUsingBitVector("abcs"));
		System.out.println(isUniqueUsingHashing("abcs"));
	}

	// Solution with additional space using a set of unique characters
	// Time complexity O(N)
	// Space complexity O(N) in worst case
	public static boolean isUniqueUsingHashing(String str) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// Checks if set already contains given character. If yes return false else add
			// to the set.
			if (set.contains(c)) {
				return false;
			}
			set.add(c);
		}
		return true;
	}

	// Solution without additional space using int 32 bits as flag
	// Assuming string contains of only lower case characters
	// Time complexity O(N)
	// Space complexity O(1)
	public static boolean isUniqueUsingBitVector(String str) {
		int vector = 0;
		for (int i = 0; i < str.length(); i++) {
			int j = str.charAt(i) - 'a';
			// if condition checks if bit at index j is set or not. If bit is set, means
			// already duplicate character in string
			if ((vector & (1 << j)) > 0) {
				return false;
			}
			// Setting the bit at index j if already not set, which means character appeared
			// first time
			vector |= 1 << j;
		}
		return true;
	}

}
