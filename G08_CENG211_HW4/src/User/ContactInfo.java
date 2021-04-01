package User;

import java.util.ArrayList;

public class ContactInfo {
	
	private ArrayList<Address> addressList;
	private String telephone;
	private String email;
	
	// Constructor(s)
	public ContactInfo() {
		addressList = new ArrayList<Address>();
		telephone = "";
		email = "";
	}
	public ContactInfo(ArrayList<Address> addressList) {
		this.addressList = addressList;
		telephone = "";
		email = "";
	}
	public ContactInfo(String telephone, String email) {
		addressList = new ArrayList<Address>();
		this.telephone = telephone;
		this.email = email;
	}
	public ContactInfo(ArrayList<Address> addressList,String telephone, String email) {
		this.addressList = addressList;
		this.telephone = telephone;
		this.email = email;
	}
	// Getters & Setters
	public ArrayList<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(ArrayList<Address> addressList) {
		this.addressList = addressList;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
     * Add an address to addressList
     * @param: address to be added
     * @return: none
	 * @throws AddressTitleAlreadyExistsException 
     */
	public void addAddress(Address newAddress) throws AddressTitleAlreadyExistsException {
		if(checkAddressTitleExists(newAddress.getTitle())) {
			throw new AddressTitleAlreadyExistsException();
		}
		addressList.add(newAddress);
	}
	/**
     * Remove and address from addressList
     * @param: address to be removed
     * @return: none
     */
	public void removeAddress(Address removedAddress) {
		addressList.remove(removedAddress);
	}
	/**
     * Get Address by title
     * @param: title to be searched
     * @return: none
     */
	public Address getAddress(String title) throws AddressNotFoundException {
		for (Address addr : addressList) {
			if (addr.getTitle().equals(title)) {
				return addr;
			}
		}
		throw new AddressNotFoundException();
	}
	
	/**
     * Check if address title exists
     * @param: title to be checked
     * @return: true if address title exists
     */
	public boolean checkAddressTitleExists(String title) {
		for (Address addr : addressList) {
			if (addr.getTitle().equals(title)) {
				return true;
			}
		}
		return false;
	}
	public boolean equals(ContactInfo other) {
		return addressList.equals(other.getAddressList()) && telephone.equals(other.getTelephone()) 
				&& email.equals(other.getEmail());
	}
	public String toString() {
		String str ="";
		int i = 0;
		for (Address addr: addressList) {
			str+="\t## Address " +i+"\n";
			str+="\t"+addr.toString();
		}
		str+="\n\tTelephone: "+getTelephone()+"\n\tEmail: "+getEmail();
		return str;
	}
}
