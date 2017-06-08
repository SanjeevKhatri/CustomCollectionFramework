package org.Sanjeev.Impl;

public class MapNode<K, V> {

	private K key;
	private V value;
	/*private MapNode<K, V> next;

	public MapNode<K, V> getNext() {
		return next;
	}

	public void setNext(MapNode<K, V> next) {
		this.next = next;
	}*/

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
