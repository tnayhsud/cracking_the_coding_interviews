package linked_lists;

public class LinkedList {
	Node head;
	int size;

	public Node add(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
		} else {
			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = node;
		}
		size++;
		return head;
	}

	public Node remove(int data) {
		Node node = new Node(data);
		if (this.head == null) {
			return null;
		} else {
			Node curr = this.head;
			Node prev = this.head;
			if (curr.data == data) {
				this.head = curr.next;
				curr = null;
				return this.head;
			}
			while (curr.next != null) {
				curr = curr.next;
				if (curr.data == data) {
					prev.next = curr.next;
					curr.next = null;
					curr = null;
					return this.head;
				} else {
					prev = curr;
				}
			}
			curr.next = node;
		}
		size--;
		return this.head;
	}

	public void print() {
		Node curr = this.head;
		System.out.print("[ ");
		while (curr.next != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.print(curr.data);
		System.out.print(" ]");
		System.out.println();
	}

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void addAll(int[] arr) {
		for (int i : arr) {
			add(i);
		}
	}

}
