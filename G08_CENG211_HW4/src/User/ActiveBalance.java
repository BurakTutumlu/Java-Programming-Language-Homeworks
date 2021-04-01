package User;

public class ActiveBalance {
	private double money;
	
	public ActiveBalance() {
		setMoney(0.0);
	}
	public ActiveBalance(double money) {
		setMoney(money);
	}
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	public String toString() {
		return "Money: "+money;
	}

}
