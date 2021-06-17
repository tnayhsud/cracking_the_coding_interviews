package trees_tries;

class Node {
	public Node(int data) {
		this.data = data;
	}

	int data;
	// Defined as per given in question 4.6 Trees and Graphs
	Node parent;
	Node left;
	Node right;
}

public class Tree {
	Node root;
}
