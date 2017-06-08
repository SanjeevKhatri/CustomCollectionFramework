package org.Sanjeev;

public interface GenericMapOperations<V, K> {

	public void remove(K key);

	public int size();

	public boolean isEmpty();

	public V get(K key);

	public int hashValue(int hash);

	public boolean containsKey(K key);

	public boolean containsValue(V value);

	void put(K key, V value);
}
