package stacks_queues;

import java.util.Stack;

public class StackOfPlates {

	int threshold = 3;
	java.util.LinkedList<Stack<Integer>> list = new java.util.LinkedList<>();

	public static void main(String[] args) throws Exception {
		StackOfPlates sop = new StackOfPlates();
		sop.push(4);
		sop.push(5);
		sop.push(1);
		sop.push(3);
		sop.push(9);
		sop.push(0);
		sop.push(-1);
		sop.push(8);
		sop.push(6);
		sop.pop();
		sop.pop();
		sop.print();
	}

	public void print() {
		System.out.print("[ ");
		for (Stack<Integer> stack : list) {
			System.out.print("{ ");
			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.print("}");
		}
		System.out.print("]");
	}

	public void push(int data) {
		if (list.size() == 0) {
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(data);
			list.addFirst(stack);
		} else {
			Stack<Integer> head = list.getFirst();
			if (head.size() == threshold) {
				Stack<Integer> stack = new Stack<Integer>();
				stack.push(data);
				list.addFirst(stack);
			} else {
				head.push(data);
			}
		}
	}

	public int pop() throws Exception {
		if (list.size() == 0) {
			throw new Exception("Stack is empty");
		}
		Stack<Integer> stack = list.getFirst();
		int data = stack.pop();
		if (stack.size() == 0) {
			list.removeFirst();
		}
		return data;
	}

}
