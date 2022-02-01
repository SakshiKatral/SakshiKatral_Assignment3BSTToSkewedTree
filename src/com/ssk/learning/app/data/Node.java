package com.ssk.learning.app.data;

public class Node {

	 int data;
	 private Node left, right;
		
	 public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node(int data) {
		this.data = data;
		setLeft(null);
		setRight(null); 
	}

}
