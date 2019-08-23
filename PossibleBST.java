package com.java.dp;

import java.util.ArrayList;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class PossibleBST {

	static ArrayList<Node> constructTrees(int start, int end) {
		ArrayList<Node> list = new ArrayList<>();

		if (start > end) {
			list.add(null);
			return list;
		}

		for (int i = start; i <= end; i++) {

			ArrayList<Node> leftSubtree = constructTrees(start, i - 1);

			ArrayList<Node> rightSubtree = constructTrees(i + 1, end);
			for (int j = 0; j < leftSubtree.size(); j++) {
				Node left = leftSubtree.get(j);
				for (int k = 0; k < rightSubtree.size(); k++) {
					Node right = rightSubtree.get(k);
					Node Node = new Node(i);
					Node.left = left;
					Node.right = right;
					list.add(Node);
				}
			}
		}
		return list;
	}

	static void preorder(Node root, ArrayList<Integer> arr) {
		if (root != null) {
			arr.add(root.data);
			preorder(root.left, arr);
			preorder(root.right, arr);
		}
	}

	public static void main(String args[]) {
		ArrayList<Node> totalTreesFrom1toN = constructTrees(1, 4);
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		for (int i = 0; i < totalTreesFrom1toN.size(); i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			preorder(totalTreesFrom1toN.get(i), arr);
			res.add(arr);
		}
		for(ArrayList<Integer> i : res)
			System.out.println(i);
	}

}
