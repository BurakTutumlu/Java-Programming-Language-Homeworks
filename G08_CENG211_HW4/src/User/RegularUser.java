package User;

import java.util.ArrayList;

public abstract class RegularUser extends User {
	private ContactInfo contactInfo;
	
	// Constructor(s)
	public RegularUser() {
		super();
		contactInfo = new ContactInfo();
	}

	public RegularUser(String username, String password) {
		super(username, password);
	}
	public RegularUser(String username, String password,ActiveBalance balance) {
		super(username, password,balance);
	}
	public RegularUser(String username, String password,ContactInfo contactInfo) {
		super(username, password);
		this.contactInfo = contactInfo;
	}
	public RegularUser(String username, String password,ContactInfo contactInfo,ActiveBalance balance) {
		super(username, password,balance);
		this.contactInfo = contactInfo;
	}
	
	// Getters & Setters
	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
		
	/**
     * Add an address to contactInfo
     * @param: address to be added
     * @return: none
	 * @throws AddressTitleAlreadyExistsException 
     */
	public void addAddress(Address newAddress) throws AddressTitleAlreadyExistsException {
		contactInfo.addAddress(newAddress);
	}
	
	/**
     * Remove and address from contactInfo
     * @param: address to be removed
     * @return: none
     */
	public void removeAddress(Address removedAddress) {
		contactInfo.removeAddress(removedAddress);
	}
	/**
     * Get Address List
     * @param: none
     * @return: Address List
     */
	public ArrayList<Address> getAddressList() {
		return contactInfo.getAddressList();
	}
	/**
     * Get Address by title
     * @param: title to be searched
     * @return: none
     */
	public Address getAddress(String title) throws AddressNotFoundException {
		return contactInfo.getAddress(title);
	}
}
