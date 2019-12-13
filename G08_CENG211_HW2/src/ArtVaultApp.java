import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ArtVaultApp {
	private static final String CSV_FILE_PATH = "src/CENG211_HW2_ArtVaultData.csv";
	private static Vault vault = new Vault();
	public static void main(String[] args) throws IOException {
		createVault();
		vault.selectRandomTradableArtwork();
		Menu.initMenu();
	}
	
	/**
     * Initiliaze vault by reading and processing file
     * @param: none
     * @return: none
     */
	public static void createVault() throws IOException{
		BufferedReader readerFile = FileIO.ReadFile(CSV_FILE_PATH);
		String lineFile = readerFile.readLine();
		while (lineFile!=null) {
			String[] lineArr = lineFile.split(",");
			 switch (Integer.parseInt(lineArr[0])) {
		        case 1 : // Painting
		        	Painting newPainting = new Painting(lineArr[1],lineArr[2],lineArr[3],
		            		Double.parseDouble(lineArr[4]),Double.parseDouble(lineArr[5])
		            		);
		            vault.addArtwork(newPainting);
		            break;

		        case 2 : // Sculpture
		        	Sculpture newSculpture = new Sculpture(lineArr[1],lineArr[2],lineArr[3],
		        			lineArr[4],Integer.parseInt(lineArr[5])
		        			);
		        	vault.addArtwork(newSculpture);
		            break;

		        case 3 : // Architecture
		        	// Architecture scheme: Id, Name, Style, D-1, D-2, D-3, Architects...
		        	// Create Architects first
		        	// Architect names starts from index 6
		        	String[] archArr = Arrays.copyOfRange(lineArr, 6, lineArr.length);
		        	ArrayList<Architect> archList = new ArrayList<Architect>();
		        	for (String archStr : archArr) {
		        		Architect newArch = new Architect(archStr);
		        		archList.add(newArch);
		        		vault.addPerson(newArch);
		        	}
		        	// Create Archirecture
		            Architecture newArch = new Architecture(lineArr[1],lineArr[2],
		            		Double.parseDouble(lineArr[3]),Double.parseDouble(lineArr[4]),
		            		Double.parseDouble(lineArr[5]),archList
		            		);
		            vault.addArtwork(newArch);
		            break;
		        case 4 : // Artist
		        	// Artist scheme: Id, Name, Born,Died, Nationality, Periods...
		        	// Create periods first
		        	// Architect names starts from index 4
		        	String[] periodArr = Arrays.copyOfRange(lineArr, 4, lineArr.length);
		        	ArrayList<String> periodList = new ArrayList<String>();
		        	for (String periodStr : periodArr) {
		        		periodList.add(periodStr);
		        	}
		        	Artist artist = new Artist(lineArr[1],Integer.parseInt(lineArr[2]),
		        			Integer.parseInt(lineArr[3]),lineArr[4],periodList
		        			);
		        	vault.addPerson(artist);
		            break;
		        case 5 : // Architect
		            Architect architect = new Architect(lineArr[1],Integer.parseInt(lineArr[2]),
		            		Integer.parseInt(lineArr[3]),lineArr[4]
		            				);
		            vault.addPerson(architect);
		            break;

		        default :
		        	System.out.println("Invalid file format.");
		        	System.exit(0); 
		        }
			 
			 lineFile=readerFile.readLine();
		}
	}
	
	public static void PrintArtists(TypeDefs.SortMethod sortMethod) {
		vault.sortPersons(sortMethod);
		vault.printArtists();
	}
	public static void PrintArchitects(TypeDefs.SortMethod sortMethod) {
		vault.sortPersons(sortMethod);
		vault.printArchitects();
	}
	public static void PrintPaintings(TypeDefs.SortMethod sortMethod) {
		vault.sortArtworks(sortMethod);
		vault.printPaintings();
	}
	public static void PrintSculptures(TypeDefs.SortMethod sortMethod) {
		vault.sortArtworks(sortMethod);
		vault.printSculptures();
	}
	public static void PrintArchitectures(TypeDefs.SortMethod sortMethod) {
		vault.sortArtworks(sortMethod);
		vault.printArchitecture();
	}
	
	public static void searchVault(String str) {
		vault.searchVault(str);
	}
	
	public static void makeTrade() {
		// Seller
		Wallet wallet_seller = new Wallet(0.0);
		// Buyer-1
		IBag <Artwork> vault_buyer_1 = new Bag<Artwork>();
		Wallet wallet_buyer_1 = new Wallet();
		// Buyer-2
		IBag <Artwork> vault_buyer_2 = new Bag<Artwork>();
		Wallet wallet_buyer_2 = new Wallet();
		// Buyer-3
		IBag <Artwork> vault_buyer_3 = new Bag<Artwork>();
		Wallet wallet_buyer_3 = new Wallet();
		// Buyer-4
		IBag <Artwork> vault_buyer_4 = new Bag<Artwork>();
		Wallet wallet_buyer_4 = new Wallet();
		// START TRADE
		
		System.out.println("Seller's money: "+wallet_seller.getMoney() +" TL");
		System.out.println("Buyer 1's money: "+wallet_buyer_1.getMoney() +" TL");
		System.out.println("Buyer 2's money: "+wallet_buyer_2.getMoney() +" TL");
		System.out.println("Buyer 3's money: "+wallet_buyer_3.getMoney() +" TL");
		System.out.println("Buyer 4's money: "+wallet_buyer_4.getMoney() +" TL");
		System.out.println("\nTrade started\n");
		// Trade Artwork 1
		Artwork randArt_1 = vault.selectRandomTradableArtwork();
		double art_1_price = randArt_1.calculateCost();
		System.out.println("Buyer 1 bought:\n"+randArt_1.toString()+"\n\tPrice: "+Double.toString(art_1_price)+" TL\n");
		vault.transferArtwork(vault_buyer_1, randArt_1);
		wallet_buyer_1.setMoney(wallet_buyer_1.getMoney()-art_1_price);
		wallet_seller.setMoney(wallet_seller.getMoney()+art_1_price);
		// Trade Artwork 2
		Artwork randArt_2 = vault.selectRandomTradableArtwork();
		double art_2_price = randArt_2.calculateCost();
		System.out.println("Buyer 2 bought:\n"+randArt_2.toString()+"\n\tPrice: "+Double.toString(art_2_price)+" TL\n");
		vault.transferArtwork(vault_buyer_2, randArt_2);
		wallet_buyer_2.setMoney(wallet_buyer_2.getMoney()-art_2_price);
		wallet_seller.setMoney(wallet_seller.getMoney()+art_2_price);
		// Trade Artwork 3
		Artwork randArt_3 = vault.selectRandomTradableArtwork();
		double art_3_price = randArt_3.calculateCost();
		System.out.println("Buyer 3 bought:\n"+randArt_3.toString()+"\n\tPrice: "+Double.toString(art_3_price)+" TL\n");
		vault.transferArtwork(vault_buyer_3, randArt_3);
		wallet_buyer_3.setMoney(wallet_buyer_3.getMoney()-art_3_price);
		wallet_seller.setMoney(wallet_seller.getMoney()+art_3_price);
		// Trade Artwork 4
		Artwork randArt_4 = vault.selectRandomTradableArtwork();
		double art_4_price = randArt_4.calculateCost();
		System.out.println("Buyer 4 bought:\n"+randArt_4.toString()+"\n\tPrice: "+Double.toString(art_4_price)+" TL\n");
		vault.transferArtwork(vault_buyer_4, randArt_4);
		wallet_buyer_4.setMoney(wallet_buyer_4.getMoney()-art_4_price);
		wallet_seller.setMoney(wallet_seller.getMoney()+art_4_price);
		// TRADE COMPLETED
		System.out.println("Trade completed");
		System.out.println("Seller's money: "+ Double.toString(wallet_seller.getMoney())+" TL");
		System.out.println("Buyer 1's money: "+ Double.toString(wallet_buyer_1.getMoney())+" TL");
		System.out.println("Buyer 2's money: "+ Double.toString(wallet_buyer_2.getMoney())+" TL");
		System.out.println("Buyer 3's money: "+ Double.toString(wallet_buyer_3.getMoney())+" TL");
		System.out.println("Buyer 4's money: "+ Double.toString(wallet_buyer_4.getMoney())+" TL");
		// Reset values to default
		wallet_seller.setMoney(0.0);
		wallet_buyer_1.setMoney(TypeDefs.DEFAULT_MONEY);
		wallet_buyer_2.setMoney(TypeDefs.DEFAULT_MONEY);
		wallet_buyer_3.setMoney(TypeDefs.DEFAULT_MONEY);
		wallet_buyer_4.setMoney(TypeDefs.DEFAULT_MONEY);
		vault_buyer_1.remove(randArt_1);
		vault_buyer_2.remove(randArt_2);
		vault_buyer_3.remove(randArt_3);
		vault_buyer_4.remove(randArt_4);
		vault.addArtwork(randArt_1);
		vault.addArtwork(randArt_2);
		vault.addArtwork(randArt_3);
		vault.addArtwork(randArt_4);
		
		
		
	}

	
}
