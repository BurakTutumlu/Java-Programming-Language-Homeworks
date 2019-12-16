package Storage;

import java.util.LinkedList;
import java.util.Queue;

import Containers.DifferentUncountableItemsException;
import Ingredient.*;

public class StorageTank<T extends IUncountable> {
	public static final double MAX_CAPACITY = 10000.00;
	private double amount;
	private Queue<T> itemQueue;

	public StorageTank() {
		amount = 0.0;
		itemQueue = new LinkedList<T>();
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Queue<T> getItemQueue() {
		return itemQueue;
	}
	public void setItemQueue(Queue<T> itemQueue) {
		this.itemQueue = itemQueue;
	}
	
	public void addItem(T newItem) throws DifferentItemTypePassedException, NoSpaceInStorageTankException {
		// Check if queue has another item type 
		if (!itemQueue.isEmpty()) {
			for(T item : itemQueue) {
				if (!(item.getClass().equals(newItem.getClass()))) {
					throw new DifferentItemTypePassedException();
				}
			}
		}
		if (MAX_CAPACITY-amount < newItem.getAmount()) {
			throw new NoSpaceInStorageTankException();
		}
		itemQueue.add(newItem);
		amount+=newItem.getAmount();
	}
	
}
