package Facilities;

import java.util.Stack;

import Containers.*;
import Ingredient.*;
import Storage.*;

public class Warehouse extends Facility{
	private StorageTank<Milk> milkStorageTank;
	private StorageTank<Cream> creamStorageTank;
	private StorageTank<Cacao> cacaoStorageTank;
	private StorageTank<Yeast> yeastStorageTank;
	
	
	public Warehouse() {
		milkStorageTank = new StorageTank<Milk>();
		creamStorageTank = new StorageTank<Cream>();
		cacaoStorageTank = new StorageTank<Cacao>();
		yeastStorageTank = new StorageTank<Yeast>();

	}
	public StorageTank<Milk> getMilkStorageTank() {
		return milkStorageTank;
	}

	public void setMilkStorageTank(StorageTank<Milk> milkStorageTank) {
		this.milkStorageTank = milkStorageTank;
	}

	public StorageTank<Cream> getCreamStorageTank() {
		return creamStorageTank;
	}

	public void setCreamStorageTank(StorageTank<Cream> creamStorageTank) {
		this.creamStorageTank = creamStorageTank;
	}

	public StorageTank<Cacao> getCacaoStorageTank() {
		return cacaoStorageTank;
	}

	public void setCacaoStorageTank(StorageTank<Cacao> cacaoStorageTank) {
		this.cacaoStorageTank = cacaoStorageTank;
	}

	public StorageTank<Yeast> getYeastStorageTank() {
		return yeastStorageTank;
	}

	public void setYeastStorageTank(StorageTank<Yeast> yeastStorageTank) {
		this.yeastStorageTank = yeastStorageTank;
	}

	@Override
	public void dischargeContainer(Container<?> container) {
		Object item = container.removeItem();
		while (item != null) {
			
			
			
			
			item = container.removeItem();
		}
		

	}

}
