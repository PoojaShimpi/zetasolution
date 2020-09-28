package com.he.addressBook;

public class Address {

	private String label;
	private String address;
	
	public Address(String label, String address) throws Exception {
		if (label == null || label == "" ) {
			throw new Exception();
		}
		int length = label.length();
		if (length > 255 || label.trim().equals("")) {
			throw new Exception();
		}
		if (!label.matches("[a-zA-Z ]+")) {
			throw new Exception();
		}
		this.label = label;
		this.address = address;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public String getAddress() {
		return this.address;
	}
}
