package linked_lists;

import linked_lists.LinkedList.Node;

public class SumList {

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.addAll(new int[] { 1, 0, 8, 3 });
		int len1 = l1.size;

		LinkedList l2 = new LinkedList();
		l2.addAll(new int[] { 9, 6, 5, 8 });
		int len2 = l2.size;

		// 7->1->6 + 5->9->2 = 2->1->9
		// sumBackward(l1.head, l2.head, len1, len2);

		// 6->1->7 + 2->9->5 = 9->1->2
		LinkedList res = sumForward(l1, l2, len1, len2);
		res.print();

	}

	public static LinkedList sumForward(LinkedList l1, LinkedList l2, int len1, int len2) {
		if (len1 < len2)
			stuffZeroes(l1, len2 - len1);
		else
			stuffZeroes(l2, len1 - len2);
		LinkedList res = new LinkedList();
		Node head1 = l1.head, head2 = l2.head;
		int carry = sumForward(head1, head2, res);
		if (carry != 0) {
			Node temp = res.new Node(carry);
			temp.next = res.head;
			res.head = temp;
		}
		return res;

	}

	public static int sumForward(Node head1, Node head2, LinkedList res) {
		if (head1 == null) {
			return 0;
		}
		int val = head1.data + head2.data + sumForward(head1.next, head2.next, res);
		int data = val % 10;
		Node temp = res.new Node(data);
		temp.next = res.head;
		res.head = temp;
		int carry = val / 10;
		return carry;

	}

	public static void stuffZeroes(LinkedList l, int i) {
		Node curr = l.head;
		while (curr.next != null) {
			curr = curr.next;
		}
		while (i > 0) {
			curr.next = l.new Node(0);
		}
	}

	public static void sumBackward(Node head1, Node head2, int len1, int len2) {
		LinkedList res = new LinkedList();
		int carry = 0;
		Node curr1 = head1, curr2 = head2;
		int val = curr1.data + curr2.data + carry;
		Node sum = res.new Node(val % 10);
		carry = val / 10;
		res.head = sum;
		Node temp = res.head;
		curr1 = curr1.next;
		curr2 = curr2.next;
		while (curr1 != null && curr2 != null) {
			val = curr1.data + curr2.data + carry;
			sum = res.new Node(val % 10);
			temp.next = sum;
			temp = temp.next;
			carry = val / 10;
			curr1 = curr1.next;
			curr2 = curr2.next;
		}

		while (curr1 != null) {
			val = curr1.data + carry;
			sum = res.new Node(val % 10);
			temp.next = sum;
			temp = temp.next;
			curr1 = curr1.next;
			carry = val / 10;
		}

		while (curr2 != null) {
			val = curr2.data + carry;
			sum = res.new Node(val % 10);
			temp.next = sum;
			temp = temp.next;
			curr2 = curr2.next;
			carry = val / 10;
		}

		res.print();
	}

}
