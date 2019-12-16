package Facilities;

import java.util.Stack; 

import Containers.*;
import Ingredient.*;
import Storage.*;
import Product.*;

public class DistributionCenter extends Facility {
	
	private StorageArea<BoxedMilk> boxedMilkStorageArea;
	private StorageArea<Chocolate> chocolateStorageArea;
	private StorageArea<Yogurt> yogurtStorageArea;
	
	/*
	public DistributionCenter() {
		boxedMilkStorageArea = new StorageArea<BoxedMilk>();
		chocolateStorageArea = new StorageArea<Chocolate>();
		yogurtStorageArea = new StorageArea<Yogurt>();
	}*/
	
	
	
	//container will be empty after this method.
	@Override
	public void dischargeContainer(Container<?> container) {
		// TODO Auto-generated method stub
		
	}
	

}
