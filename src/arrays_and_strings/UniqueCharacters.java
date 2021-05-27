package arrays_and_strings;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueCharacters {

	public static void main(String[] args) {
		System.out.println(isUniqueUsingBitVector("abcs"));
		System.out.println(isUniqueUsingHashing("abcs"));
	}

	// Brute force solution
	// Time complexity O(N^2)
	// Space complexity O(1)
	boolean isUniqueUsingBruteForce(String str) {
		// If at any time we encounter 2 same
		// characters, return false
		for (int i = 0; i < str.length(); i++)
			for (int j = i + 1; j < str.length(); j++)
				if (str.charAt(i) == str.charAt(j))
					return false;
		// If no duplicate characters encountered,
		// return true
		return true;
	}

	// Solution using sorting and comparing adjacent characters if same or different
	// Time complexity O(NlogN)
	// Space complexity O(1)
	boolean isUniqueUsingSorting(String str) {
		char[] array = str.toCharArray();
		// Sorting the char array take NlogN time
		Arrays.sort(array);
		for (int i = 0; i < array.length - 1; i++) {
			// If adjacent characters are equal, return false
			if (array[i] == array[i + 1]) {
				return false;
			}
		}
		return true;
	}

	// Using java streams
	boolean uniqueCharacters(String str) {
		// If at any character more than once create another stream
		// stream count more than 0, return false
		return str.chars().filter(e -> Collections.frequency(str.chars().boxed().collect(Collectors.toList()), e) > 1)
				.count() > 1 ? false : true;
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
		Instant begin = Instant.now();
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
		System.out.println("UniqueUsingBitVector took: " + Duration.between(Instant.now(), begin).toMillis() + " ms");
		return true;
	}

}
