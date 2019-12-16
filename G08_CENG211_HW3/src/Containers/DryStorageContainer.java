package Containers;

import Product.*;
import Ingredient.IUncountable;

public class DryStorageContainer extends Container<Product>{
	
	//Our container should be stack
	public DryStorageContainer() {
		super();
	}
	@Override
	public void addItem(Product newItem)
			throws DifferentUncountableItemsException, InvalidItemTypePassedException {
		// TODO Auto-generated method stub
		// Check item type
		if (!(newItem instanceof BoxedMilk) || !(newItem instanceof Chocolate) || !(newItem instanceof Yogurt)) {
			throw new InvalidItemTypePassedException();
		}
		// Check if stack has another ingredient 
		if (!getItemStack().isEmpty()) {
			for(Product ing : getItemStack()) {
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
