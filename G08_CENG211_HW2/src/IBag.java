
public interface IBag<T> {
	
	/**
	 * Add an object to bag
	 * @param: object to be added
	 * @return: if item added it return true
	 */
	public boolean add(T newItem);
	
	/**
	 * Update an object in an exact index
	 * @param: object to be added
	 * @return: if item added it return true
	 */
	public boolean update(int index,T newItem);
	
	/**
	 * Checks if bag is empty
	 * @param:none
	 * @return: true if bag is empty
	 */
	public boolean isEmpty();
	
	/**
	 * Check if bag is full 
	 * @param:none
	 * @return: true if bag is full
	 */
	public boolean isFull();
	
	/**
	 * Remove an object from bag by index 
	 * @param:index 
	 * @return: if Picnic bag is empty and index is 
	 * non-negative number  return result
	 */
	public T removeByIndex(int index);
	
	/**
	 *  Remove a specific item from bag
	 *  @param:Item
	 *  @return: if item in Picnic bag, return removed object
	 */
	public Object remove(T item);
	
	/** 
	 * Count the item in Picnic Bag
	 * @param:none
	 * @return:Number Of Items in Picnic Bag
	 */
	public int getItemCount();
	
	/**
	 * Find an item's index
	 * @param: Item
	 * @return: Index
	 */
	public int getIndexOf(T item);
	
	/** Check the item if it is in  Bag
	 * @param: Item
	 * @return: If the item in the Bag return true
	 */
	public boolean contains(T item);
	
	/**
	 * Display items in bag
	 * @param:none
	 * @return:none
	 */
	public void displayItems();
	
	/**
	 * Remove all items from bag
	 * @param:none
	 * @return:none
	 */
	public void dump(); 
	
	/**
	 * Transfer an item to target bag
	 * @param: Target bag 
	 * @param: Item
	 * @return: If target bag is not full, return true
	 */
	public boolean transferTo(IBag<T> targetBag, T item);
	
	/**
	 * Return an item with respect to given index
	 * @param: Index
	 * @return: Item
	 */
	public T getItem(int index);
	/**
	 * Return size of bag
	 * @param: none
	 * @return: Size of Bag
	 */
	public int getSize();
	

}