package Storage;

import java.util.HashMap;
import java.util.Map;

public abstract class Inventory<T> implements IInventory<T> {
	
	private Map<T,Integer> inventory;
	
	public Map<T, Integer> getInventory() {
		return inventory;
	}

	public void setInventory(Map<T, Integer> inventory) {
		this.inventory = inventory;
	}

	public Inventory() {
		inventory = new HashMap<T,Integer>();
	}

	@Override
	public void addElementToInventory(T item, int count) {
		if(inventory.containsKey(item)) {
			int previousCount = inventory.get(item);
			inventory.put(item, previousCount+count);
		}else {
			inventory.put(item,count);
		}
		
	}

	@Override
	public boolean removeElementFromInventory(T item, int count) {
		// check if item exists
		if(!inventory.containsKey(item)) {
			return false;
		}
		// check amount
		if(inventory.get(item)<count) {
			return false;
		}
		// reduce amount
		inventory.put(item, inventory.get(item)-count);
		return true;
	}
	
	public boolean checkKeyExists(T item) {
		return inventory.containsKey(item);
	}
	
	public int getValue(T item) {
		return inventory.get(item);
	}
	
}
