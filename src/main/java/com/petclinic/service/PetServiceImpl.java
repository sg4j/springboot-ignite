package com.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.petclinic.repository.springdatajpa.postgres.SpringDataPetRepository;

@Service
public class PetServiceImpl implements PetService{

	@Autowired
	SpringDataPetRepository petRepository;
	
	@Cacheable("petclinic")
	public Collection<com.petclinic.entity.postgres.Pet> getPetByName(String petName){
		System.out.println("Came here in PetServiceImpl.getPetByName");
		return petRepository.findByName(petName);
	}
	
	@Cacheable("petclinic")
	public String getPetById(Integer id){
		System.out.println("Came here in PetServiceImpl.getPetById");
		return petRepository.findById(id).toString();
	}	
	
	
}
