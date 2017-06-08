# CustomCollectionFramework
# Test Driven Development (TDD)

# For ArrayList
public interface DefaultOperation {
	public void add(int item);
	public void remove();
	public Integer get(int index);
	public boolean isEmpty();
	public int size();
}

# For LinkedList
public interface GenericDefaultOperations<T> {
	public void add(T item);
	
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

# For BST
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
# For LinkedHashMap
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
# To be Continued..
