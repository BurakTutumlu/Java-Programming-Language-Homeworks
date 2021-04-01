package User;

public class Address {

	private String title;
	private String country;
	private String city;
	private String state;
	private String street;
	private String doorNumber;
	
	
	// Constructor(s)
	public Address() {
		title= "";
		country = "";
		city= "";
		street = "";
		doorNumber= "";
	}
	
	public Address(String title) {
		this.title= title;
		country = "";
		city= "";
		street = "";
		doorNumber= "";
	}
	public Address(String title,String country, String city, String state,String street, String doorNumber) {
		this.title= title;
		this.country = country;
		this.city= city;
		this.state=state;
		this.street = street;
		this.doorNumber = doorNumber;
	}
	// Getters & Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public boolean equals(Address other) {
		return title.equals(other.getTitle()) && country.equals(other.getCountry())
				&& city.equals(other.getCity()) && street.equals(other.getStreet())
				&& doorNumber.equals(other.getDoorNumber());
	}
	
	public String toString() {
		String str = "\tTitle: "+getTitle()+"\n\tCountry: "+getCountry()+"\n\tCity: "+getCity();
		str+="\n\tState: "+getState()+"\n\tStreet: "+getStreet()+"\n\tDoor Number: "+getDoorNumber();
		return str;
	}
	


}
