package general_util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Arrays {

	public static void print(int[] arr) {
		System.out.print("[ ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.print("]");
	}

	// Utility method to check if array if sorted or not
	public static boolean isSorted(int arr[], int n) {
		// Array has one or no element
		if (n == 0 || n == 1)
			return true;
		for (int i = 1; i < n; i++)
			// Unsorted pair found
			if (arr[i - 1] > arr[i])
				return false;
		// No unsorted pair found
		return true;
	}

	public static List<List<Integer>> weave(LinkedList<Integer> first, LinkedList<Integer> second) {
		LinkedList<Integer> prefix = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		weave(first, second, prefix, result);
		return result;
	}

	private static void weave(LinkedList<Integer> first, LinkedList<Integer> second, LinkedList<Integer> prefix,
			List<List<Integer>> result) {
		if (first.isEmpty() || second.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			temp.addAll(prefix);
			temp.addAll(first);
			temp.addAll(second);
			result.add(temp);
			return;
		}
		int x = first.removeFirst();
		prefix.addLast(x);
		weave(first, second, prefix, result);
		prefix.removeLast();
		first.addFirst(x);

		int y = second.removeFirst();
		prefix.add(y);
		weave(first, second, prefix, result);
		prefix.removeLast();
		second.addFirst(y);
	}

	public static void main(String[] args) throws ParseException {
		LinkedList<Integer> first = new LinkedList<Integer>();
		first.add(1);
		first.add(2);
		LinkedList<Integer> second = new LinkedList<Integer>();
		second.add(3);
		second.add(4);
		List<List<Integer>> result = Arrays.weave(first, second);
		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}

}
