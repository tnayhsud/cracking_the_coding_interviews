package stacks_queues;

// Implementation of 3 stacks using single array
public class Stack {

	static int[] arr = new int[9];
	static int pointer1 = -1, pointer2 = arr.length, pointer3 = -1, pointer4 = -1;

	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.MIN_VALUE;
		}
		push(1, 1);
		push(2, 1);
		push(3, 1);
		push(8, 2);
		push(4, 3);
		push(5, 3);
		push(7, 2);
		push(6, 2);
		push(9, 1);
		push(10, 3);

		System.out.println("0-" + pointer1 + ", " + pointer3 + "-" + pointer4 + ", " + pointer2 + "-" + arr.length);
		System.out.print("[ ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("]");

		System.out.println(pop(2));

		System.out.println("0-" + pointer1 + ", " + pointer3 + "-" + pointer4 + ", " + pointer2 + "-" + arr.length);

		System.out.print("[ ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.print("]");
	}

	public static int pop(int stack) {
		switch (stack) {
		case 1:
			if (pointer1 < 0) {
				System.out.println("Empty stack 1");
				return Integer.MIN_VALUE;
			}
			int d = arr[pointer1];
			arr[pointer1] = Integer.MIN_VALUE;
			pointer1 = pointer1 - 1;
			return d;
		case 2:
			if (pointer2 > arr.length - 1) {
				System.out.println("Empty stack 2");
				return Integer.MIN_VALUE;
			}
			d = arr[pointer2];
			arr[pointer2] = Integer.MIN_VALUE;
			pointer2 = pointer2 + 1;
			return d;
		case 3:
			if (pointer4 < pointer3) {
				System.out.println("Empty stack 3");
				return Integer.MIN_VALUE;
			}
			d = arr[pointer4];
			arr[pointer4] = Integer.MIN_VALUE;
			pointer4 = pointer4 - 1;
			return d;
		}
		return Integer.MIN_VALUE;
	}

	public static void push(int data, int stack) {
		switch (stack) {
		case 1:
			pointer1++;
			if (pointer3 != -1) {
				if (pointer4 < pointer2 - 1) {
					shift(arr, pointer3, pointer4);
					arr[pointer1] = data;
				} else {
					System.out.println("Stack is full");
					return;
				}
			} else {
				if (pointer1 < pointer2) {
					arr[pointer1] = data;
				} else {
					System.out.println("Stack is full");
					return;
				}
			}
			break;
		case 2:
			pointer2--;
			if (arr[pointer2] != Integer.MIN_VALUE) {
				System.out.println("Stack is full");
				return;
			} else {
				arr[pointer2] = data;
			}
			break;
		case 3:
			if (pointer3 == -1) {
				pointer3 = pointer1 + 1;
				pointer4 = pointer3;
			} else {
				pointer4++;
			}
			if (pointer4 < pointer2 - 1) {
				arr[pointer4] = data;
			} else {
				System.out.println("Stack is full");
				return;
			}
		}
	}

	private static void shift(int[] arr, int pointer3, int pointer4) {
		for (int i = pointer4 + 1; i > pointer3 && i >= 0; i--) {
			arr[i] = arr[i - 1];
		}
	}

}
