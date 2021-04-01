package MarketingApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import File.*;
import Product.*;
import Storage.*;
import User.*;
public class Init {
	
	public static final String USERS_FILE_PATH = "src/csv_files/users.csv";
	public static final String PRODUCTS_FILE_PATH = "src/csv_files/products.csv";
	
	public static UserContainer makeInit() {
		UserContainer userList = parseUsers();
		Map<Product,Integer> productList = parseProducts();
		try {
			transferProductsToSuppliers(userList, productList);
			ArrayList<Supplier> sList = userList.getSupplierList();
			for (Supplier s : sList) {
				System.out.println(s.toString());
			}
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public static UserContainer parseUsers() {
		UserContainer userList = new UserContainer();
		try {
			// read file
			Queue<String> lines = CsvFileReader.readFile(USERS_FILE_PATH);
			// remove headers
			lines.poll();
			for (String line: lines) {
				 User user = createUserFromLine(line);
				 userList.addUser(user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFileFormatException e) {
			e.printStackTrace();
		} catch (AddressTitleAlreadyExistsException e) {
			e.printStackTrace();
		} catch (UserAlreadyExistsException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public static User createUserFromLine(String line) throws InvalidFileFormatException, AddressTitleAlreadyExistsException {
		String[] lineArr = line.split(",");
		if (lineArr.length>0) {
			switch (lineArr[0]) {
			case "1": // Create Admin 
					return createAdminFromLine(line);
			case "2": // Create Customer
					return createCustomerFromLine(line);
			case "3": // Create Supplier
				return createSupplierFromLine(line);
			}
		}
		throw new InvalidFileFormatException("Invalid file format in users.csv");
	}
	
	public static AdminUser createAdminFromLine(String line) throws InvalidFileFormatException{
		String[] lineArr = line.split(",");
		if(lineArr.length==4) { 
			return new AdminUser(lineArr[1],lineArr[2],new ActiveBalance(Double.parseDouble(lineArr[3])));
		}
		throw new InvalidFileFormatException("Invalid file format in users.csv");
	}
	
	public static Customer createCustomerFromLine(String line)  throws InvalidFileFormatException, AddressTitleAlreadyExistsException{
		String [] lineArr = line.split(",");
		if(lineArr.length >= 14) {
			ContactInfo contactInfo = new ContactInfo(lineArr[4],lineArr[5]);
			for (int i=9;i<lineArr.length;i+=6) {
				
				contactInfo.addAddress(new Address(lineArr[i],lineArr[i+1],lineArr[i+2],lineArr[i+3],lineArr[i+4],lineArr[i+5]));
				
			}
			return new Customer(lineArr[1],lineArr[2],contactInfo,new ActiveBalance(Double.parseDouble(lineArr[3])));
		}
		throw new InvalidFileFormatException("Invalid file format in users.csv");
	}
	
	public static Supplier createSupplierFromLine(String line) throws InvalidFileFormatException,AddressTitleAlreadyExistsException{
		String[] lineArr = line.split(",");
		if(lineArr.length>=14) {
			ContactInfo contactInfo = new ContactInfo(lineArr[4],lineArr[5]);
			for (int i=9;i<lineArr.length;i+=6) {
				contactInfo.addAddress(new Address(lineArr[i],lineArr[i+1],lineArr[i+2],lineArr[i+3],lineArr[i+4],lineArr[i+5]));
			}
			Supplier supplier = new Supplier(lineArr[1],lineArr[2],new ActiveBalance(Double.parseDouble(lineArr[3])));
			supplier.setContactInfo(contactInfo);
			Shop<Product> shop = new Shop<Product>();
			switch(lineArr[6]) {
			case "houseware":
				shop.setCategory(ShopCategory.HOUSEWARE);
				break;
			case "accessories":
				shop.setCategory(ShopCategory.ACCESSORIES);
				break;
			case "electronic":
				shop.setCategory(ShopCategory.ELECTRONIC);
				break;
			case "cosmetic":
				shop.setCategory(ShopCategory.COSMETIC);
				break;
			}
			shop.setName(lineArr[7]);
			shop.setTaxNumber(lineArr[8]);
			supplier.setShop(shop);
			return supplier;
		}
		throw new InvalidFileFormatException("Invalid file format in users.csv");
	}
	
	public static Map<Product,Integer> parseProducts() {
		Map<Product,Integer> productList = new HashMap<>();
		try {
			// read file
			Queue<String> lines = CsvFileReader.readFile(PRODUCTS_FILE_PATH);
			// remove headers
			lines.poll();
			for (String line: lines) {
				String[] lineArr = line.split(",");
				Product newProduct;
				newProduct = createProductFromLine(line);
				productList.put(newProduct, Integer.parseInt(lineArr[4])); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFileFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
	
	public static Product createProductFromLine(String line) throws InvalidFileFormatException{
		String[] lineArr = line.split(",");
		if(lineArr.length==5) {
			switch(lineArr[0]) {
			case "houseware":
				return new Product(ShopCategory.HOUSEWARE,lineArr[1],Double.parseDouble(lineArr[2]),Double.parseDouble(lineArr[3]));
			case "electronic":
				return new Product(ShopCategory.ELECTRONIC,lineArr[1],Double.parseDouble(lineArr[2]),Double.parseDouble(lineArr[3]));
			case "accessories":
				return new FragileProduct(ShopCategory.ACCESSORIES,lineArr[1],Double.parseDouble(lineArr[2]),Double.parseDouble(lineArr[3]));
			case "cosmetic":
				return new FastConsumptionProduct(ShopCategory.COSMETIC,lineArr[1],Double.parseDouble(lineArr[2]),Double.parseDouble(lineArr[3]));
			}
		}
		throw new InvalidFileFormatException("Invalid file format in products.csv");
	}
	
	public static void transferProductsToSuppliers(UserContainer userList,Map<Product,Integer> productList) throws UserNotFoundException {
		for (Map.Entry<Product, Integer> entry : productList.entrySet()) {
		    userList.getSupplierByCategory(entry.getKey().getCategory()).addItemToShop(entry.getKey(), entry.getValue());
		}
	}
}
