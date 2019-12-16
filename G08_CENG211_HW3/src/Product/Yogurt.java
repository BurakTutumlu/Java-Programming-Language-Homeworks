package Product;

public class Yogurt extends Product implements ICountable {
	//yogurt produced by milk and yeast
	//private static final double AMOUNT = 2.0;
	private static double priceOfYogurt;
	
	public Yogurt() {
		super();
	}
	public Yogurt(double amount) {
		super(amount);
	}
	public Yogurt(double amount, double priceOfYogurt) {
		super(amount);
		setPriceOfYogurt(priceOfYogurt);
		
	}
	
	public static double getPriceOfYogurt() {
		return priceOfYogurt;
	}
	
	public static void setPriceOfYogurt(double newPriceOfYogurt) {
		priceOfYogurt = newPriceOfYogurt;
	}
}
