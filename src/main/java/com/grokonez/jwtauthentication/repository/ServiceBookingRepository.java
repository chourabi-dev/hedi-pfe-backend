package com.grokonez.jwtauthentication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grokonez.jwtauthentication.entitys.Reservation;
import com.grokonez.jwtauthentication.entitys.ServiceBooking;
import com.grokonez.jwtauthentication.entitys.ServiceProvider;

public interface ServiceBookingRepository extends JpaRepository<ServiceBooking,Long> {

	Boolean existsByServiceAndReservation(ServiceProvider service,Reservation reservation);
	List<ServiceBooking> findByService(ServiceProvider service);
	List<ServiceBooking> findByReservation(Reservation reservation);
	
}
