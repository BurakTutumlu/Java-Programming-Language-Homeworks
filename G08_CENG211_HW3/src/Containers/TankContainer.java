package Containers;
import java.util.Stack; 
import Product.ICountable;
import Ingredient.*;

public class TankContainer extends Container<Ingredient>{

	//our tank container is a stack.
	public TankContainer() {
		super();
	}
	@Override
	public void addItem(Ingredient newItem)
			throws DifferentUncountableItemsException, InvalidItemTypePassedException {
		// Check item type
		
		if (!(newItem instanceof Milk || newItem instanceof Cream)) {
			throw new InvalidItemTypePassedException();
		}
		// Check if stack has another ingredient 
		if (!getItemStack().isEmpty()) {
			for(Ingredient ing : getItemStack()) {
				if (!(ing.getClass().equals(newItem.getClass()))) {
					throw new DifferentUncountableItemsException();
				}
			}
		}
		// Add new item to stack
		getItemStack().push(newItem);
		setAmount(newItem.getAmount());
		
	}
	
}