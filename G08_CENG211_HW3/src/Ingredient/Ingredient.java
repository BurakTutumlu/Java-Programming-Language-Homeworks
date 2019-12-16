package Ingredient;

public abstract class Ingredient implements IUncountable {
	//we need to control how many elements, we have, now and after the producing.
	private double amount;
	
	public Ingredient() {
		this.amount = 0.0;
	}
	public Ingredient(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}	

