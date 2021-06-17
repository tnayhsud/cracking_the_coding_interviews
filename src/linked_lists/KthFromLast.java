package linked_lists;

import linked_lists.LinkedList.Node;

public class KthFromLast {

	static int kth = 3;

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		int k = -1;
		list.addAll(new int[] { 6, 3, 9, 8, 3, 5 });
		if (kth > list.size || kth <= 0) {
			System.out.println("Index: " + k + " out of range");
			return;
		}
//		kthFromLastUsingRecursion(list.head, 4);
//		kthFromLastUsingIteration(list.head, 4, list.size);
//		System.out.println(kth);
		Index index = new KthFromLast.Index();
		Node temp = kthFromLastUsingClass(list.head, k, index);
		System.out.println(temp.data);
	}

	// Using iteration kth from last mean length-k+1 from start
	public static void kthFromLastUsingIteration(Node node, int k, int size) {
		int var = 0;
		Node curr = node;
		while (curr != null) {
			var++;
			if (var == size - k + 1) {
				kth = curr.data;
				break;
			}
			curr = curr.next;
		}
	}

	// Using recursion, when call stack returns, increment a counter and check
	// It is a valid solution only if we are not asked to `return` the node
	public static int kthFromLastUsingRecursion(Node node, int k) {
		if (node == null) {
			return 0;
		}
		int l = kthFromLastUsingRecursion(node.next, k);
		if (k == l + 1) {
			kth = node.data;
			return node.data;
		}
		return l + 1;
	}

	// Here, create a class to mimic pass by reference
	public static Node kthFromLastUsingClass(Node node, int k, Index i) {
		if (node == null) {
			return null;
		}
		Node temp = kthFromLastUsingClass(node.next, k, i);
		i.index = i.index + 1;
		if (k == i.index) {
			return node;
		}
		return temp;
	}

	static class Index {
		int index = 0;
	}

}
