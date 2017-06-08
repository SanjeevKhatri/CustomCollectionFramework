package org.Sanjeev.Impl;

import org.Sanjeev.DefaultOperation;

public class CustomArrayList implements DefaultOperation {

	int size = 0;
	Integer[] myArray = new Integer[10];

	@Override
	public void add(int item) {
		// TODO Auto-generated method stub
		if (size > myArray.length - 1) {
			resize();
			myArray[size] = item;
			size++;
		} else {
			myArray[size] = item;
			size++;
		}
	}

	private void resize() {
		// TODO Auto-generated method stub
		Integer[] temp = myArray;
		myArray = new Integer[size * 2];
		System.arraycopy(temp, 0, myArray, 0, size);

	}

	@Override
	public void remove() {
		myArray[size - 1] = null;
		size--;
	}

	@Override
	public Integer get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		return myArray[index];
	}

	@Override
	public boolean isEmpty() {
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

}
