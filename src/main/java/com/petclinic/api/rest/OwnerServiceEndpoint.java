package com.petclinic.api.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petclinic.repository.springdatajpa.postgres.SpringDataOwnerRepository;

@RestController
public class OwnerServiceEndpoint {

	@Autowired
	SpringDataOwnerRepository ownerRepository;
	
	@RequestMapping("/owner/name")
	public Collection<com.petclinic.entity.postgres.Owner> getOwnerByLastName(@RequestParam(value="name") String ownerName){
		System.out.println("Came here in getOwnerByName");
		return ownerRepository.findByLastName(ownerName);
	}
	
	@RequestMapping("/owner/id")
	public String getOwnerById(@RequestParam(value="id") Integer id){
		System.out.println("Came here in getOwnerById");
		return ownerRepository.findById(id).toString();
	}	
}
