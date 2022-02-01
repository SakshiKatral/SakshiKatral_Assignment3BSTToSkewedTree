package com.ssk.learning.app.main;

import com.ssk.learning.app.data.BinarySearchTree;

public class BSTToSkewedTree {


	
	public static void main(String[] args) {
		BinarySearchTree  binarySearchTree = new BinarySearchTree();
		
		// For Ascending order flag 0
		// For Descending order flag 1
		int flag = 1;
		binarySearchTree.createTree(flag);
		binarySearchTree.getValueFronUser(flag);
		
	}
}
