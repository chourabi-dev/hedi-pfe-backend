package com.grokonez.jwtauthentication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grokonez.jwtauthentication.entitys.Category;
import com.grokonez.jwtauthentication.entitys.Doctors;

public interface DoctorsRepository extends JpaRepository<Doctors,Long> {

	List<Doctors> findByFullnameContainingIgnoreCaseAndCategory( String fullname, Category category );
}
