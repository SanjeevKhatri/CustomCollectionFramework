package org.Sanjeev.Impl;

import java.util.Stack;

import org.Sanjeev.GenericBSTOperations;

public class CustomBST<T extends Comparable<T>> implements GenericBSTOperations<T> {

	private TreeNode<T> root;
	private int size = 0;

	public CustomBST() {
		root = new TreeNode<T>();
	}

	@Override
	public void add(T item) {
		TreeNode<T> temp = new TreeNode<T>();
		temp.setValue(item);
		// TODO Auto-generated method stub
		if (root.getValue() == null) {
			root = temp;
			size++;
		} else {
			recursiveAdd(root, temp);
		}
	}

	private void recursiveAdd(TreeNode<T> root, TreeNode<T> value) {
		// TODO Auto-generated method stub
		if (root.getValue().compareTo(value.getValue()) == 0) {
			return;
		} else if (root.getValue().compareTo(value.getValue()) > 0) {
			if (root.getLeft() == null) {
				root.setLeft(value);
				size++;
				return;
			}
			recursiveAdd(root.getLeft(), value);
		} else {
			if (root.getRight() == null) {
				root.setRight(value);
				size++;
				return;
			}
			recursiveAdd(root.getRight(), value);
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void remove(T item) {
		// TODO Auto-generated method stub
		if (root.getValue() == null) {
			throw new NullPointerException("List is Empty");
		} else {
			root = removeAndReconstruct(item, root);
			size--;
		}
	}

	private TreeNode<T> removeAndReconstruct(T key, TreeNode<T> root) {
		// TODO Auto-generated method stub
		if (root == null)
			return root;
		if (key.compareTo(root.getValue()) < 0)
			root.setLeft(removeAndReconstruct(key, root.getLeft()));
		else if (key.compareTo(root.getValue()) > 0)
			root.setRight(removeAndReconstruct(key, root.getRight()));
		else {
			if (root.getLeft() == null) {
				return root.getRight();
			} else if (root.getRight() == null) {
				return root.getLeft();
			} else {
				root.setValue(minValue(root.getRight()));
				root.setRight(removeAndReconstruct(root.getValue(), root.getRight()));
			}
		}
		return root;
	}

	private T minValue(TreeNode<T> root) {
		// TODO Auto-generated method stub
		T minv = root.getValue();
		while (root.getLeft() != null) {
			minv = root.getLeft().getValue();
			root = root.getLeft();
		}
		return minv;
	}

	@Override
	public void preOrderPrint() {
		System.out.print("\nPre Order Traversing: ");
		// TODO Auto-generated method stub
		if (root.getValue() == null) {
			System.out.println("Empty Tree");
		} else {
			recursivePreOrder(root);
		}
	}

	private void recursivePreOrder(TreeNode<T> root) {
		if (root != null) {
			System.out.print(root.getValue() + " ");
			recursivePostOrder(root.getLeft());
			recursivePostOrder(root.getRight());
		}
	}

	@Override
	public void inOrderPrint() {
		System.out.print("\nIn Order Traversing: ");
		// TODO Auto-generated method stub
		if (root.getValue() == null) {
			System.out.println("Empty Tree");
		} else {
			recursiveInOrder(root);
		}
	}

	private void recursiveInOrder(TreeNode<T> root) {
		if (root == null)
			return;
		Stack s = new Stack();
		TreeNode currentNode = root;
		while (!s.empty() || currentNode != null) {
			if (currentNode != null) {
				s.push(currentNode);
				currentNode = currentNode.getLeft();
			} else {
				TreeNode n = (TreeNode) s.pop();
				System.out.printf("%d ", n.getValue());
				currentNode = n.getRight();
			}
		}
	}

	@Override
	public void postOrderPrint() {
		System.out.print("\nPost Order Traversing: ");
		// TODO Auto-generated method stub
		if (root.getValue() == null) {
			System.out.println("Empty Tree");
		} else {
			recursivePostOrder(root);
		}
	}

	private void recursivePostOrder(TreeNode<T> root) {
		if (root != null) {
			recursivePostOrder(root.getLeft());
			recursivePostOrder(root.getRight());
			System.out.print(root.getValue() + " ");
		}
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		if (root.getValue() == null) {
			return 0;
		} else {
			return recursiveHeightCalc(root);
		}
	}

	private int recursiveHeightCalc(TreeNode<T> root) {
		if (root != null) {
			// TODO Auto-generated method stub
			int leftHeight = recursiveHeightCalc(root.getLeft());
			int reightHeight = recursiveHeightCalc(root.getRight());
			if (leftHeight > reightHeight) {
				return leftHeight + 1;
			} else {
				return reightHeight + 1;
			}
		}
		return 0;
	}

}
