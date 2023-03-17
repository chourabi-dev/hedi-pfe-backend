package com.grokonez.jwtauthentication.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.entitys.Category;
import com.grokonez.jwtauthentication.entitys.Doctors;
import com.grokonez.jwtauthentication.entitys.Notifications;
import com.grokonez.jwtauthentication.entitys.Reservation;
import com.grokonez.jwtauthentication.message.request.BookDoctorModel;
import com.grokonez.jwtauthentication.message.request.CategoryModel;
import com.grokonez.jwtauthentication.message.request.DoctorModel;
import com.grokonez.jwtauthentication.message.response.JsonRes;
import com.grokonez.jwtauthentication.model.Role;
import com.grokonez.jwtauthentication.model.RoleName;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.CategoriesRepository;
import com.grokonez.jwtauthentication.repository.DoctorsRepository;
import com.grokonez.jwtauthentication.repository.NotificationsRepository;
import com.grokonez.jwtauthentication.repository.ReservationRepository;
import com.grokonez.jwtauthentication.repository.RoleRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.security.jwt.JwtProvider;

import jakarta.servlet.http.HttpServletRequest;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/doctors")
public class DoctorsController {

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
	
	
	
	

	@GetMapping("/list")
	public List<Doctors> getALL(){
		return this.doctorsRepository.findAll();
	}
	
	
	@GetMapping("/details/{id}")
	public  ResponseEntity<?>  details( @PathVariable() long id ){ 
		return ResponseEntity.ok(this.doctorsRepository.findById(id));
	}
	
	
	
	
    @Autowired
    PasswordEncoder encoder;
    
    @Autowired
    RoleRepository roleRepository;
	
    
    @Autowired
    UserRepository userRepository;
    
    
    
	@PostMapping("/add")
	public ResponseEntity<?> add( @RequestBody DoctorModel model ){
		
		Doctors d = new Doctors();
		d.setFullname(model.getFullname());
		d.setAbout(model.getAbout());
		d.setEmail(model.getEmail());
		d.setPhone(model.getPhone());
		d.setAddress(model.getAddress());
		d.setCategory( this.categoriesRepository.findById(model.getCategory()).get()  );
		
		
		// create user for the doctor
		User user = new User();
		user.setUsername(model.getUsername());
		user.setPassword(encoder.encode(model.getPassword()));
		
		Set<Role> roles = new HashSet<>();
		Role adminRole = roleRepository.findByName(RoleName.ROLE_DOCTOR)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
    			roles.add(adminRole); 
    	user.setRoles(roles);
    	user.setName(d.getFullname());
    	user.setEmail(d.getEmail());
 
    	this.userRepository.save(user);
    	
    	
    	d.setUser(user);
    	
    	
		
		this.doctorsRepository.save(d);
		JsonRes res = new JsonRes("Doctor account created successfully",true); 
		return ResponseEntity.ok(res);
	}
	
	
	
	@GetMapping("/search")
	public List<Doctors> searchByNameAndCategory( String name, long category ){
		Category c = this.categoriesRepository.findById(category).get();
		
		return this.doctorsRepository.findByFullnameContainingIgnoreCaseAndCategory(name,c);
	}
	
	
	
	
	@GetMapping("/get-Doctor-reservations")
	public List<Reservation> getDoctorReervations(HttpServletRequest req  ){
		 
		Optional<User> current;
        String token = req.getHeader("authorization").replace("Bearer " ,""); 
        String username=this.jwtProvider.getUserNameFromJwtToken(token);
        current=this.userRepository.findByUsername(username);
         
        
        
		Doctors doc = this.doctorsRepository.findByUser(current.get());
		
		
		return this.reservationRepository.findByDoctor( doc );
	}
	
	
	
	@PostMapping("/book/doctor/{id}")
	public ResponseEntity<?> bookDoctor(HttpServletRequest req, @PathVariable long id, @RequestBody BookDoctorModel model){
	 
		Optional<User> current;
        String token = req.getHeader("authorization").replace("Bearer " ,""); 
        String username=this.jwtProvider.getUserNameFromJwtToken(token);
        current=this.userRepository.findByUsername(username);
         
		
		Reservation reservation = new Reservation();
		
		Doctors doc = this.doctorsRepository.findById(id).get();

		reservation.setDoctor(doc);
		reservation.setStatus(0);
		reservation.setUser(current.get());
		reservation.setReservationDate(model.getReservationDate());
		reservation.setPrivateNote(model.getPrivateNote());
		
		this.reservationRepository.save(reservation);
		 
		
		// send notification
		Notifications notif = new Notifications(); 
		notif.setUser(doc.getUser());
		notif.setTitle("New Booking Request");
		notif.setMessage("New Booking Request From ".concat(current.get().getName()));
		notif.setSeen(false);
		
		this.notificationsRepository.save(notif);
		
		
		
		JsonRes res = new JsonRes("Reservation created successfully",true); 
		return ResponseEntity.ok(res);
	}
	
	
	
	
}
