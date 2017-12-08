package main;

public class Set {
	private int size = 0;
	private Object[] arr= new Object[3];
	public boolean isEmpty() {
		return size == 0;
	}
	public void add(Object item){
		if(size>=arr.length){
			resize();
		}
		if(contains(item)){
			return;
		}
		arr[size] = item;
		size++;
	}
	public int size() {
		return size;
	}
	public int indexOf(Object item){
		for(int i = 0; i < size; i++){
			if(arr[i].equals(item)){
				return i;
			}
		}
		return -1;
	}
	public boolean contains(Object string) {
		return indexOf(string) != -1;
	}
	
	public void remove(Object string) {
		if(indexOf(string)==-1){
			return;
		}
		arr[indexOf(string)] = arr[size];
		size--;
	}
	
	public void resize(){
		Object[] temp =  new Object[size*2];
		System.arraycopy(arr, 0, temp, 0, size);
		arr = temp;
		System.out.println(arr[size-1]);
	}
	

}
