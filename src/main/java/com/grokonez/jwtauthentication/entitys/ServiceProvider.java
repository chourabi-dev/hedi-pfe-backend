package com.grokonez.jwtauthentication.entitys;

import com.grokonez.jwtauthentication.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "serviceproviders")
public class ServiceProvider {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	 
	
	@OneToOne
	private User user;
	
	@ManyToOne
	private ServiceCategory category;
	
	@ManyToOne
	private ServicesProviderlLocation location;
	
	
	private String descrption;
	
	private float pricing;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ServiceCategory getCategory() {
		return category;
	}

	public void setCategory(ServiceCategory category) {
		this.category = category;
	}

	public ServicesProviderlLocation getLocation() {
		return location;
	}

	public void setLocation(ServicesProviderlLocation location) {
		this.location = location;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public float getPricing() {
		return pricing;
	}

	public void setPricing(float pricing) {
		this.pricing = pricing;
	}

	public ServiceProvider() {
		super();
	}
	
	
	
}
