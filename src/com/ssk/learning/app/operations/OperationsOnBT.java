package com.ssk.learning.app.operations;

import com.ssk.learning.app.data.Node;

public class OperationsOnBT {

	Node headNode = null;
	Node tempNode = null;

	//Converted BinarySearchTree to Skewed Tree
	public Node convertBSTToSkewedTree(Node root, int flag) {

		Node rightNode = null;
		Node leftNode = null;

		if(root == null) {
			return null;
		}

		if(flag > 0) {
			convertBSTToSkewedTree(root.getRight(), flag);
		}
		else{
			convertBSTToSkewedTree(root.getLeft(), flag);
		}

		rightNode = root.getRight();
		leftNode = root.getLeft();

		if( headNode == null) {
			headNode = root;
			root.setLeft(null);
			tempNode = root;
		}
		else {
			tempNode.setRight(root);
			root.setLeft(null);
			tempNode = root;
		}

		if(flag > 0) {
			convertBSTToSkewedTree(leftNode, flag);
		}
		else {
			convertBSTToSkewedTree(rightNode, flag);
		}
		return headNode;
	}

	//Tree traversal
	public void traverseRightSkewed(Node root) {
		if( root == null ) {
			return;
		}

		System.out.print(root.getData() + " ");
		traverseRightSkewed(root.getRight());
	}
}
