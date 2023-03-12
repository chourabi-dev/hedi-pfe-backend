package com.grokonez.jwtauthentication.message.request;

 

public class DoctorModel {
	
	private String fullname;
    
	private String address;
    
	private String email;
    
	private String phone;
	
	private String about;
	 
	private long  category;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}

	public DoctorModel(String fullname, String address, String email, String phone, String about, long category) {
		super();
		this.fullname = fullname;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.about = about;
		this.category = category;
	}

	public DoctorModel() {
		super();
	}
	
	
}
