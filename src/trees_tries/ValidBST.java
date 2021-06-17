package trees_tries;

import general_util.Arrays;

public class ValidBST {

	int index = 0;
	Integer last = null;

	public static void main(String[] args) {
		ValidBST validBST = new ValidBST();
		Tree tree = new Tree();
		Node temp = tree.root = new Node(12);
		temp.left = new Node(7);
		temp.left.left = new Node(5);
		temp.left.left.left = new Node(2);
		temp.left.left.right = new Node(6);
		temp.left.right = new Node(9);
		temp.left.right.left = new Node(8);
		temp.left.right.right = new Node(10);
		temp.right = new Node(14);
		temp.right.left = new Node(13);
		temp.right.right = new Node(15);
//		temp.right.right.left = new Node(0);
//		temp.right.right.right = new Node(7);
		System.out.println(validBST.isValidBSTUsingConstantSpace(tree.root));
//		System.out.println(validBST.isValidBSTUsingRecursion(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	public boolean isValidBSTUsingConstantSpace(Node node) {
		if (node == null) {
			return true;
		}
		boolean lFlag = isValidBSTUsingConstantSpace(node.left);
		if ((last != null && node.data <= last) || !lFlag) {
			return false;
		}
		last = node.data;
		return isValidBSTUsingConstantSpace(node.right);
	}

	public boolean isValidBSTUsingArray(Node node) {
		int[] arr = new int[11];
		fillArray(node, arr);
		return Arrays.isSorted(arr, arr.length);
	}

	public void fillArray(Node node, int[] arr) {
		if (node == null) {
			return;
		}
		fillArray(node.left, arr);
		arr[index] = node.data;
		index++;
		fillArray(node.right, arr);
	}

	public boolean isValidBSTUsingRecursion(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data <= min || node.data > max) {
			return false;
		}
		boolean lFlag = isValidBSTUsingRecursion(node.left, min, node.data);
		boolean rFlag = isValidBSTUsingRecursion(node.right, node.data, max);
		return rFlag && lFlag;
	}

}
