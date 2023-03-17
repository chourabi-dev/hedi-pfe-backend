package com.grokonez.jwtauthentication.message.request;

import java.time.LocalDateTime;

public class BookDoctorModel {

	private LocalDateTime reservationDate;
	
	private String privateNote;

	public LocalDateTime getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDateTime reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getPrivateNote() {
		return privateNote;
	}

	public void setPrivateNote(String privateNote) {
		this.privateNote = privateNote;
	}
	
	public BookDoctorModel() {
		
	}
}
