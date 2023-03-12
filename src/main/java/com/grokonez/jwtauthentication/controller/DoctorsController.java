package com.grokonez.jwtauthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.entitys.Category;
import com.grokonez.jwtauthentication.entitys.Doctors;
import com.grokonez.jwtauthentication.message.request.CategoryModel;
import com.grokonez.jwtauthentication.message.request.DoctorModel;
import com.grokonez.jwtauthentication.message.response.JsonRes;
import com.grokonez.jwtauthentication.repository.CategoriesRepository;
import com.grokonez.jwtauthentication.repository.DoctorsRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/doctors")
public class DoctorsController {

	
	@Autowired
	private DoctorsRepository doctorsRepository;
	
	
	@Autowired
	private CategoriesRepository categoriesRepository;
	

	@GetMapping("/list")
	public List<Doctors> getALL(){
		return this.doctorsRepository.findAll();
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add( @RequestBody DoctorModel model ){
		
		Doctors d = new Doctors();
		d.setFullname(model.getFullname());
		d.setAbout(model.getAbout());
		d.setEmail(model.getEmail());
		d.setPhone(model.getPhone());
		d.setAddress(model.getAddress());
		d.setCategory( this.categoriesRepository.findById(model.getCategory()).get()  );
		
		this.doctorsRepository.save(d);
		JsonRes res = new JsonRes("Category created successfully",true);
		
		return ResponseEntity.ok(res);
	}
	
	
	
	@GetMapping("/search")
	public List<Doctors> searchByNameAndCategory( String name, long category ){
		Category c = this.categoriesRepository.findById(category).get();
		
		return this.doctorsRepository.findByFullnameContainingIgnoreCaseAndCategory(name,c);
	}
	
	
	
	
}
