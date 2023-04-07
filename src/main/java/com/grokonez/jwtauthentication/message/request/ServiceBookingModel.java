package com.grokonez.jwtauthentication.message.request;

import java.time.LocalDateTime;

public class ServiceBookingModel {

	private LocalDateTime  reservationDate;
	
	private String  descreption;
	
	private long  service;
	
	private long  reservation;

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

	public long getService() {
		return service;
	}

	public void setService(long service) {
		this.service = service;
	}

	public long getReservation() {
		return reservation;
	}

	public void setReservation(long reservation) {
		this.reservation = reservation;
	}

	public ServiceBookingModel() {
		super();
	}
	
	
	
	
	
}
