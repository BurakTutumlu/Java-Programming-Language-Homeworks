package Ingredient;

public class Cream extends Ingredient implements IUncountable {
	//cream produce chocolate
	private static double priceOfCream;
	
	public Cream() {
		super();
	}
	
	public Cream(double amount) {
		super(amount);
	}
	
	public Cream(double amount, double priceOfCream) {
		super(amount);
		setPriceOfCream(priceOfCream);
	}
	
	public static double getPriceOfCream() {
		return priceOfCream;
	}
	
	public static void setPriceOfCream(double newPriceOfCream) {
		priceOfCream = newPriceOfCream;
	}
	
	
}
