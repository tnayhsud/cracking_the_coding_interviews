//package unsolved;
//
//import trees_tries.Node;
//import trees_tries.Tree;
//
//public class CommonAnscestor {
//
//	public static void main(String[] args) {
//		CommonAnscestor commonAnscestor = new CommonAnscestor();
//		Tree tree = new Tree();
//		Node temp = tree.root = new Node(2);
//		temp.left = new Node(8);
//		temp.left.left = new Node(9);
//		temp.left.right = new Node(4);
//		temp.right = new Node(5);
//		temp.right.left = new Node(11);
//		temp.right.right = new Node(10);
//		temp.right.right.left = new Node(0);
//		temp.right.right.right = new Node(7);
//		Node lca = commonAnscestor.findCommonAnscestorUsingRecursion(tree.root, 5, 19);
//		System.out.println(lca != null ? lca.data : Integer.MIN_VALUE);
//	}
//
//	public Node findCommonAnscestorUsingRecursion(Node node, int m, int n) {
//		if (node == null) {
//			return null;
//		}
//		if (node.data == m || node.data == n) {
//			return node;
//		}
//		Node leftSearchResult = findCommonAnscestorUsingRecursion(node.left, m, n);
//		Node rightSearchResult = findCommonAnscestorUsingRecursion(node.right, m, n);
//		if (leftSearchResult == null) {
//			return rightSearchResult;
//		}
//		if (rightSearchResult == null) {
//			return leftSearchResult;
//		}
//		return node;
//	}
//
//}
