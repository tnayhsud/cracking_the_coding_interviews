package trees_tries;

class NodeUtil {
	int height;
	boolean balanced;
}

public class BalancedTree {

	boolean isBalanced = true;

	public static void main(String[] args) {
		BalancedTree bTree = new BalancedTree();
		Tree tree = new Tree();
		Node temp = tree.root = new Node(2);
		temp.left = new Node(8);
		temp.left.left = new Node(9);
		temp.left.right = new Node(4);
		temp.right = new Node(5);
		temp.right.left = new Node(11);
		temp.right.right = new Node(10);
		temp.right.right.left = new Node(0);
		temp.right.right.right = new Node(7);
//		System.out.println(bTree.checkBalancedTreeUsingRecursion(tree.root));
//		NodeUtil nodeUtil = bTree.checkBalancedTreeByReturningMultipleValues(tree.root);
		int res = bTree.checkBalancedTree(tree.root);
		System.out.println(res != Integer.MIN_VALUE ? true : false);

	}

	// Here we use same return type to check if tree is height balanced or not
	// Time complexity O(N)
	// Space Complexity O(LOGN)
	public int checkBalancedTree(Node node) {
		if (node == null) {
			return 0;
		}
		int lHeight = checkBalancedTree(node.left);
		if (lHeight == Integer.MIN_VALUE) {
			return lHeight;
		}
		int rHeight = checkBalancedTree(node.right);
		if (rHeight == Integer.MIN_VALUE) {
			return rHeight;
		}
		if (Math.abs(rHeight - lHeight) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(lHeight, rHeight) + 1;
		}
	}

	// Here we return multiple values to check if tree is height balanced or not
	// Time complexity O(N)
	// Space Complexity O(LOGN)
	public NodeUtil checkBalancedTreeByReturningMultipleValues(Node node) {
		if (node == null) {
			NodeUtil nodeUtil = new NodeUtil();
			nodeUtil.balanced = true;
			nodeUtil.height = 0;
			return nodeUtil;
		}
		NodeUtil lNodeUtil = checkBalancedTreeByReturningMultipleValues(node.left);
		NodeUtil rNodeUtil = checkBalancedTreeByReturningMultipleValues(node.right);
		NodeUtil nodeUtil = new NodeUtil();
		nodeUtil.height = Math.max(lNodeUtil.height, rNodeUtil.height) + 1;
		if (lNodeUtil.balanced == false || rNodeUtil.balanced == false
				|| Math.abs(lNodeUtil.height - rNodeUtil.height) > 1) {
			nodeUtil.balanced = false;
		} else {
			nodeUtil.balanced = true;
		}
		return nodeUtil;
	}

	public int getHeight(Node node) {
		if (node == null)
			return 0;
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}

	// Here we check getHeoght method to get height for left and right subtree and
	// check the balanced condition
	// Time complexity O(NLOGN)
	public boolean checkBalancedTreeUsingRecursion(Node node) {
		if (node == null)
			return true;
		int lHeight = getHeight(node.left);
		int rHeight = getHeight(node.right);
		if (Math.abs(lHeight - rHeight) > 1) {
			return false;
		} else
			return checkBalancedTreeUsingRecursion(node.left) && checkBalancedTreeUsingRecursion(node.right);
	}

}
