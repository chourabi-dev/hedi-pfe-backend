package com.grokonez.jwtauthentication.entitys;

import java.time.LocalDateTime;

import com.grokonez.jwtauthentication.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	 
	
	private LocalDateTime  createdAt = LocalDateTime.now();
	
	
	private LocalDateTime  reservationDate;
	 
	
	public LocalDateTime getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDateTime reservationDate) {
		this.reservationDate = reservationDate;
	}

	@ManyToOne
	private User user;
	
	@ManyToOne
	private Doctors doctor;
	
	
	private int status = 0;
	
	private String privateNote;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Doctors getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPrivateNote() {
		return privateNote;
	}

	public void setPrivateNote(String privateNote) {
		this.privateNote = privateNote;
	}

	public Reservation(Long id, LocalDateTime createdAt, User user, Doctors doctor, int status, String privateNote) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.user = user;
		this.doctor = doctor;
		this.status = status;
		this.privateNote = privateNote;
	}

	public Reservation() {
		super();
	}
	
	
	
	
}
