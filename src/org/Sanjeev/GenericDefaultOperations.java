package org.Sanjeev;

import java.util.List;

import org.Sanjeev.Impl.CustomLinkedList;

public interface GenericDefaultOperations<T> {
	public void add(T item);

//	public void addAll(GenericDefaultOperations<T> list);
	
	public T get(int index);

	public void clear();

	public boolean contains(T item);

	public boolean isEmpty();

	public boolean containsAll(List<T> list);

	public boolean equals(GenericDefaultOperations<Object> list);

	public int size();

	public void remove();

	public void addAll(CustomLinkedList<T> list);
}
