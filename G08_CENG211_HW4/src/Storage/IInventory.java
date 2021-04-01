package Storage;

public interface IInventory<T> {
	
	public void addElementToInventory(T item, int count);
	
	public boolean removeElementFromInventory(T item, int count);
}
