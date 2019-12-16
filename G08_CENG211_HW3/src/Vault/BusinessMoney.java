package Vault;
import Constants.*;

public class BusinessMoney {
	private static double money;
	
	public BusinessMoney() {
		money = Money.getDefaultMoney();
	}
	public BusinessMoney(double money) {
		money = money;
	}
	
	public static double getMoney() {
		return money;
	}
	
	public static void setMoney(double money) {
		money = money;
	}
	
	
}
