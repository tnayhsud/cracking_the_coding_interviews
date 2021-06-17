//package unsolved;
//
//import trees_tries.Node;
//import trees_tries.Tree;
//
//public class InOrderSuccessor {
//
//	Node successor;
//
//	public static void main(String[] args) {
//		InOrderSuccessor obj = new InOrderSuccessor();
//		Tree tree = new Tree();
//		Node temp = tree.root = new Node(12);
//		temp.left = new Node(7);
//		temp.left.parent = temp;
//		temp.left.left = new Node(5);
//		temp.left.left.parent = temp.left;
//		temp.left.left.left = new Node(2);
//		temp.left.left.left.parent = temp.left.left;
//		temp.left.left.right = new Node(6);
//		temp.left.left.right.parent = temp.left.left;
//		temp.left.right = new Node(9);
//		temp.left.right.parent = temp.left;
//		temp.left.right.left = new Node(8);
//		temp.left.right.left.parent = temp.left.right;
//		temp.left.right.right = new Node(10);
//		temp.left.right.right.parent = temp.left.right;
//		temp.right = new Node(14);
//		temp.right.parent = temp;
//		temp.right.left = new Node(13);
//		temp.right.left.parent = temp.right;
//		temp.right.right = new Node(15);
//		temp.right.right.parent = temp.right;
//		obj.successorUsingRecursion(tree.root, 10);
//		System.out.println(obj.successor != null ? obj.successor.data : Integer.MIN_VALUE);
//	}
//
//	public boolean successorUsingRecursion(Node node, int k) {
//		if (node == null) {
//			return false;
//		}
//		boolean lFlag = successorUsingRecursion(node.left, k);
//		if (lFlag) {
//			return true;
//		}
//		if (node.data == k) {
//			if (successor == null)
//				successor = node.right != null ? node.right : node.parent;
//			return true;
//		}
//		boolean rFlag = successorUsingRecursion(node.right, k);
//		if (rFlag) {
//			if (successor == null)
//				successor = node.parent;
//		}
//		return rFlag;
//	}
//
//}
