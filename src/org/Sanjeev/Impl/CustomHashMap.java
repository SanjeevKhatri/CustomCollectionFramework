package org.Sanjeev.Impl;

import java.util.Iterator;
import java.util.LinkedList;

import org.Sanjeev.GenericMapOperations;

public class CustomHashMap<V, K> implements GenericMapOperations<V, K> {

	private int size = 0;
	private int tableSize;
	private LinkedList<MapNode<K, V>>[] elements;

	public CustomHashMap() {
		tableSize = 10;
		elements = new LinkedList[tableSize];
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		int hashIndex = hashValue(key.hashCode());
		if (elements[hashIndex] == null) {
			throw new NullPointerException("Key Not Found");
		} else {
			Iterator<MapNode<K, V>> it = elements[hashIndex].iterator();
			while (it.hasNext()) {
				if (it.next().getKey().equals(key)) {
					it.remove();
				}
			}
		}
		size--;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size > 0)
			return false;
		else
			return true;
	}

	@Override
	public V get(K key) {

		int hashIndex = hashValue(key.hashCode());
		if (elements[hashIndex] == null) {
			throw new NullPointerException("Key Not Found");
		} else {
			MapNode<K, V> temp;
			Iterator<MapNode<K, V>> it = elements[hashIndex].iterator();
			while (it.hasNext()) {
				temp = it.next();
				if (temp.getKey().equals(key)) {
					return temp.getValue();
				}
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashValue(int hash) {
		// TODO Auto-generated method stub
		return hash % tableSize;
	}

	@Override
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		int hashIndex = hashValue(key.hashCode());
		if (elements[hashIndex] == null) {
			return false;
		} else {
			MapNode<K, V> temp;
			Iterator<MapNode<K, V>> it = elements[hashIndex].iterator();
			while (it.hasNext()) {
				temp = it.next();
				if (temp.getKey().equals(key)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void put(K key, V value) {
		// TODO Auto-generated method stub
		MapNode<K, V> node = new MapNode<K, V>();
		node.setKey(key);
		node.setValue(value);
		int hashIndex = hashValue(key.hashCode());

		if (elements[hashIndex] == null) {
			elements[hashIndex] = new LinkedList<MapNode<K, V>>();
			elements[hashIndex].add(node);
		} else {
			elements[hashIndex].add(node);
		}
		size++;
	}

	@Override
	public boolean containsValue(V value) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= elements.length - 1; i++) {
			if (elements[i] == null) {
				continue;
			} else {
				MapNode<K, V> temp;
				Iterator<MapNode<K, V>> it = elements[i].iterator();
				while (it.hasNext()) {
					temp = it.next();
					if (temp.getValue().equals(value)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
