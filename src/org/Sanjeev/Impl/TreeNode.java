package org.Sanjeev.Impl;

public class TreeNode<V> {
	private V value;
	private TreeNode<V> left;
	private TreeNode<V> right;

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public TreeNode<V> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<V> left) {
		this.left = left;
	}

	public TreeNode<V> getRight() {
		return right;
	}

	public void setRight(TreeNode<V> right) {
		this.right = right;
	}
}
