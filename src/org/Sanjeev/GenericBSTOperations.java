package org.Sanjeev;

public interface GenericBSTOperations<T> {

	public void add(T item);

	public void remove(T item);

	public void preOrderPrint();

	public void inOrderPrint();

	public boolean isEmpty();

	public int size();

	void postOrderPrint();

	public int getHeight();
}
