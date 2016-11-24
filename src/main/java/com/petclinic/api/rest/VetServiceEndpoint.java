package com.petclinic.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petclinic.repository.springdatajpa.postgres.SpringDataVetRepository;

@RestController
public class VetServiceEndpoint {

	@Autowired
	SpringDataVetRepository vetRepository;
	
	@RequestMapping("/vet/id")
	public String getVetById(@RequestParam(value="id") Integer id){
		System.out.println("Came here in getVetById");
		return vetRepository.findById(id).toString();
	}	
}
