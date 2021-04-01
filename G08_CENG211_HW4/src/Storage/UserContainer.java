package Storage;

import java.util.ArrayList;

import User.*;

public class UserContainer {
	private ArrayList<AdminUser> adminList;
	private ArrayList<Customer> customerList;
	private ArrayList<Supplier> supplierList;
	
	public UserContainer() {
		adminList = new ArrayList<>();
		customerList = new ArrayList<>();
		supplierList = new ArrayList<>();
	}
	
	public void addUser(User user) throws UserAlreadyExistsException {
		// check username exists 
		if (checkUserExists(user.getUsername())){
			throw new UserAlreadyExistsException("User "+user.getUsername()+" already exists.");
		}
		if(user instanceof AdminUser) {
			adminList.add((AdminUser) user);
		}else if (user instanceof Customer) {
			customerList.add((Customer) user);
		}else if (user instanceof Supplier) {
			supplierList.add((Supplier) user);
		}
	}
	
	public void removeUser(User user) {
		if(user instanceof AdminUser) {
			adminList.remove(((AdminUser) user));
		}else if (user instanceof Customer) {
			customerList.remove(((Customer) user));
		}else if (user instanceof Supplier) {
			supplierList.remove(((Supplier) user));
		}
	
	}
	public void removeUser(String username) {
		// search in admin list
		for(AdminUser a: adminList) {
			if(a.getUsername().equals(username)) {
				adminList.remove(a);
			}
		}
		// search in customer list
		for(Customer c: customerList) {
			if(c.getUsername().equals(username)) {
				customerList.remove(c);
			}
		}
		// search in supplier list
		for(Supplier s: supplierList) {
			if(s.getUsername().equals(username)) {
				supplierList.remove(s);
			}
		}

	}
	
	public boolean checkUserExists(User user) {
		if(user instanceof AdminUser) {
			return adminList.contains((AdminUser) user);
		}else if (user instanceof Customer) {
			return customerList.contains((Customer) user);
		}else if (user instanceof Supplier) {
			return supplierList.contains((Supplier) user);
		}
		return false;
	}
	public boolean checkUserExists(String username) {
		// search in admin list
		for(AdminUser a: adminList) {
			if(a.getUsername().equals(username)) {
				return true;
			}
		}
		// search in customer list
		for(Customer c: customerList) {
			if(c.getUsername().equals(username)) {
				return true;
			}
		}
		// search in customer list
		for(Supplier s: supplierList) {
			if(s.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
	
	//We overloaded the checkUserExists method for password <
	public boolean checkUserExists(String username, String password) {
		// search in admin list
				for(AdminUser a: adminList) {
					if(a.getPassword().equals(password)) {
						return true;
					}
				}
				// search in customer list
				for(Customer c: customerList) {
					if(c.getPassword().equals(password)) {
						return true;
					}
				}
				// search in customer list
				for(Supplier s: supplierList) {
					if(s.getPassword().equals(password)) {
						return true;
					}
				}
				return false;
			}

	
	public User getUser(String username) throws UserNotFoundException {
		// search in admin list
		for(AdminUser a: adminList) {
			if(a.getUsername().equals(username)) {
				return a;
			}
		}
		// search in customer list
		for(Customer c: customerList) {
			if(c.getUsername().equals(username)) {
				return c;
			}
		}
		// search in supplier list
		for(Supplier s: supplierList) {
			if(s.getUsername().equals(username)) {
				return s;
			}
		}
		throw new UserNotFoundException("User "+username+" not found.");
	}
	
	public ArrayList<AdminUser> getAdminList(){
		return adminList;
	}
	public void setAdminList(ArrayList<AdminUser> adminList) {
		this.adminList = adminList;
	}
	public ArrayList<Customer> getCustomerList(){
		return customerList;
	}
	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	public ArrayList<Supplier> getSupplierList(){
		return supplierList;
	}
	public void setSupplierList(ArrayList<Supplier> supplierList) {
		this.supplierList = supplierList;
	}
	public Supplier getSupplierByCategory(ShopCategory category) throws UserNotFoundException {
		for(Supplier s: supplierList) {
			if(s.getShopCategory().equals(category)) {
				return s;
			}
		}
		throw new UserNotFoundException("Supplier not found in "+category.toString()+" category.");
	}

}
