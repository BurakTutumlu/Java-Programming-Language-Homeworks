import java.util.Scanner;

public class Menu {
	public static void displayMainMenu() {
		System.out.println("_________ MAIN MENU __________\n");
		System.out.println("Please enter the number of operation you want to perform:\n");
		System.out.println("1) Print the lists\n2) Search the vault\n3) Trade\n0) Exit");
	}
	
	public static void displayPrintMenu() {
		System.out.println("Please choose the list:\n");
		System.out.println("1) Print the list of artists.\n2) Print the list of architects\n"
				+ "3) Print the list of paintings.\n4) Print the list of sculptures.\n"
				+ "5) Print the list of architectures.\n0) Exit");
	}
	
	public static void displaySortMenu(TypeDefs.VaultDataType dataType) {
		System.out.println("Please choose the sorting method:\n");
		switch (dataType) {
		
		case ARTIST:
		case ARCHITECT:
			System.out.println("1) Sort by name\n2) Sort by birth date\n3) Sort by nationality\n0) Exit");
			break;
		case PAINTING:
			System.out.println("1) Sort by name\n2) Sort by style\n3) Sort by artist name\n0) Exit");
			break;
		case SCULPTURE:
			System.out.println("1) Sort by name\n2) Sort by style\n3) Sort by artist name\n4) Sort by material\n0) Exit");
			break;
		case ARCHITECTURE:
			System.out.println("1) Sort by name\n2) Sort by style\n0) Exit");
			break;
		default:
			System.out.println("Invalid input.");
			break;
		}
	}
	public static void initMenu() {
		// Initialize main menu
		loopMain: while (true) {
			displayMainMenu();
			String mainOption = getInput();
			switch (mainOption) {
			case "0":
				break loopMain;
			case "1":
				printListsMenu();
				break;
			case "2":
				searchVault();
				break;
			case "3":
				ArtVaultApp.makeTrade();
				break;
			default:
				System.out.println("Please enter a valid option.\n");
				break;
			}
		}
	}
	public static void printListsMenu() {
		while (true) {
			displayPrintMenu();
			String printOption = getInput();
			switch (printOption) {
			case "0":
				return;
			case "1":
				displaySortMenu(TypeDefs.VaultDataType.ARTIST);
				TypeDefs.SortMethod sortMethod = getPersonSortMethod();
				if (sortMethod!=null) {
					ArtVaultApp.PrintArtists(sortMethod);
					return;
				}
				break;
			case "2":
				displaySortMenu(TypeDefs.VaultDataType.ARCHITECT);
				TypeDefs.SortMethod sortMethodArchitect = getPersonSortMethod();
				if (sortMethodArchitect!=null) {
					ArtVaultApp.PrintArchitects(sortMethodArchitect);
					return;
				}
				break;
			case "3":
				displaySortMenu(TypeDefs.VaultDataType.PAINTING);
				TypeDefs.SortMethod sortMethodPainting = getPaintingSortMethod();
				if (sortMethodPainting!=null) {
					ArtVaultApp.PrintPaintings(sortMethodPainting);
					return;
				}
				break;
			case "4":
				displaySortMenu(TypeDefs.VaultDataType.SCULPTURE);
				TypeDefs.SortMethod sortMethodSculpture = getSculptureSortMethod();
				if (sortMethodSculpture!=null) {
					ArtVaultApp.PrintSculptures(sortMethodSculpture);
					return;
				}
				break;
			case "5":
				displaySortMenu(TypeDefs.VaultDataType.ARCHITECTURE);
				TypeDefs.SortMethod sortMethodArchitecture = getArchitectureSortMethod();
				if (sortMethodArchitecture!=null) {
					ArtVaultApp.PrintArchitectures(sortMethodArchitecture);
					return;
				}
				break;
			}
		}
	}
	
	public static String getInput() {
		Scanner keyboard = new Scanner(System.in);
		String option = keyboard.nextLine();
		return option;
	}
	public static TypeDefs.SortMethod getPersonSortMethod() {
		while (true) {
			String option = getInput();
			switch(option) {
			case "0":
				return null;
			case "1":
				return TypeDefs.SortMethod.NAME;
			case "2":
				return TypeDefs.SortMethod.BIRTHDAY;
			case "3":
				return TypeDefs.SortMethod.NATIONALITY;
			default:
				System.out.println("Please enter a valid option.");
				break;
			}
		}
		
	}
	public static TypeDefs.SortMethod getPaintingSortMethod() {
		while (true) {
			String option = getInput();
			switch(option) {
			case "0":
				return null;
			case "1":
				return TypeDefs.SortMethod.NAME;
			case "2":
				return TypeDefs.SortMethod.STYLE;
			case "3":
				return TypeDefs.SortMethod.ARTIST;
			default:
				System.out.println("Please enter a valid option.");
				break;
			}
		}
		
	}
	
	public static TypeDefs.SortMethod getSculptureSortMethod() {
		while (true) {
			String option = getInput();
			switch(option) {
			case "0":
				return null;
			case "1":
				return TypeDefs.SortMethod.NAME;
			case "2":
				return TypeDefs.SortMethod.STYLE;
			case "3":
				return TypeDefs.SortMethod.ARTIST;
			case "4":
				return TypeDefs.SortMethod.MATERIAL;
			default:
				System.out.println("Please enter a valid option.");
				break;
			}
		}
	}
	public static TypeDefs.SortMethod getArchitectureSortMethod() {
		while (true) {
			String option = getInput();
			switch(option) {
			case "0":
				return null;
			case "1":
				return TypeDefs.SortMethod.NAME;
			case "2":
				return TypeDefs.SortMethod.STYLE;
			default:
				System.out.println("Please enter a valid option.");
				break;
			}
		}
	}
	public static void searchVault() {
		System.out.println("Enter the search word: ");
		String option = getInput();
		ArtVaultApp.searchVault(option);
	}
}
