package Ingredient;

public class Yeast extends Ingredient implements IUncountable {
	//yeast produce yogurt
	private static double priceOfYeast;
	
	public Yeast() {
		super();
	}
	
	public Yeast(double amount) {
		super(amount);
	}
	
	public Yeast(double amount, double priceOfYeast) {
		super(amount);
		setPriceOfYeast(priceOfYeast);
	}
	
	public static double getPriceOfYeast() {
		return priceOfYeast;
	}
	
	public static void setPriceOfYeast(double newPriceOfYeast) {
		priceOfYeast = newPriceOfYeast;
	}
}
