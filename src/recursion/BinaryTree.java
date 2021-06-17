package recursion;

class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

public class BinaryTree {

	Node root;

	BinaryTree(int key) {
		root = new Node(key);
	}

	BinaryTree() {
		root = null;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		System.out.println(height(tree.root));
	}

	public static int height(Node root) {
		// Base condition
		if (root == null) {
			return 0;
		}
		// Hypothesis
		int left = height(root.left), right = height(root.right);
		// Induction
		return Math.max(left, right) + 1;
	}

}
