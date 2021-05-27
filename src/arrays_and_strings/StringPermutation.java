package arrays_and_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPermutation {

	public static void swap(char[] a, int i, int j) {
		char c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

	public static List<String> permute(String s) {
		List<String> list = new ArrayList<>();
		permute(s.toCharArray(), list, 0, s.length() - 1);
		return list;
	}

	public static void permute(char[] s, List<String> list, int l, int r) {
		if (l == r) {
			System.out.println(String.valueOf(s));
			list.add(String.valueOf(s));
		}
		for (int i = l; i <= r; i++) {
			swap(s, l, i);
			permute(s, list, l + 1, r);
			swap(s, l, i); // backtrack
		}
	}

	public static void main(String[] args) {
		System.out.println(checkPermutationUsingSorting("abc", "bca"));
		System.out.println(checkPermutationUsingHashing("abc", "sca"));
		System.out.println(checkPermutationUsingBruteForce("abc", "bca"));
	}

	// Checking permutations shear brute force by generating all possible
	// permutations
	// Time complexity O(N*N!)
	// Space complexity O(N!) because of N! string created
	public static boolean checkPermutationUsingBruteForce(String s1, String s2) {
		int l1 = s1.length(), l2 = s2.length();
		if (l1 != l2) {
			return false;
		}
		for (String s : permute(s1)) {
			if (s.equals(s2)) {
				return true;
			}
		}
		return false;
	}

	// Checking permutations using sorting
	// Time complexity O(NLogN)
	// Space complexity O(M+N)
	public static boolean checkPermutationUsingSorting(String s1, String s2) {
		int l1 = s1.length(), l2 = s2.length();
		if (l1 != l2) {
			return false;
		}
		char[] a1 = s1.toCharArray(), a2 = s2.toCharArray();
		Arrays.sort(a1);
		Arrays.sort(a2);
		// Iterating on sorted arrays and returning if values don't match at index i
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] != a2[i])
				return false;
		}
		return true;
	}

	// Checking permutations using hashing
	// Time complexity O(N)
	// Space complexity O(N)
	public static boolean checkPermutationUsingHashing(String s1, String s2) {
		int l1 = s1.length(), l2 = s2.length();
		if (l1 != l2) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<>();
		// Iterating on string and storing to map
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (map.containsKey(c)) {
				int j = map.get(c);
				map.put(c, j + 1);
			} else {
				map.put(c, 1);
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (!map.containsKey(c)) {
				return false;
			} else {
				int j = map.get(c);
				if (j == 1) {
					map.remove(c);
				} else
					map.put(c, j - 1);
			}
		}
		return map.size() == 0;
	}

	// Checking permutations using bit XOR
	// Time complexity O(N)
	public static boolean checkPermutationUsingXOR(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int checker = 0;
		for (int i = 0; i < s1.length(); i++) {
			checker ^= s1.charAt(i) ^ s2.charAt(i);
		}
		return checker == 0;
	}

}
