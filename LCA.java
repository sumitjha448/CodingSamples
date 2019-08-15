package com.java.trees;

import java.util.ArrayList;
import java.util.List;

public class LCA {
	public static boolean first = false;
	public static boolean second = false;

	public static boolean findPath(Tree root, int num, List<Integer> path) {
		if (root == null)
			return false;
		path.add(root.data);
		if (root.data == num) {
			return true;
		}
		if (findPath(root.left, num, path))
			return true;
		if (findPath(root.right, num, path))
			return true;
		path.remove(path.size() - 1);
		return false;
	}

	public static Tree findLca(Tree root, int num1, int num2) {
		if (root == null)
			return null;
		Tree leftFound = findLca(root.left, num1, num2);
		Tree rightFound = findLca(root.right, num1, num2);
		if(root.data == num1) {
			first = true;
		}
		if(root.data == num2) {
			second = true;
		}
		if(root.data  == num1 || root.data == num2)
			return root;
		if (leftFound != null && rightFound != null) {
			return root;
		}
		return (leftFound != null) ? leftFound : rightFound;
	}

	public static void main(String[] args) {
		List<Integer> path1 = new ArrayList<>();
		List<Integer> path2 = new ArrayList<>();
		Tree.root = null;
		Tree n1 = new Tree(3);
		n1.left = new Tree(5);
		n1.left.left = new Tree(6);
		n1.left.right = new Tree(2);
		n1.left.right.left = new Tree(7);
		n1.left.right.right = new Tree(4);
		n1.right = new Tree(1);
		n1.right.left = new Tree(0);
		n1.right.right = new Tree(8);
		Tree.root = n1;
//		findPath(Tree.root, 5, path1);
//		findPath(Tree.root, 4, path2);
//		if (path1.size() == 0 || path2.size() == 0) {
//			System.out.println("LCA not possible");
//		} else {
//			int i = 0;
//			int j = 0;
//			while (i < path1.size() && j < path2.size()) {
//				if (path1.get(i) != path2.get(j))
//					break;
//				i++;
//				j++;
//			}
//			System.out.println("LCA is : " + path1.get(i - 1));
//		}
		first = false;
		second = false;
		Tree res = findLca(Tree.root, 5, 7);
		if (first && second) {
			 if(res != null) {
				 System.out.println(res.data);
			 } else
				 System.out.println("LCA Not possible");
		} else
			System.out.println("LCA not possible");
	}

}
