package App;

import java.util.Scanner;

public class Operations {
	
	//We can do operations here with user.
	public static String userInput() {
		System.out.println("Which operation do you want to see. Write a number which is given please");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.next();
		return input;
	}
}
