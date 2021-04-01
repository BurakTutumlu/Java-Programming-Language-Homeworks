package User;

public abstract class User {
	private String username;
	private String password;
	private ActiveBalance balance;
	// TODO: Add active balance
	
	// Getters & Setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ActiveBalance getBalance() {
		return balance;
	}
	public void setBalance(ActiveBalance balance) {
		this.balance = balance;
	}
		
	
	// Constructor(s)
	public User() {
		username = "";
		password = "";
	}
	public User(String username,String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(String username,String password,ActiveBalance balance) {
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	
	public boolean equals(User other) {
		return username.equals(other.getUsername()) && password.equals(other.getPassword());
	}
	
}

