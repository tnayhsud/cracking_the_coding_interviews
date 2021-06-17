package linked_lists;

import java.util.HashSet;
import java.util.Set;

import linked_lists.LinkedList.Node;

public class IntersectingLists {

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		Node head1 = list1.new Node(3);
		Node n1 = list1.new Node(1);
		Node n2 = list1.new Node(5);
		Node n3 = list1.new Node(9);
		Node n4 = list1.new Node(10);
		Node n5 = list1.new Node(2);
		Node n6 = list1.new Node(1);

		n5.next = n6;
		n4.next = n5;
		n3.next = n4;
		n2.next = n3;
		n1.next = n2;
		head1.next = n1;
		list1.head = head1;

		Node head2 = list2.new Node(4);
		Node m1 = list2.new Node(6);
		m1.next = n4;
		head2.next = m1;
		list2.head = head2;

//		Node intersectingNode = findIntersectionWithHashSet(head1, head2);
		Node intersectingNode = findIntersectionUsingPointers(head1, head2);
		if (intersectingNode == null) {
			System.out.println("Lists don't intersect");
			return;
		}
		System.out.println(intersectingNode.data);

	}

	// Use two pointer to iterate each list
	// Time complexity O(N^2)
	// Space compexity O(1)
	public static Node findIntersectionUsingPointers(Node head1, Node head2) {
		Node curr = head1;
		while (curr != null) {
			Node runner = head2;
			while (runner != null) {
				if (curr == runner) {
					return curr;
				}
				runner = runner.next;
			}
			curr = curr.next;
		}
		return null;
	}

	// Store first list to set and then iterate on second and check if current node
	// already present in the set
	// Time complexity O(N)
	// Space compexity O(N)
	public static Node findIntersectionWithHashSet(Node head1, Node head2) {
		Set<Node> set = new HashSet<>();
		Node curr = head1;
		while (curr != null) {
			set.add(curr);
			curr = curr.next;
		}
		curr = head2;
		while (curr != null) {
			if (set.contains(curr)) {
				return curr;
			}
			curr = curr.next;
		}
		return null;
	}

}
