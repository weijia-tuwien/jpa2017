package model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String city;
	private String zip;

	public Address(String city, String zip) {
		super();
		this.city = city;
		this.zip = zip;
	}

	public Address() {
		super();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
