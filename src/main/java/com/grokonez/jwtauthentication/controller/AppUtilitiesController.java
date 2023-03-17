package com.grokonez.jwtauthentication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.entitys.Doctors;
import com.grokonez.jwtauthentication.entitys.Reservation;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.CategoriesRepository;
import com.grokonez.jwtauthentication.repository.DoctorsRepository;
import com.grokonez.jwtauthentication.repository.NotificationsRepository;
import com.grokonez.jwtauthentication.repository.ReservationRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.security.jwt.JwtProvider;

import jakarta.servlet.http.HttpServletRequest;
 

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/utilities")
public class AppUtilitiesController {

	@Autowired
    JwtProvider jwtProvider;

	
	@Autowired
	private DoctorsRepository doctorsRepository;
	
	
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	
	@Autowired
	private NotificationsRepository notificationsRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	
	@Autowired
    UserRepository userRepository;


	@GetMapping("/get-my-reservations")
	public List<Reservation> getDoctorReervations(HttpServletRequest req  ){
		 
		Optional<User> current;
        String token = req.getHeader("authorization").replace("Bearer " ,""); 
        String username=this.jwtProvider.getUserNameFromJwtToken(token);
        current=this.userRepository.findByUsername(username); 
		return this.reservationRepository.findByUser( current.get() );
	}
}
