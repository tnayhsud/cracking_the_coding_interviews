package trees_tries;

import java.util.LinkedList;
import java.util.List;

import general_util.Arrays;

public class BSTSequences {

	public static void main(String[] args) {
		BSTSequences seq = new BSTSequences();
		Tree tree = new Tree();
		Node temp = tree.root = new Node(2);
		temp.left = new Node(1);
		temp.right = new Node(3);
		temp.right.right = new Node(4);
		List<List<Integer>> sequences = seq.countBSTSequences(temp);
		for (List<Integer> list : sequences) {
			System.out.println(list);
		}
	}

	public List<List<Integer>> countBSTSequences(Node node) {
		if (node == null) {
			List<List<Integer>> res = new LinkedList<>();
			return res;
		}
		List<List<Integer>> leftSubtreeResult = countBSTSequences(node.left);
		List<List<Integer>> rightSubtreeResult = countBSTSequences(node.right);
		List<List<Integer>> res = new LinkedList<>();
		if (leftSubtreeResult.size() == 0 || rightSubtreeResult.size() == 0) {
			if (leftSubtreeResult.size() != 0) {
				for (List<Integer> list : leftSubtreeResult) {
					LinkedList<Integer> var = new LinkedList<Integer>();
					var.addAll(list);
					List<List<Integer>> weaved = Arrays.weave(var, new LinkedList<Integer>());
					res.addAll(weaved);
				}
			}
			if (rightSubtreeResult.size() != 0) {
				for (List<Integer> list : rightSubtreeResult) {
					LinkedList<Integer> var = new LinkedList<Integer>();
					var.addAll(list);
					List<List<Integer>> weaved = Arrays.weave(new LinkedList<Integer>(), var);
					res.addAll(weaved);
				}
			}
		} else {
			for (List<Integer> list1 : leftSubtreeResult) {
				for (List<Integer> list2 : rightSubtreeResult) {
					LinkedList<Integer> var1 = new LinkedList<Integer>();
					var1.addAll(list1);
					LinkedList<Integer> var2 = new LinkedList<Integer>();
					var2.addAll(list2);
					List<List<Integer>> weaved = Arrays.weave(var1, var2);
					res.addAll(weaved);
				}
			}
		}
		if (res.size() == 0) {
			List<Integer> l = new LinkedList<>();
			l.add(node.data);
			res.add(l);
			return res;
		}
		for (List<Integer> list : res) {
			list.add(0, node.data);
		}
		return res;
	}

}
