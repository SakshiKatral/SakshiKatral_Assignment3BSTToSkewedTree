package com.ssk.learning.app.data;

import java.util.Scanner;
import com.ssk.learning.app.operations.OperationsOnBT;

public class BinarySearchTree {
	
	Node root;
	int flag;
	
	public BinarySearchTree() {
		root = null;
	}
	
	//Hard coded BinarySearchTree creation
	public void createTree(int flag) {
		BinarySearchTree tree = new BinarySearchTree();
		flag = this.flag;
		
		tree.root = new Node(50);
		
		tree.root.setLeft(new Node(30));
		tree.root.setRight(new Node(60));
		
		tree.root.getLeft().setLeft(new Node(10));
		tree.root.getLeft().setRight(new Node(55));
		
		operations(tree.root);
		
	}
	
	//Dynamic BinarySearchTree creation
	public void getValueFronUser(int flag){
		BinarySearchTree tree  = new BinarySearchTree();
		Scanner scanner = new Scanner(System.in);
		String string = "";
		System.out.println("\nDo you want to test with other input" + "\nIf yes press 'y' or press any key to exit");
		string = scanner.next();
		
		do {
			if(string.equalsIgnoreCase("y")) {
				System.out.println("Enter the number of nodes you want");
				int nodes = scanner.nextInt();
				System.out.println("Enter the node values");
				int[] data = new int[nodes];
				
				for(int i = 0; i < nodes; i++) {
					data[i] = scanner.nextInt();
					
					if( i >= 1) {
						for(int j = 0; j <= i; j++) {
							for(int k = j+1; k <= i; k++) {
								if(data[j] == data[k]) {
									System.out.println("This node is already present please enter other value");
									i--;
								}
								else {
									tree.insert(data[i]);
									continue;
								}
							}
						}
					}
					else {
						tree.insert(data[i]);
					}
				}
			}
			
			operations(tree.root);
			System.out.println("\nDo you want to continue if yes press 'y' else press any key to exit");
			string = scanner.next();
			
		}while(string.equalsIgnoreCase("y"));
		System.out.println("Exited successufully");
		
		if(scanner != null) {
			scanner.close();
		}
	}
	
	void insert(int key) {
		root = insertRecord(key, root);
	}
	
	Node insertRecord(int key, Node root) {
		if( root == null) {
			root = new Node(key);
			return root;
		}
		if(key < root.getData()) {
			root.setLeft(insertRecord(key, root.getLeft()));
		}
		else if(key > root.getData()) {
			root.setRight(insertRecord(key, root.getRight()));
		}
		
		return root;	
	}
	
	void operations(Node root){
		OperationsOnBT operationsOnBT = new OperationsOnBT();
		Node headNode = operationsOnBT.convertBSTToSkewedTree(root, flag);
		System.out.println("Right Skewed tree is");
		operationsOnBT.traverseRightSkewed(headNode);
	}
}
