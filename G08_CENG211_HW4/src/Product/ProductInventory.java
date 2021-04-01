package Product;

import java.util.Map;

import Storage.Inventory;

public class ProductInventory<T extends Product> extends Inventory<T> {

	
	public Product findProduct(String name) throws ProductNotFoundException{
		Map<T,Integer> inventory = this.getInventory();
		for (T key : inventory.keySet() ) {
		    if (key.getName().equals(name)) {
		    	return key;
		    }
		}
		throw new ProductNotFoundException();
	}
	
	public String toString() {
		String str = new String();
		Map<T,Integer> inventory = this.getInventory();
		for (T key : inventory.keySet() ) {
		    str+="## Product ##\n\t"+key.toString()+"\n\tAmount: "+inventory.get(key)+"\n";
		}
		return str;
		
	}
}
