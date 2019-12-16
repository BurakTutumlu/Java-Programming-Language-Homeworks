package Product;

public class BoxedMilk extends Product implements ICountable {
	//boxedmilk produced by milk
	//private static final double AMOUNT = 1.0;
	private static double priceOfBoxedMilk;
	public BoxedMilk() {
		super();
	}
	public BoxedMilk(double amount) {
		super(amount);
	}
	public BoxedMilk(double amount, double priceOfBoxedMilk) {
		super(amount);
		setPriceOfBoxedMilk(priceOfBoxedMilk);
	}
	
	public static double getPriceOfBoxedMilk() {
		return priceOfBoxedMilk;
	}
	
	public static void setPriceOfBoxedMilk(double newPriceOfBoxedMilk) {
		priceOfBoxedMilk = newPriceOfBoxedMilk;
	}	
}
