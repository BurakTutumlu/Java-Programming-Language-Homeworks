
public class Wallet {
	private double money;

	public Wallet() {
		money=TypeDefs.DEFAULT_MONEY;
	}
	
	public Wallet(double money) {
		this.money=money;
	}
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
}
