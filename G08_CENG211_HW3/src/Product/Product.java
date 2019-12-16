package Product;

public abstract class Product implements ICountable {
	//we need to control how many elements, we have, now and after the producing.
	private double amount;
	
	public Product() {
		this.amount = 0.0;
	}
	
	public Product(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


}