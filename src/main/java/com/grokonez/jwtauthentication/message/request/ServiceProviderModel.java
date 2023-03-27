package com.grokonez.jwtauthentication.message.request;

public class ServiceProviderModel {
	  
	   
	    
	   private long category;
	   private long location;
	   private String descreption;
	   private String name;
	   private float price;
	   private String email;
	   private String username;
	   private String password;
	public long getCategory() {
		return category;
	}
	public void setCategory(long category) {
		this.category = category;
	}
	public long getLocation() {
		return location;
	}
	public void setLocation(long location) {
		this.location = location;
	}
	public String getDescreption() {
		return descreption;
	}
	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public ServiceProviderModel() {
		super();
	}
	   
	   
	   
		 
	  
}
