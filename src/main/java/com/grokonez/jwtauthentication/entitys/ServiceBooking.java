package com.grokonez.jwtauthentication.entitys;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicebookings")
public class ServiceBooking {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	 
	
	private LocalDateTime  createdAt = LocalDateTime.now();
	
	
	private LocalDateTime  reservationDate;
	
	private String  descreption;
	
	
	@Column( name="status" , nullable=true )
	private int  status = 0;
	 
	
	 
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@ManyToOne
	@JsonIgnore
	private Reservation reservation;
	
	@ManyToOne
	private ServiceProvider service;

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

	public LocalDateTime getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDateTime reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getDescreption() {
		return descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public ServiceProvider getService() {
		return service;
	}

	public void setService(ServiceProvider service) {
		this.service = service;
	}

	public ServiceBooking() {
		super();
	}
	
	
	
	
}
