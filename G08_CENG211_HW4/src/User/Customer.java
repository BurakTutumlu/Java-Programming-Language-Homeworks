package User;

public class Customer extends RegularUser {

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String username, String password) {
		super(username, password);
	}

	public Customer(String username, String password, ContactInfo contactInfo) {
		super(username, password, contactInfo);
	}
	public Customer(String username, String password, ContactInfo contactInfo,ActiveBalance balance) {
		super(username, password, contactInfo,balance);
	}

}
