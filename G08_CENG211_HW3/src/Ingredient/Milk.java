package Ingredient;

public class Milk extends Ingredient implements IUncountable {
	//just milk produce boxed milk 
	//milk produce chocolate
	//milk produce yogurt
	private static double priceOfMilk;
	
	public Milk() {
		super();
	}
	public Milk(double amount) {
		super(amount);
	}
	
	public Milk(double amount, double priceOfMilk) {
		super(amount);
		setPriceOfMilk(priceOfMilk);
	}
	
	public static double getPriceOfMilk() {
		return priceOfMilk;
	}
	
	public static void setPriceOfMilk(double newPriceOfMilk) {
		priceOfMilk = newPriceOfMilk;
	}
}
