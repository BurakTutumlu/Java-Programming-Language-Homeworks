package App;


public class Menu {
	
	//Beginning of the Menu
	public static void displayMainMenu() {
		//we need to do menu operations in here for more clean code.
		System.out.println("_________ MAIN MENU __________\n");
		System.out.println("Our company has 10000 tl at the beginnig\n");	
			}
	
	//User will select one of those number to do action
	public static void displayPrintMenu() {
		System.out.println("write 0 to exit from the program");
		System.out.println("write 1 to see costable menu");
		System.out.println("Write 2 to see ingredient menu");
		System.out.println("write 3 to see product menu");
		
	}
	
	//User will select one of those number to do action
	public static void ingredientMenu() {
		System.out.println("Choose the ingredient for Warehouse and how many liter of it?");
		System.out.println("write 0 to come back");
		System.out.println("1) Milk");
		System.out.println("2) Cream");
		System.out.println("3) Cacao");
		System.out.println("4) Yeast");
		System.out.println("write 0 to back menu");
	}
	
	//User will select one of those number to do action
	public static void productMenu() {
		System.out.println("Products are produced by ingredients in Factory");
		System.out.println("Product:\n" + "boxed milk\n" + "chocolate\n" + "yogurt\n");
		System.out.println("for products info, you can write:");
		System.out.println("1 to see boxed milk info");
		System.out.println("2 to see chocolate info");
		System.out.println("3 to see yogurt info");
		System.out.println("write 0 to back menu");
		System.out.println();
	}
	
	//Customer will see for costable operations
	public static void costableMenu() {
		System.out.println("Those are the costable things and their costs:");
		System.out.println("1L of milk costs 0.25tl\n" + "1L of cream costs 0.30tl\n" + "1L of cacao costs 1tl\n" 
		+ "1L of yeast costs 5tl\n" + "One container costs 100tl to shipping two facilities(just going)\n" + 
		"1L of boxed milk costs 1tl\n" + "1L of chocolate costs 4tl\n" + "1L of yogurt costs 2tl");
		System.out.println("write 0 to back menu");
	}
	
	//Customer will see, what he or she needs for product boxed milk
	public static void boxedMilkInfo() {
		System.out.println("1000L boxed milk needs ---> 1000L milk");
	}
	
	//Customer will see, what he or she need for producct chocolate
	public static void chocolateInfo() {
		System.out.println("800L chocolate needs ---> 500L milk + 200L cream + 300L cacao");
	}
	
	//Customer will see, what he or she need for product yogurt
	public static void yogurtInfo() {
		System.out.println("1400L of yogurt needs ---> 1500L milk + 100L yeast");
	}
	
	
	//We do all menu operations here.
	public static void printMenu() {
		loopMain: while (true) {
			displayMainMenu();
			displayPrintMenu();
			String userInput = Operations.userInput();
			switch (userInput) {
			//for exit 
			case "0":
				System.out.println("Good bye");
				break loopMain;
			case "1":
				costableMenu();
				backToMenu();
				break;
			case "2":
				ingredientMenu();
				ingredientOperations();
				break;
			case "3":
				productMenu();
				productOperations();
				break;
			default:
				System.out.println("Please enter a valid option.\n");
				break;
			}
		}
	}
	
	//come back to menu
	public static void backToMenu() {
		while(true) {
			String userInput = Operations.userInput();
			switch(userInput) {
			case "0":
				return;
			default:
				System.out.println("give valid option");
				break;
			}
		}
	}
	
	//here is the ingredient operations when user selecct 2 at first
	public static void ingredientOperations() {
		while(true) {
			String userInput = Operations.userInput();
			switch(userInput) {
			case "0":
				return;
			case "1":
				chooseLiter();
				break;
			case "2":
				chooseLiter();
				break;
			case "3":
				chooseLiter();
				break;
			case "4":
				chooseLiter();
				break;
			default:
				System.out.println("give valid option");
				break;
			}
		}
	}
	
	//here is the product operations when user select 3 at first
	public static void productOperations() {
		while(true) {
			String userInput = Operations.userInput();
			switch(userInput) {
			case"0":
				return;
			case "1":
				boxedMilkInfo();
				break;
			case "2":
				chocolateInfo();
				break;
			case "3":
				yogurtInfo();
				break;
			default:
				System.out.println("You saw the information");
			}
		}
	}
	
	//when user select ingredient and liter of all ingredient
	public static String chooseLiter() {	
		String literInput = Operations.userInput();
		System.out.println("You bought " + literInput + "L" );
		return literInput;
			}
		}
