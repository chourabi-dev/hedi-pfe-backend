package com.grokonez.jwtauthentication.message.request;

import java.util.Set;

 

public class EditRequest {
	
    private long id; 
	    private String name;
 
	    private String username;
 
	    private String email;
	    
	    private Set<String> role;

	      
	    
	     

		public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }


	    
	    public Set<String> getRole() {
	    	return this.role;
	    }
	    
	    public void setRole(Set<String> role) {
	    	this.role = role;
	    }

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}
	    
	    
}
