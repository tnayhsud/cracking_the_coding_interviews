package linked_lists;

import java.util.HashSet;
import java.util.Set;

import linked_lists.LinkedList.Node;

public class RemoveDuplicates {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
//		list.add(2);
//		list.add(3);
//		list.add(1);
//		list.add(5);
//		list.add(3);
//		list.add(5);
		list.addAll(new int[] { 2, 3, 1, 5, 3, 5 });
//		removeDuplicateUsingBuffer(list);
		removeDuplicateUsingTwoPointer(list);
		list.print();
	}

	// We can add new value to set and update prev pointer
	// Time complexity O(N)
	// Space complexity O(N)
	public static void removeDuplicateUsingBuffer(LinkedList list) {
		Node curr = list.head;
		Node prev = list.head;

		// Extra buffer
		Set<Integer> set = new HashSet<>();
		while (curr != null) {
			if (!set.contains(curr.data)) {
				set.add(curr.data);
				prev = curr;
			} else {
				prev.next = curr.next;
			}
			curr = curr.next;
		}
	}

	// Use two pointer, one to traverse list and other to check and remove
	// duplicates in the remaining list
	// Time complexity O(N^2)
	public static void removeDuplicateUsingTwoPointer(LinkedList list) {
		Node curr = list.head;
		while (curr != null) {
			Node runner = curr;
			while (runner.next != null) {
				if (curr.data == runner.next.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			curr = curr.next;
		}
	}

}
