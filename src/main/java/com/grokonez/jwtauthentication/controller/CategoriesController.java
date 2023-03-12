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
import com.grokonez.jwtauthentication.message.request.CategoryModel;
import com.grokonez.jwtauthentication.message.response.JsonRes;
import com.grokonez.jwtauthentication.message.response.JwtResponse;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.*;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

	
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	
	
	@GetMapping("/list")
	public List<Category> getALL(){
		return this.categoriesRepository.findAll();
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add( @RequestBody CategoryModel model ){
		
		Category c = new Category();
		c.setLabel(model.getLabel());
		
		this.categoriesRepository.save(c);
		JsonRes res = new JsonRes("Category created successfully",true);
		
		return ResponseEntity.ok(res);
	}
}
