package trees_tries;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

	public static void main(String[] args) {
		BST bst = new BST();
		Tree tree = new Tree();
		int[] arr = new int[] { 2, 5, 7, 11, 12, 19, 22 };
		tree.root = bst.buildBST(arr, 0, arr.length - 1);
		bst.printLevelOrder(tree.root);
	}

	public Node buildBST(int[] arr, int begin, int end) {
		if (begin > end) {
			return null;
		}
		int mid = (end + begin) / 2;
		Node node = new Node(arr[mid]);
		node.left = buildBST(arr, begin, mid - 1);
		node.right = buildBST(arr, mid + 1, end);
		return node;
	}

	boolean isBST(Node root) {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <= max.
	 */
	boolean isBSTUtil(Node node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.data < min || node.data > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max constraints
		 * Allow only distinct values
		 */
		return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));
	}

	public void printLevelOrder(Node root) {
		// Base Case
		if (root == null)
			return;

		// Create an empty queue for level order traversal
		Queue<Node> q = new LinkedList<Node>();

		// Enqueue Root and initialize height
		q.add(root);

		while (true) {

			// nodeCount (queue size) indicates number of nodes
			// at current level.
			int nodeCount = q.size();
			if (nodeCount == 0)
				break;

			// Dequeue all nodes of current level and Enqueue all
			// nodes of next level
			while (nodeCount > 0) {
				Node node = q.peek();
				System.out.print(node.data + " ");
				q.remove();
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
				nodeCount--;
			}
			System.out.println();
		}
	}

}
