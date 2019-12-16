package Product;

public class Chocolate extends Product implements ICountable {
	//chocolate produced by milk, cream, cacao
	//private static final double AMOUNT = 0.5;
	private static double priceOfChocolate;
	
	public Chocolate() {
		super();
	}
	public Chocolate(double amount) {
		super(amount);
	}
	public Chocolate(double amount, double priceOfChocolate) {
		super(amount);
		setPriceOfChocolate(priceOfChocolate);
	}
	
	public static double getPriceOfChocolate() {
		return priceOfChocolate;
	}
	
	public static void setPriceOfChocolate(double newPriceOfChocolate) {
		priceOfChocolate = newPriceOfChocolate;
	}
}
