package trees_tries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepths {

	public static void main(String[] args) {
		List<List<Node>> list = new ArrayList<>();
		ListOfDepths obj = new ListOfDepths();
		Tree tree = new Tree();
		Node temp = tree.root = new Node(2);
		temp.left = new Node(8);
		temp.left.left = new Node(9);
		temp.left.right = new Node(4);
		temp.right = new Node(5);
		temp.right.right = new Node(10);
		temp.right.right.left = new Node(0);
		temp.right.right.right = new Node(7);
		obj.listOfDepthsUsingRecursion(tree.root, list, 0);
		System.out.print("[ ");
//		for (List<Node> nodes : obj.listOfDepthsUsingLoops(tree.root)) {
		for (List<Node> nodes : list) {
			System.out.print(" { ");
			for (Node node : nodes) {
				System.out.print(node.data + " ");
			}
			System.out.print("} ");
		}
		System.out.println(" ]");
	}

	// Here we use recursion and pass level + 1 for the children
	// Time complexity O(N)
	// Space complexity O(N) + function call stack O(LOGN)
	public void listOfDepthsUsingRecursion(Node node, List<List<Node>> list, int level) {
		if (node == null)
			return;
		if (level >= list.size()) {
			List<Node> temp = new ArrayList<Node>();
			temp.add(node);
			list.add(temp);
		} else {
			List<Node> temp = list.get(level);
			temp.add(node);
		}
		listOfDepthsUsingRecursion(node.left, list, level + 1);
		listOfDepthsUsingRecursion(node.right, list, level + 1);
	}

	// Here we use a queue to add list of child nodes at each level and then poll
	// the list and iterate over polled list to add their children
	// Time complexity O(N)
	// Space complexity O(N)
	public List<List<Node>> listOfDepthsUsingLoops(Node node) {
		Node curr = node;
		List<List<Node>> list = new ArrayList<>();
		Queue<List<Node>> queue = new LinkedList<>();
		List<Node> l = new ArrayList<Node>();
		l.add(curr);
		list.add(l);
		queue.add(l);
		while (!queue.isEmpty()) {
			List<Node> tempList = new ArrayList<Node>();
			for (Node n : queue.poll()) {
				if (n.left != null)
					tempList.add(n.left);
				if (n.right != null)
					tempList.add(n.right);
			}
			if (tempList.size() != 0)
				list.add(tempList);
			if (tempList.size() != 0)
				queue.add(tempList);
		}
		return list;
	}

}
