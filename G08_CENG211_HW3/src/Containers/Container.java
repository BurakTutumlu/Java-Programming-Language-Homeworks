package Containers;

import java.util.Stack;

import Ingredient.ItemNotUncountableException;
import Product.ItemNotCountableException;

public abstract class Container<T> {
	//We have initial capacity which is 1000
	//However, we can change its capacity if you want setMaxCapacity
	private double maxCapacity = 1000.00;
	private double amount;
	private Stack<T> itemStack;


	public Container() {
		amount=0.0;
		itemStack = new Stack<T>();
	}
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Stack<T> getItemStack() {
		return itemStack;
	}

	public void setItemStack(Stack<T> itemStack) {
		this.itemStack = itemStack;
	}
	
	/**
	 	* Add item to container
	 	* Firstly, type of newItem should be checked for
	 	* each container.If type of newItem is not compatible
	 	* with that container, InvalidItemTypePassedException
	 	* should be thrown.
	 	* If container is not empty, ContainerIsNotEmptyException
	 	* should be thrown.
	 	* @param newItem New Item to be added to container
	 	* @throws ContainerIsNotEmptyException
	 	* @throws DifferentUncountableItemsException
	 */
	public abstract void addItem(T newItem) throws DifferentUncountableItemsException,
		InvalidItemTypePassedException, ItemNotCountableException, ItemNotUncountableException;
	/**
	 	* Remove item from Container
	 	* @return item to be removed
	 */
	public T removeItem() {
		if (!itemStack.isEmpty()) {
			return itemStack.pop();
		}
		return null;
	}
	
	//get the private maxCapacity with this method
	public double getMaxCapacity() {
		return maxCapacity;
	}
	//set the private maxCapacity with this method
	public void setMaxCapacity(double maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
}
