package org.Sanjeev.Impl;

import java.util.List;

import org.Sanjeev.GenericDefaultOperations;

public class CustomLinkedList<T> implements GenericDefaultOperations<T> {

	private Node head;
	private int size = 0;

	public CustomLinkedList() {
		head = new Node();
	}

	@Override
	public void add(T item) {
		// TODO Auto-generated method stub
		Node temp = new Node();
		temp.setItem(item);

		if (head.getNext() == null) {
			temp.setPrev(head);
			head.setNext(temp);
		} else {
			Node nextNode = head.getNext();
			while (nextNode.getNext() != null) {
				nextNode = nextNode.getNext();
			}
			temp.setPrev(nextNode);
			nextNode.setNext(temp);
		}
		size++;
	}

	@Override
	public void addAll(CustomLinkedList<T> list) {
		Node newHead = new Node();

		for (int i = 0; i < list.size(); i++) {
			Node temp = new Node();
			temp.setItem(list.get(i));

			if (newHead.getNext() == null) {
				temp.setPrev(newHead);
				newHead.setNext(temp);
			} else {
				Node nextNode = newHead.getNext();
				while (nextNode.getNext() != null) {
					nextNode = nextNode.getNext();
				}
				temp.setPrev(nextNode);
				nextNode.setNext(temp);
			}
			size++;
		}

		Node nextNode = head.getNext();
		while (nextNode.getNext() != null) {
			nextNode = nextNode.getNext();
		}

		nextNode.setNext(newHead.getNext());
		newHead.getNext().setPrev(nextNode);

	}

	@Override
	public void clear() {
		if (head.getNext() == null) {
			throw new NullPointerException("List is Empty");
		} else {
			head.getNext().setPrev(null);
			head.setNext(null);
		}
	}

	@Override
	public boolean contains(T item) {
		Node nextNode = head;
		while (nextNode.getNext() != null) {
			if (nextNode.getNext().getItem().equals(item)) {
				return true;
			}
			nextNode = nextNode.getNext();
		}
		return false;
	}

	@Override
	public boolean containsAll(List<T> list) {

		boolean flag;
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			Node nextNode = head;
			flag = false;
			while (nextNode.getNext() != null) {
				if (nextNode.getNext().getItem().equals(list.get(i))) {
					flag = true;
					break;
				}
				nextNode = nextNode.getNext();
			}
			if (flag == false) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean equals(GenericDefaultOperations<Object> list) {
		// TODO Auto-generated method stub
		if (list.size() != this.size()) {
			return false;
		}
		Node nextNode = head;
		int i = 0;
		while (nextNode.getNext() != null) {
			if (!nextNode.getNext().getItem().equals(list.get(i))) {
				return false;
			}
			nextNode = nextNode.getNext();
			i++;
		}
		return true;
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
	public void remove() {
		// TODO Auto-generated method stub
		if (head.getNext() == null) {
			throw new NullPointerException("List is Empty");
		} else if (head.getNext().getNext() == null) {
			head.getNext().setPrev(null);
			head.setNext(null);
			size--;
		} else {
			Node nextNode = head.getNext().getNext();
			head.setNext(nextNode);
			nextNode.setPrev(head);
			size--;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		Node nextNode = head.getNext();
		if (index >= size || index < 0) {
			return null;
		}
		for (int i = 0; i < index; i++) {
			nextNode = nextNode.getNext();
		}
		return (T) nextNode.getItem();
	}
}
