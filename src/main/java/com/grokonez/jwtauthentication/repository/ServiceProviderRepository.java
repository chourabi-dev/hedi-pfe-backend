package com.grokonez.jwtauthentication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grokonez.jwtauthentication.entitys.ServiceProvider;
import com.grokonez.jwtauthentication.entitys.ServicesProviderlLocation;
import com.grokonez.jwtauthentication.model.User;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider,Long> {

	List<ServiceProvider> findByLocation( ServicesProviderlLocation location );
	
	
	ServiceProvider findByUser( User user );
	
	
}
