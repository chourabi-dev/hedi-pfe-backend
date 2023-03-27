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

import com.grokonez.jwtauthentication.entitys.Doctors;
import com.grokonez.jwtauthentication.entitys.Reservation;
import com.grokonez.jwtauthentication.entitys.ServiceCategory;
import com.grokonez.jwtauthentication.entitys.ServiceProvider;
import com.grokonez.jwtauthentication.entitys.ServicesProviderlLocation;
import com.grokonez.jwtauthentication.message.request.DoctorModel;
import com.grokonez.jwtauthentication.message.request.ServiceProviderModel;
import com.grokonez.jwtauthentication.message.response.JsonRes;
import com.grokonez.jwtauthentication.model.Role;
import com.grokonez.jwtauthentication.model.RoleName;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.CategoriesRepository;
import com.grokonez.jwtauthentication.repository.DoctorsRepository;
import com.grokonez.jwtauthentication.repository.NotificationsRepository;
import com.grokonez.jwtauthentication.repository.ReservationRepository;
import com.grokonez.jwtauthentication.repository.RoleRepository;
import com.grokonez.jwtauthentication.repository.ServiceCategoryRepository;
import com.grokonez.jwtauthentication.repository.ServiceProviderRepository;
import com.grokonez.jwtauthentication.repository.ServicesProviderlLocationRepository;
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
	private ServiceCategoryRepository serviceCategoryRepository;
	
	@Autowired
	private ServicesProviderlLocationRepository servicesProviderlLocationRepository;
	
	
	  @Autowired
	  private  PasswordEncoder encoder;
	    
	    @Autowired
	    private  RoleRepository roleRepository;
		
	    
	    @Autowired
	    private  UserRepository userRepository;
	    
	    
	    @Autowired
	    private  ServiceProviderRepository serviceProviderRepository;
	    
	
	 

	@GetMapping("/get-my-reservations")
	public List<Reservation> getDoctorReervations(HttpServletRequest req  ){
		 
		Optional<User> current;
        String token = req.getHeader("authorization").replace("Bearer " ,""); 
        String username=this.jwtProvider.getUserNameFromJwtToken(token);
        current=this.userRepository.findByUsername(username); 
		return this.reservationRepository.findByUser( current.get() );
	}
	
	
	
	@GetMapping("/get-reservation-by-id/{id}")
	public Reservation getReservationByID( @PathVariable long id ){ 
		return this.reservationRepository.findById(id ).get();
	}
	
	
	
	
	@GetMapping("/categories-services-list")
	public List<ServiceCategory> getServiceCategory(  ){ 
	 
		return this.serviceCategoryRepository.findAll();
	}
	
	
	@GetMapping("/categories-services-location-list")
	public List<ServicesProviderlLocation> servicesProviderlLocationLists(  ){ 
	 
		return this.servicesProviderlLocationRepository.findAll();
	}
	
 
	
	@PostMapping("/add-service-provider") 
	public ResponseEntity<?> addServiceProvider( @RequestBody ServiceProviderModel model ){
		
		ServiceProvider d = new ServiceProvider();
		d.setDescrption(model.getDescreption());
		d.setPricing(model.getPrice());
		
		
		
		d.setLocation(  this.servicesProviderlLocationRepository.findById(model.getLocation()).get()  );
		d.setCategory(  this.serviceCategoryRepository.findById(model.getCategory()).get()  );
		
		
		// create user for the doctor
		User user = new User();
		user.setUsername(model.getUsername());
		user.setPassword(encoder.encode(model.getPassword()));
		
		Set<Role> roles = new HashSet<>();
		Role adminRole = roleRepository.findByName(RoleName.ROLE_PM)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
    			roles.add(adminRole); 
    	user.setRoles(roles);
    	user.setName( model.getName() );
    	user.setEmail( model.getEmail() );
 
    	this.userRepository.save(user);
    	
    	
    	d.setUser(user);
    	
    	
		
		this.serviceProviderRepository.save(d);
		JsonRes res = new JsonRes("Service account created successfully",true); 
		return ResponseEntity.ok(res);
	}
	
	 
		@GetMapping("/service-providers") 
		public ResponseEntity<?> getservicesproviders(   ){
			
			 
			return ResponseEntity.ok(this.serviceProviderRepository.findAll());
		}
		
		
		
		 
		@GetMapping("/service-providers-by-location-of-doctor") 
		public ResponseEntity<?> getservicesproviders( long location  ){
			
			 
			ServicesProviderlLocation locationEntity = this.servicesProviderlLocationRepository.findById(location).get();
			
			return ResponseEntity.ok(this.serviceProviderRepository.findByLocation(locationEntity));
		}
		
 
	
}
