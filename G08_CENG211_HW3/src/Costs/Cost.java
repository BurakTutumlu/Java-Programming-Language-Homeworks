package Costs;
import Constants.Money; 
import Product.*;
import Vault.*;
import Ingredient.*;
import Containers.*;
import Vault.*;

public class Cost  {
	Costable types;
	private double initialAccount = BusinessMoney.getMoney();
	
	public Cost() {
		initialAccount = 0;
	}
	
	public Cost(double initialAccount) {
		initialAccount = initialAccount;
	}
	public double getInitialAccount() {
		return initialAccount;
	}
	/*
	public void setInitialAccount() {
		initialAccount = Constant.getDefaultMoney();
		switch(types) {
		case MILK:
			initialAccount -= Milk.getPriceOfMilk();
			break;
		case CREAM:
			initialAccount -= Cream.getPriceOfCream();
			break;
		case CACAO:
			initialAccount -= Cacao.getPriceOfCacao();
			break;
		case YEAST:
			initialAccount -= Yeast.getPriceOfYeast();
			break;
		case TRANSPORT:
			initialAccount -= Container.getPriceOfTransport();
			break;
		case BOXED_MILK:
			initialAccount -= BoxedMilk.getPriceOfBoxedMilk();
			break;
		case CHOCOLATE:
			initialAccount -= Chocolate.getPriceOfChocolate();
			break;
		case YOGURT:
			initialAccount -= Yogurt.getPriceOfYogurt();
			break;
		}
	}
	*/
}
