import java.util.Arrays;

public class Bag<T> implements IBag<T> {

	private T[] itemList;
	private int itemCount;
	private static final int DEFAULT_SIZE=100;
	
	// Constructor(s)
	public Bag() {
		this.itemCount = 0;
		itemList = (T[]) new Object[DEFAULT_SIZE];
	}
	
	@SuppressWarnings("unchecked")
	public Bag(int size) {
		this.itemCount = 0;
		itemList = (T[]) new Object[size];
	}
	@Override
	public boolean add(T newItem) {
		if (isFull()) {
			doubleCapacity();
		}
		itemList[itemCount]=newItem;
		itemCount++;
		
		return true;
	}
	@Override
	public boolean update(int index, T newItem) {
		if (index < itemList.length) {
			itemList[index]=newItem;
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return itemCount==0;
	}

	@Override
	public boolean isFull() {
		return itemCount==itemList.length;
	}

	@Override
	public T removeByIndex(int index) {
		T result=null;
		if(!isEmpty() && index>=0) {
			result=itemList[index];
			itemList[index]=itemList[itemCount-1];
			itemList[itemCount-1]=null;
			itemCount--;
			return result;
		}

		return null;
	}

	@Override
	public Object remove(T item) {
		for (int i=0;i<itemCount;i++) {
			if (itemList[i].equals(item)) {
				T removedItem=this.removeByIndex(i);
				return removedItem;
			}
		}
		return null;
	}

	@Override
	public int getItemCount() {
		return itemCount;
	}

	@Override
	public int getIndexOf(T item) {
		int where=-1;
		boolean found=false;
		int index=0;
		while (!found && (index<itemCount)) {
			if (item.equals(itemList[index])) {
				found=true;
				where=index;
			}
			index++;
		}

		return where;
	}

	@Override
	public boolean contains(T item) {
		for (int i=0;i<itemCount;i++) {
			if(itemList[i].equals(item)){
				return true;
			}
		}
		return false;
	}

	@Override
	public void displayItems() {
		for(int i=0;i<this.itemCount;i++){
			if (itemList[i]!=null) {
				System.out.println("Item "+(i+1)+" -"+itemList[i].toString());
			}
		}
	}

	@Override
	public void dump() {
		for (int i=0;i<itemCount;i++) {
			itemList[i]=null;
		}
	}

	@Override
	public boolean transferTo(IBag<T> targetBag, T item) {
		if(!targetBag.isFull()) {
			targetBag.add(item);
			this.remove(item);
			return true;
		}
		return false;
	}

	@Override
	public T getItem(int index) {
		return itemList[index];
	}
	
	private void doubleCapacity() {
		int newLength = 2 * itemList.length;
		itemList = Arrays.copyOf(itemList, newLength);
	}

	@Override
	public int getSize() {
		return itemList.length;
	}

	
}
