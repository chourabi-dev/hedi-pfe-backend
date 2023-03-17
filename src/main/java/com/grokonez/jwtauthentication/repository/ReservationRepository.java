package com.grokonez.jwtauthentication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grokonez.jwtauthentication.entitys.Doctors;
import com.grokonez.jwtauthentication.entitys.Reservation;
import com.grokonez.jwtauthentication.model.User;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

	public List<Reservation> findByDoctor(Doctors doctor);
	public List<Reservation> findByUser(User user);
	
}
