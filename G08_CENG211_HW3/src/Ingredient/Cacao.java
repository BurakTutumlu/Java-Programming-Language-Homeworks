package Ingredient;

public class Cacao extends Ingredient implements IUncountable {
	//cacao produce chocolate
	private static double priceOfCacao;
	
	public Cacao() {
		super();
	}
	public Cacao(double amount) {
		super(amount);
	}
	
	public Cacao(double amount, double priceOfCacao) {
		super(amount);
		setPriceOfCacao(priceOfCacao);
	}
	
	public static double getPriceOfCacao() {
		return priceOfCacao;
	}
	
	public static void setPriceOfCacao(double newPriceOfCacao) {
		priceOfCacao = newPriceOfCacao;
	}
	
}
