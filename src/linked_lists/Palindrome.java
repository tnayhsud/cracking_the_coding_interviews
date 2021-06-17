package linked_lists;

import java.util.ArrayDeque;
import java.util.Queue;

import linked_lists.LinkedList.Node;

public class Palindrome {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addAll(new int[] { 4, 5, 7, 5, 9 });
//		System.out.println(isPalindromeUsingQueueAndRecursion(list));
		System.out.println(isPalindromeByReversingList(list.head));
	}

	public static boolean isPalindromeByReversingList(Node node) {
		LinkedList reverseCopy = new LinkedList();
		Node curr = node;
		while (curr != null) {
			Node temp = reverseCopy.head;
			reverseCopy.head = reverseCopy.new Node(curr.data);
			reverseCopy.head.next = temp;
			curr = curr.next;
		}
		Node rNode = reverseCopy.head;
		while (node != null && rNode != null) {
			if (node.data != rNode.data) {
				return false;
			}
			node = node.next;
			rNode = rNode.next;
		}
		return true;
	}

	public static boolean isPalindromeUsingQueueAndRecursion(LinkedList list) {
		Node curr = list.head;
		int size = list.size, pos = 0;
		Queue<Node> queue = new ArrayDeque<>();

		// Push half the elements to the queue from linked list
		while (pos < size / 2 && curr != null) {
			queue.add(curr);
			curr = curr.next;
			pos++;
		}
		return isPalindromeUsingQueueAndRecursion(list.head, queue);
	}

	// While returning from the stack, poll from queue and compare with current node
	// If at any point values don't match, return false
	public static boolean isPalindromeUsingQueueAndRecursion(Node node, Queue<Node> queue) {
		if (node == null) {
			return true;
		}
		boolean res = isPalindromeUsingQueueAndRecursion(node.next, queue);
		if (!res)
			return res;
		Node temp = queue.poll();
		if (temp != null && temp.data != node.data) {
			return false;
		}
		return true;
	}

}
