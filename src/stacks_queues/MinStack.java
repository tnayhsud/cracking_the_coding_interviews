package stacks_queues;

import java.util.Stack;

public class MinStack {

	int min = Integer.MIN_VALUE;
	private Stack<Integer> stack = new Stack<>();
	@SuppressWarnings("unused")
	private Stack<Integer> minStack = new Stack<>();

//  Min stack push implementation using O(N) space i.e. using additional stack
//	public void push(int data) {
//		stack.push(data);
//		if (minStack.isEmpty() || minStack.peek() >= data) {
//			minStack.push(data);
//		}
//	}

//  Min stack push implementation using O(1) space i.e. int variable
	public void push(int data) {
		if (stack.isEmpty()) {
			stack.push(data);
			min = data;
		} else {
			if (data < min) {
				int flag = 2 * data - min;
				stack.push(flag);
				min = data;
			} else {
				stack.push(data);
			}
		}
	}

//  Min stack pop implementation using O(1) space i.e. int variable
	public int pop() throws Exception {
		if (stack.isEmpty()) {
			throw new Exception("Stack is empty");
		}
		if (stack.peek() < min) {
			int data = min;
			min = 2 * min - stack.pop();
			return data;
		} else {
			return stack.pop();
		}
	}
//  Min stack pop implementation using O(N) space i.e. using additional stack
//	public int pop() throws Exception {
//		if (stack.isEmpty()) {
//			throw new Exception("Stack is empty");
//		}
//		int data = stack.pop();
//		if (data == minStack.peek()) {
//			minStack.pop();
//		}
//		return data;
//	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) throws Exception {
		MinStack minStackImpl = new MinStack();
		minStackImpl.push(1);
		minStackImpl.push(-1);
		minStackImpl.push(3);
		minStackImpl.push(5);
		minStackImpl.push(10);
		minStackImpl.pop();
		minStackImpl.pop();
		minStackImpl.pop();
		System.out.println(minStackImpl.getMin());
	}

}
