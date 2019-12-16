package Containers;
import java.util.Stack;

import Ingredient.*;
import Product.ICountable;
public class OpenTopContainer extends Container<Ingredient> {

	//our openTopContainer is a stack
	public OpenTopContainer() {
		super();
	}
	
	@Override
	public void addItem(Ingredient newItem)
			throws DifferentUncountableItemsException, InvalidItemTypePassedException {
		// Check item type
		if (!(newItem instanceof Yeast) || !(newItem instanceof Cacao)) {
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

