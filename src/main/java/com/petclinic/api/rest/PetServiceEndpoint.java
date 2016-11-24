package com.petclinic.api.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petclinic.service.PetService;

@RestController
public class PetServiceEndpoint {

	@Autowired
	PetService petService;
	
	@RequestMapping("/petclinic/pet/name")
	public Collection<com.petclinic.entity.postgres.Pet> getPetByName(@RequestParam(value="name") String petName){
		System.out.println("Came here in PetServiceEndpoint.getPetByName");
		return petService.getPetByName(petName);
	}
	
	@RequestMapping("/petclinic/pet/id")
	public String getPetById(@RequestParam(value="id") Integer id){
		System.out.println("Came here in PetServiceEndpoint.getPetById");
		return petService.getPetById(id).toString();
	}	
}
