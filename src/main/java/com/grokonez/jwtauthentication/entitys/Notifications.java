package com.grokonez.jwtauthentication.entitys;

import java.time.LocalDateTime;
import java.util.Date;

 

import com.grokonez.jwtauthentication.model.User;

import jakarta.persistence.*;

@Entity
@Table(name = "notifications")
public class Notifications {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String message;
	 
    private String title;
    
	@ManyToOne
	@JoinColumn(nullable = true,name="users_id")
	private User user;


	private LocalDateTime  createdAt = LocalDateTime.now();
	
	private boolean isSeen;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

 

	public boolean isSeen() {
		return isSeen;
	}

	public void setSeen(boolean isSeen) {
		this.isSeen = isSeen;
	}

	public Notifications(Long id, String message,  String title,
			User user, Date adddate, boolean isSeen) {
		super();
		this.id = id;
		this.message = message;
		this.title = title;
		this.user = user; 
		this.isSeen = isSeen;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Notifications() {
		super();
	}
	 
	 
	 
	
	
	
    
}
