package User;

public class AdminUser extends User {
	
	public AdminUser() {
		super();
	}

	public AdminUser(String username, String password) {
		super(username, password);
	}
	
	public AdminUser(String username, String password,ActiveBalance balance) {
		super(username, password,balance);
	}
}

