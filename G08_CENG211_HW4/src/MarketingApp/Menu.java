package MarketingApp;

import java.util.Scanner;

public class Menu {

	public static void helloScreen() {
		System.out.println("+--------------------------------+");
		System.out.println("|                                |");
		System.out.println("|    G08 ONLINE MARKETING APP    |");
		System.out.println("|                                |");
		System.out.println("|           WELCOME!             |");
		System.out.println("|                                |");
		System.out.println("+--------------------------------+");

	}
	public static String enterOption(String option) {
		System.out.println("\nEnter "+option+":");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		return input;
	}
}
