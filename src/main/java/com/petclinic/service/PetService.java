package com.petclinic.service;

import java.util.Collection;

public interface PetService {

	public Collection<com.petclinic.entity.postgres.Pet> getPetByName(String petName);
	
	public String getPetById(Integer id);
}
