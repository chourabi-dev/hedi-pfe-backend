package com.grokonez.jwtauthentication.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctors {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
	private String fullname;
    
	private String address;
    
	private String email;
    
	private String phone;
	
	@Column( length=2500 )
	private String about;
	
	@ManyToOne
	@JoinColumn( name="categories_id", nullable=false )
	private Category category;
	
	
	
	

	public Doctors(Long id, String fullname, String address, String email, String phone, String about,
			Category category) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.about = about;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Doctors() {
		super();
	}
	
	
	
	
	
	
	
    
    
}
