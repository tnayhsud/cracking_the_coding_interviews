package stacks_queues;

import java.util.Stack;

public class MyQueue {

	java.util.Stack<Integer> stackNewest, stackOldest;

	public MyQueue() {
		stackNewest = new Stack<>();
		stackOldest = new Stack<>();
	}

	public int size() {
		return stackNewest.size() + stackOldest.size();
	}

	public void push(int data) {
		stackNewest.push(data);
	}

	public int pop() throws Exception {
		shiftStacks();
		return stackOldest.pop();
	}

	public int peek() throws Exception {
		shiftStacks();
		return stackOldest.peek();
	}

	private void shiftStacks() throws Exception {
		if (stackOldest.isEmpty()) {
			if (stackNewest.isEmpty()) {
				throw new Exception("Stack is empty");
			}
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}

}
