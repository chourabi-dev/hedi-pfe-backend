package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grokonez.jwtauthentication.entitys.ServiceCategory;

public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory,Long> {

}
