package com.binarySeearchTree.gl;

//THIS CODE IS CONTRIBUTED BY YASH AGARWAL(YASHAGARWAL2852002)
//Java code to find a pair with given sum
//using hashing approach
import java.util.*;

public class BinarySearchTree {
	// node class structure
	static class Node {
		int data;
		Node left, right;
	};

	// utility function that returns the new node
	static Node NewNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	// inserting node at correct position in BST
	static Node insert(Node root, int key) {
		if (root == null)
			return NewNode(key);
		if (key < root.data)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		return root;
	}

	static boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {
		// base case
		if (root == null)
			return false;

		if (findpairUtil(root.left, sum, set))
			return true;

		if (set.contains(sum - root.data)) {
			System.out.println("Pair is found (" + (sum - root.data) + ", " + root.data + ")");
			return true;
		} else
			set.add(root.data);

		return findpairUtil(root.right, sum, set);
	}

	static void findPair(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findpairUtil(root, sum, set))
			System.out.print("nodes are not found \n");
	}

	// Driver code to test above function
	public static void main(String[] args) {
		Node root = null;
		root = insert(root, 15);
		root = insert(root, 10);
		root = insert(root, 20);
		root = insert(root, 8);
		root = insert(root, 12);
		root = insert(root, 16);
		root = insert(root, 25);
		root = insert(root, 10);

		int sum = 28;
		findPair(root, sum);
	}
}
